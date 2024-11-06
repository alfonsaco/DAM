package Empresa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	static Connection conexion=Conexion.getOracle("EMPRESA", "DAM");
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion=-1;
		
		do {
			menu();
			opcion=sc.nextInt();
			
			switch(opcion) {
			case 1:
				System.out.print("DAME UN CÓDIGO DE EMPRESA: ");
				int codDep=sc.nextInt();
				visualizarEmpresa(codDep);
				break;
			
			case 2:
				eliminarEmpresas();
				break;
				
			case 3:
				anadirNumEmple();
				break;
				
			case 0:
				System.out.println("Se finalizó el programa");
				break;
			}
		} while (opcion!=0);
	}

	private static void anadirNumEmple() {
		// Añadir la columna
		String add="alter table oficios add numeple number(5)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(add);
			sent.executeUpdate();
			System.out.println("COLUMNA AÑADIDA CON ÉXITO");
			
		} catch (Exception e) {
			System.out.println("LA COLUMNA YA FUE AÑADIDA CON ANTERIORIDAD");
			
		}
		
		// Actualizar la tabla
		String consulta="update oficios o set numeple="
				+ "(select count(codoficio) from empleados e where o.codoficio=codoficio)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			int lin=sent.executeUpdate();
			System.out.println("Líneas actualizadas: "+lin);					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void eliminarEmpresas() {
		String crear="create table empresassindepar as select * from empresas where codempre not in (select codempre from departamentos) order by codempre";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(crear);
			sent.executeUpdate();
			System.out.println("LA EMPRESASSINDEPAR CREADA");
			
		} catch (SQLException e) {
			System.out.println("EMPRESA YA CREADA");
		}
		
		String alter="alter table empresassindepar add constraint ESD_PK PRIMARY KEY (codempre)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(alter);
			sent.executeUpdate();
			System.out.println("PK AÑADIDA");
			
		} catch (Exception e) {
			System.out.println("PK YA AGREGADA ANTERIORMENTE");
		}
		
		String borrar="delete from empresas where codempre not in (select codempre from departamentos)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(borrar);
			sent.executeUpdate();
			System.out.println("EMPRESAS SIN DEPARTAMENTOS BORRADAS DE LA TABLA EMPRESA");
			
		} catch (SQLException e) {
			System.out.println("EMPRESAS BORRADAS ANTERIORMENTE");
		}
		System.out.println();
		
	}

	// Método para visualizar los departamentos, según un código
	private static void visualizarEmpresa(int codEmpre) {
		if(empresaExiste(codEmpre)) {
			String obtenerNombre="select nombre, direccion from empresas where codempre=?";
			String numDep="select count(*) from departamentos where codempre=?";
			
			try {
				java.sql.PreparedStatement sent1=conexion.prepareStatement(numDep);
				sent1.setInt(1, codEmpre);
				ResultSet rset2=sent1.executeQuery();
				rset2.next();
				int numDepartamentos=rset2.getInt(1);
				
				java.sql.PreparedStatement sent=conexion.prepareStatement(obtenerNombre);
				sent.setInt(1, codEmpre);
				ResultSet rset=sent.executeQuery();
				rset.next();
				
				System.out.println("\n------------------------------------------------------------------------------------");
				System.out.println("COD-EMPRESA: "+codEmpre+"                                    NOMBRE:"+rset.getString(1));
				System.out.println("DIRECCIÓN: "+rset.getString(2)+"             NÚMERO DEPARTAMENTOS: "+numDepartamentos);
				System.out.println("-------------------------------------------------------------------------------------");
				
				visualizarDepartamentos(codEmpre);				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("LA EMPRESA NO EXISTE");
		}
	}

	// Método para visualizar los departamentos, que se usará en el de visualizar Empresa
	private static void visualizarDepartamentos(int codEmpre) {		
		String consulta="select coddepart,nombre,localidad from departamentos where codempre=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, codEmpre);
			ResultSet rset=sent.executeQuery();
			
			while(rset.next()) {
				System.out.println("\tCOD-DEPARTAMENTO: "+rset.getInt(1)+"    NOMBRE: "+rset.getString(2)+"    LOCALIDAD: "+rset.getString(3));
				visualizarEmpleados(rset.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void visualizarEmpleados(int codDep) {
		String consulta="select codemple,nombre,codoficio,codencargado from empleados where coddepart=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, codDep);
			ResultSet rset=sent.executeQuery();
			
			System.out.printf("\t\t %15s %15s %25s %15s %n","COD-EMPLEADO","NOMBRE","OFICIO","NOMBRE ENCARGADO");
			System.out.printf("\t\t %15s %15s %25s %15s %n","------------","------------","--------------------","-------------");
			
			while(rset.next()) {
				String oficio=visualizarOficio(rset.getInt(3));
				String nombreEncargado=visualizarEncargado(rset.getInt(4));
				
				System.out.printf("\t\t %15s %15s %25s %15s %n",rset.getInt(1),rset.getString(2),oficio,nombreEncargado);	
			}
			System.out.printf("\t\t %15s %15s %25s %15s %n","------------","------------","--------------------","-------------");
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static String visualizarEncargado(int codEnc) {
		String encargado="";
		String consulta="select nombre from empleados where codemple=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, codEnc);
			ResultSet rset=sent.executeQuery();
			if(rset.next()) {
				encargado=rset.getString(1);	
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return encargado;
	}

	private static String visualizarOficio(int codOfi) {		
		String oficio="";
		String consulta="select nombre from oficios where codoficio=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, codOfi);
			ResultSet rset=sent.executeQuery();
			rset.next();
			oficio=rset.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return oficio;
	}

	// Método para verificar la existencia de la empresa
	private static boolean empresaExiste(int codDep) {
		boolean existe=false;
		
		String consulta="select * from empresas where codempre=?";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codDep);
			ResultSet rset=sent.executeQuery();
			if(rset.next()) {
				existe=true;
			}
			
			sent.close();
			rset.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	// Menu para imprimir
	private static void menu() {
		System.out.println("----------------------------------------------------------");
		System.out.println("1. Visualizar departamentos");
		System.out.println("2. Eliminar empresas sin departamentos");
		System.out.println("3. Agregar número de empleados a OFICIOS");
		System.out.println("0. Salir");
		System.out.println("----------------------------------------------------------");
	}
	
}
