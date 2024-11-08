package Examen;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
	static Connection conexion = Conexion.getOracle("EXAMEN", "examen");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = -1;

		do {
			menu();
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				LocalDate hoy = LocalDate.now();
				java.sql.Date fechaHoy = java.sql.Date.valueOf(hoy);

				// Inserciones
				insertarEstudiante("Pepe", "Calle Matadero", "988776653", hoy);
				insertarEstudiante(null, "Calle Inexistente", null, null);
				insertarEstudiante("John Pérez", "Calle Julián", "", hoy);
				insertarEstudiante("PEDRO SULIVAN", "Calle Madrid 26", "4567898", hoy);
				insertarEstudiante("Jaime Diaz", "Plaza España", "7534753", hoy);
				break;

			case 2:
				System.out.print("DAME UN CÓDIGO DE PROYECTO: ");
				int codigo = sc.nextInt();
				mostrarProyecto(codigo);
				break;

			case 3:
				anadirColumnas();
				actualizarColumnas();
				listarProyectos();
				break;

			case 4:
				System.out.println("Se finalizó el programa");
				break;

			default:
				System.out.println("Introduce una opción válida");
				break;
			}

		} while (opcion != 4);
	}

	private static void actualizarColumnas() {
		// Actualizar num empre
		String actualizarNUMEMPRE="update proyectos p set numempre="
				+"(select coalesce(count(*),0) from patrocina where p.codigoproyecto=codigoproyecto)";
		
		int error=0;
		
		if(fueActualizado("numempre")) {
			error=1;
		} else {
			error=0;
		}
		
		if(error==0) {
			try {
				java.sql.PreparedStatement sent=conexion.prepareStatement(actualizarNUMEMPRE);
				int lin=sent.executeUpdate();
				System.out.println("Columnas actualizadas, reg: "+ lin); 
				sent.close();		
				
			} catch (SQLException e) {
				System.out.println("LA COLUMNA NUMEMPRE YA FUE ACTUALIZADA");			
			}
		}

		
		// Actualizar importe emp
		String actualizarIMPORTEMP="update proyectos p set IMPORTEMP=(select coalesce(sum(importeaportacion),0) from patrocina where p.codigoproyecto=codigoproyecto)";
		
		if(fueActualizado("importemp")) {
			error=1;
		} else {
			error=0;
		}
		
		if(error==0) {
			try {
				java.sql.PreparedStatement sent=conexion.prepareStatement(actualizarIMPORTEMP);
				int lin=sent.executeUpdate();
				System.out.println("Columnas actualizadas, reg: "+ lin); 
				sent.close();		
				
			} catch (SQLException e) {
				System.out.println("LA COLUMNA IMPORTEMP YA FUE ACTUALIZADA");			
			}
		}

		
		// Actualizar gasto alum
		String actualizarNUMALUM="update proyectos p set numalum="
				+"(select coalesce(count(*),0) from participa where p.codigoproyecto=codigoproyecto)";
		
		if(fueActualizado("numalum")) {
			error=1;
		} else {
			error=0;
		}
		
		if(error==0) {
			try {
				PreparedStatement sent=conexion.prepareStatement(actualizarNUMALUM);
				int lin=sent.executeUpdate();
				System.out.println("Columnas actualizadas, reg: "+ lin); 
				sent.close();		
				
			} catch (SQLException e) {
				System.out.println("LA COLUMNA NUMALUM YA FUE ACTUALIZADA");			
			}
		}
	}

	private static boolean fueActualizado(String columna) {
		boolean actualizar=false; 
		
		String consulta="select count("+columna+") from proyectos";
		
		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);			
			ResultSet rset = sent.executeQuery();
			rset.next();
			int cont=rset.getInt(1);
			if(cont > 1) {
				actualizar=true;	
			}
				
			rset.close();
			sent.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return actualizar;
	}

	private static void listarProyectos() {
		String consulta="select codigoproyecto, nombre, fechainicio, fechafin, presupuesto, extraaportacion, numempre, importemp, numalum, gastoalum, gastorecur from proyectos";
		
		try {
			PreparedStatement sent=conexion.prepareStatement(consulta);				
			ResultSet rset=sent.executeQuery();
		
			System.out.printf("%5s %50s %15s %15s %20s %20s %20s %20s %15s %15s %15s %n","COD","NOMBRE","FECHAINI","FECHAFIN","PRESUPUESTO","EXTRAAPORT","NUMEMPRE","IMPORTEEMP","NUMALUM","GASTOALUM","GASTORECUR");
			System.out.printf("%5s %50s %15s %15s %20s %20s %20s %20s %15s %15s %15s %n","------","------------------------------------","------------","--------------","-----------","----------","--------------","---------------","--------------","----------------","-----------");
						
			while(rset.next()) {
				System.out.printf("%5s %50s %15s %15s %20s %20s %20s %20s %15s %15s %15s %n",rset.getInt(1),rset.getString(2),rset.getDate(3),rset.getDate(4),rset.getFloat(5),rset.getFloat(6),rset.getInt(7),rset.getFloat(8),rset.getInt(9),rset.getFloat(10),rset.getFloat(11));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void anadirColumnas() {
		// Añadir la columna numempre
		String columnaNumepre = "alter table proyectos add numempre number(6)";

		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(columnaNumepre);
			sent.executeUpdate();
			System.out.println("NUMEMPRE AÑADIDA");
			System.out.println();

		} catch (Exception e) {
			System.out.println("LA COLUMNA NUMEMPRE YA FUE AÑADIDA ANTERIORMENTE");
		}

		// Añadir la columna importemp
		String columnaImporteempt = "alter table proyectos add importemp float";

		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(columnaImporteempt);
			sent.executeUpdate();
			System.out.println("IMPORTEMP AÑADIDA");
			System.out.println();

		} catch (Exception e) {
			System.out.println("LA COLUMNA IMPORTEMP YA FUE AÑADIDA ANTERIORMENTE");
		}

		// Añadir la columna numalum
		String columnaNumalum = "alter table proyectos add numalum number(6)";

		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(columnaNumalum);
			sent.executeUpdate();
			System.out.println("NUMALUM AÑADIDA");
			System.out.println();

		} catch (Exception e) {
			System.out.println("LA COLUMNA NUMALUM YA FUE AÑADIDA ANTERIORMENTE");
		}

		// Añadir la columna numempre
		String columnaGastoalum = "alter table proyectos add gastoalum float";

		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(columnaGastoalum);
			sent.executeUpdate();
			System.out.println("GASTOALUM AÑADIDA");
			System.out.println();

		} catch (Exception e) {
			System.out.println("LA COLUMNA GASTOALUM YA FUE AÑADIDA ANTERIORMENTE");
		}

		// Añadir la columna numempre
		String columnaGastorecur="alter table proyectos add gastorecur float";

		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(columnaGastorecur);
			sent.executeUpdate();
			System.out.println("GASTORECUR AÑADIDA");
			System.out.println();

		} catch (Exception e) {
			System.out.println("LA COLUMNA GASTORECUR YA FUE AÑADIDA ANTERIORMENTE");
		}
	}

	private static void mostrarProyecto(int codigoProyecto) {
		String consulta = "select codigoproyecto, nombre, fechainicio, fechafin, presupuesto, extraaportacion from proyectos where codigoproyecto=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codigoProyecto);
			ResultSet rset = sent.executeQuery();

			while (rset.next()) {
				System.out.println("\nCOD-PROYECTO: " + rset.getInt(1) + "              NOMBRE: " + rset.getString(2));
				System.out.println("FECHA INICIO: " + rset.getDate(3) + "     FECHA FIN: " + rset.getDate(4));
				System.out.println(
						"PRESUPUESTO: " + rset.getFloat(5) + "€       EXTRAAPORTACIÓN: " + rset.getFloat(6) + "€");
				System.out.println(
						"------------------------------------------------------------------------------------");
				System.out.println("LISTA DE ENTIDADES QUE PATROCINA EL PROYECTO");
				mostrarEntidades(codigoProyecto, rset.getFloat(5));

				System.out.println("LISTA DE ESTUDIANTES QUE PARTICIPAN EN EL PROYECTO");
				int extra = (int) rset.getFloat(6);
				mostrarEstudiantes(codigoProyecto, extra);
			}

			rset.close();
			sent.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarEstudiantes(int codigoProyecto, int extra) {
		String consulta1 = "select codestudiante from participa where codigoproyecto=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta1);
			sent.setInt(1, codigoProyecto);
			ResultSet rset = sent.executeQuery();

			System.out.printf("%10s %30s %40s %15s %15s %15s %10s %n", "Cod", "Nombre", "Dirección", "CodPar",
					"Tipo aportación", "NumApt", "TotAport");
			System.out.printf("%10s %30s %40s %15s %15s %15s %10s %n", "======", "=====================",
					"========================", "============", "==============", "=======", "=======");

			String tipoApor = "";
			int codPar = 0;
			int numApt = 0;

			int totalApt = 0;

			int totAport = 0;
			int totalTotAport = 0;

			while (rset.next()) {
				int codEst = rset.getInt(1);

				String consulta2 = "select codestudiante, nombre, direccion from estudiantes where codestudiante=?";
				PreparedStatement sent2 = conexion.prepareStatement(consulta2);
				sent2.setInt(1, codEst);
				ResultSet rset2 = sent2.executeQuery();

				while (rset2.next()) {
					tipoApor = mostrarTipoApor(codEst);
					codPar = mostrarCodPar(codEst);
					numApt = mostrarNumApt(codEst);
					totAport = (extra * numApt);

					System.out.printf("%10s %30s %40s %15s %15s %15s %10s %n", rset2.getInt(1), rset2.getString(2),
							rset2.getString(3), codPar, tipoApor, numApt, totAport);
					totalApt += numApt;
					totalTotAport += totAport;
				}

				rset2.close();
				sent2.close();
			}

			System.out.printf("%10s %30s %40s %15s %15s %15s %10s %n", "======", "=====================",
					"========================", "============", "==============", "=======", "=======");
			System.out.printf("%10s %30s %40s %15s %15s %15s %10s %n %n", "TOTALES: ", "", "", "", "", totalApt,
					totalTotAport);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int mostrarNumApt(int codEst) {
		int cod = 0;

		String consulta = "select numaportaciones from participa where codestudiante=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codEst);
			ResultSet rset = sent.executeQuery();
			rset.next();
			cod = rset.getInt(1);

			rset.close();
			sent.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cod;
	}

	private static int mostrarCodPar(int codEst) {
		int cod = 0;

		String consulta = "select codparticipacion from participa where codestudiante=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codEst);
			ResultSet rset = sent.executeQuery();
			rset.next();
			cod = rset.getInt(1);

			rset.close();
			sent.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cod;
	}

	private static String mostrarTipoApor(int codEst) {
		String tipo = "";

		String consulta = "select tipoparticipacion from participa where codestudiante=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codEst);
			ResultSet rset = sent.executeQuery();
			rset.next();
			tipo = rset.getString(1);

			rset.close();
			sent.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tipo;
	}

	private static void mostrarEntidades(int codigoProyecto, float presupuesto) {
		String consulta = "select codentidad from patrocina where codigoproyecto=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codigoProyecto);
			ResultSet rset = sent.executeQuery();

			int importeTotal = 0;
			int importe = 0;
			Date fecha;
			int presupuestoTotal = 0;

			System.out.printf("%10s %30s %20s %15s %n", "Código", "Descripción", "Importe aportación",
					"Fecha aportación");
			System.out.printf("%10s %30s %20s %15s %n", "===========", "==============================",
					"===============", "===============");

			while (rset.next()) {
				int codEntidad = rset.getInt(1);

				String consulta2 = "select codentidad, descripcion from entidades where codentidad=?";
				PreparedStatement sent2 = conexion.prepareStatement(consulta2);
				sent2.setInt(1, codEntidad);
				ResultSet rset2 = sent2.executeQuery();

				while (rset2.next()) {
					importe = selecccionarImporte(rset2.getInt(1));
					fecha = seleccionaFecha(rset2.getInt(1));

					System.out.printf("%10s %30s %20s %15s %n", rset2.getInt(1), rset2.getString(2), importe + "€",
							fecha);
					importeTotal += importe;
				}

				rset2.close();
				sent2.close();
			}

			presupuestoTotal += presupuesto + importeTotal;
			System.out.printf("%10s %30s %20s %15s %n", "===========", "==============================",
					"===============", "===============");
			System.out.printf("%20s %25s %15s %n", "TOTAL APORTACIONES: ", "", importeTotal + "€");
			System.out.printf("%20s %25s %15s %n", "PRESUPUESTO TOTAL: ", "", presupuestoTotal + "€");
			System.out
					.println("------------------------------------------------------------------------------------\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Date seleccionaFecha(int codEnt) {
		Date fecha = null;

		String consulta = "select fechaaportacion from patrocina where codentidad=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codEnt);
			ResultSet rset = sent.executeQuery();
			rset.next();
			fecha = rset.getDate(1);

			rset.close();
			sent.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fecha;
	}

	private static int selecccionarImporte(int codEnt) {
		int importe = 0;

		String consulta = "select importeaportacion from patrocina where codentidad=?";

		try {
			PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codEnt);
			ResultSet rset = sent.executeQuery();
			rset.next();
			importe = rset.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return importe;
	}

	// Método para insertar estudiantes
	private static void insertarEstudiante(String nombre, String direccion, String telefono, LocalDate hoy) {
		String mensaje = "";
		int error = 0;

		// Evitar datos vacíos
		if (nombre == null || direccion == null || telefono == null || hoy == null || nombre.equals("")
				|| direccion.equals("") || telefono.equals("")) {
			error = 1;
			mensaje += "LOS DATOS NO PUEDEN ESTAR VACÍOS, COMPRUEBA DATOS";
		}

		// Evitar nombres repetidos
		if (nombreRepetido(nombre)) {
			error = 1;
			mensaje += "YA EXISTE UN ESTUDIANTE CON ESE NOMBRE, NO SE HA PODIDO INSERTAR";
		}

		if (error == 0) {
			Date fecha = Date.valueOf(hoy);
			String insercion = "insert into estudiantes values" + "(?,?,?,?,?)";
			String codigoMax = "select max(codestudiante+1) from estudiantes";

			try {
				// Buscar el código maximo
				PreparedStatement sent = conexion.prepareStatement(codigoMax);
				ResultSet rset = sent.executeQuery();
				rset.next();
				int codigo = rset.getInt(1);

				sent = conexion.prepareStatement(insercion);
				sent = conexion.prepareStatement(insercion);

				sent.setInt(1, codigo);
				sent.setString(2, nombre);
				sent.setString(3, direccion);
				sent.setString(4, telefono);
				sent.setDate(5, fecha);

				int filas = sent.executeUpdate();

				System.out.println("\nESTUDIANTE INSERTADO CORRECTAMENTE CON EL CÓDIGO " + codigo);

				sent.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("\nERROR, NO SE PUDO REALIZAR LA INSERCIÓN.");
			System.out.println(mensaje);
		}
	}

	// Método para verificar si el nombre está repetido o no
	private static boolean nombreRepetido(String nombre) {
		boolean existe = false;

		String consulta = "select * from estudiantes where nombre like ?";

		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setString(1, nombre);
			ResultSet rset = sent.executeQuery();
			if (rset.next()) {
				existe = true;
			}

			rset.close();
			sent.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existe;
	}

	// Menú con las diferentes opciones
	private static void menu() {
		System.out.println("------------------------------------------");
		System.out.println("OPERACIONES CON PROYECTOS. Realizado por Alfonso Rincón");
		System.out.println("1. EJERCICIO 1: Insertar estudiantes");
		System.out.println("2. EJERCICIO 2: Listar proyecto");
		System.out.println("3. EJERCICIO 3: Añadir columnas y actualizar con datos nuevos");
		System.out.println("4. Salir");
		System.out.println("------------------------------------------");
	}
}
