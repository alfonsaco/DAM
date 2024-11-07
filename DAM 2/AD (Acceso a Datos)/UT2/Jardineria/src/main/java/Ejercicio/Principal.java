package Ejercicio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Principal {
	
	// Conexión a Oracle. Accedmos a la clase Conexión y le pasamos el usuario y contraseña
	static Connection conexion=Conexion.getOracle("JARDINERIA","DAM");
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion=-1;
		
		do {
			menu();
			
			// Try catch para evitar que se introduzcan valores inválidos, como letras
			try {
				opcion=sc.nextInt();	
			} catch (InputMismatchException e) {
				opcion=99;
				sc.next();
			}			
			
			switch (opcion) {
			case 0:
				System.out.println("PROGRAMA FINALIZADO");
				break;
				
			case 1:				
				insertarEmpleado("Nombre1", "apellido1", "apellido2", "Ext 1", "nombre1@correo.es", "ofi1", 9999,
						"Puesto1");
				insertarEmpleado("Nombre1", "apellido1", "apellido2", "Ext 1", "nombre1@correo.es", "TAL-ES", 1,
						"Puesto1");
				break;
				
			case 2:
				System.out.println("DAME UN CLIENTE: ");
				int cliente=sc.nextInt();
				visualizarPedidos(cliente);
				break;
				
			case 3:
				crearTablaClientes();
				break;
			
			case 4:
				actualizarEmpleados();
				break;
			
			case 5:
				stockActualizado();
				break;
			
			case 6:
				oficinasFuncionAlmacenada();
				break;
			
			case 8:
				nuevosEmpleados();
				break;
			}
				
			
		} while (opcion != 0);
	}

	private static void nuevosEmpleados() {
		String consulta="insert into empleados select * from nuevosempleados"
				+ "where codigoempleado not in (select codigoempleado from empleados)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.executeUpdate();
			System.out.println("EMPLEADOS AGREGADOS CON ÉXITO");
			
		} catch (SQLException e) {
			System.out.println("LOS EMPLEADOS YA FUERON AÑADIDOS ANTERIORMENTE");
		}
	}

	private static void actualizarNuevosEmpleados() {
			// Crear la columna en la tabla EMPLEADOS
			String alter="alter table nuevosempleados add numclientes number(5)";
			
			try {
				java.sql.PreparedStatement sent = conexion.prepareStatement(alter);
				sent.executeUpdate();
				System.out.println("Columna NUMCLIENTE creada");
				
			} catch (SQLException e) {
				System.out.println("La columna NUMCLIENTE ya existe");
			}
			
			// Almacenar número de clientes en la tabla
			/* 
			 * LA CONSULTA DE ESTO SERÍA LA SIGUIENTE
			 *   select e.codigoempleado, count(*) 
			 * 	    	from empleados e 
			 *   left join clientes c on c.codigoempleadorepventas=e.codigoempleado 
			 * 		    group by e.codigoempleado;
			 * 
			 */
			String actualizar="update nuevosempleados emple set NUMCLIENTES ="+
				"( select count(*) from clientes where codigoempleadorepventas = emple.codigoempleado)";
			
			try {
				java.sql.PreparedStatement sent = conexion.prepareStatement(actualizar);
				int lin=sent.executeUpdate();
				System.out.println("Numclientes actualizados"+lin);
				
				sent.close();
				
			} catch (SQLException e) {
				System.out.println("Los empleados ya fueron actualizados");
			}
		
	}

	private static void oficinasFuncionAlmacenada() {
		
	}

	private static void stockActualizado() {
		String añadirColumna="alter table productos add stockactualizado number(6)";		
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(añadirColumna);
			sent.executeUpdate();
			System.out.println("Columna STOCKACTUALIZADO añadida");			
			
		} catch (SQLException  e) {
			System.out.println("La columna STOCKACTUALIZADO ya está creada");
		}
		
		String actualizar="update productos p set STOCKACTUALIZADO = "
		+ "CANTIDADENSTOCK - (select coalesce(sum(cantidad),0) from detallepedidos where codigoproducto = p.codigoproducto)";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(actualizar);
			int lin = 	sent.executeUpdate();
			System.out.println("Columnas actualizadas, reg: "+ lin); 
			sent.close();		
			
		} catch (SQLException e) {
			System.out.println("Los elementos ya fueron actualizados anteriormente");
			
		}
		
		String mostrar="select codigoproducto, cantidadenstock, stockactualizado from productos where stockactualizado < 5";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(mostrar);
			sent.executeUpdate();
			ResultSet rset=sent.executeQuery();
			
			System.out.printf("%15s %15s %20s %n","CÓDIGO PRODUCTO","CANTIDAD STOCK","STOCK ACTUALIZADO");
			System.out.printf("%15s %15s %20s %n","-------------","---------------","------------------");
			while(rset.next()) {
				System.out.printf("%15s %15s %20s %n",rset.getString(1),rset.getInt(2),rset.getInt(3));				
			}
						
			sent.close();		
			
		} catch (SQLException e) {
			System.out.println("Hubo un error en la consulta");			
		}
		
	}

	private static void actualizarEmpleados() {
		// Crear la columna en la tabla EMPLEADOS
		String alter="alter table empleados add numclientes number(5)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(alter);
			sent.executeUpdate();
			System.out.println("Columna NUMCLIENTE creada");
			
		} catch (SQLException e) {
			System.out.println("La columna NUMCLIENTE ya existe");
		}
		
		// Almacenar número de clientes en la tabla
		/* 
		 * LA CONSULTA DE ESTO SERÍA LA SIGUIENTE
		 *   select e.codigoempleado, count(*) 
		 * 	    	from empleados e 
		 *   left join clientes c on c.codigoempleadorepventas=e.codigoempleado 
		 * 		    group by e.codigoempleado;
		 * 
		 */
		String actualizar="update empleados emple set NUMCLIENTES = \"\r\n"
				+ "				+ \" ( select count(*) from clientes where codigoempleadorepventas = emple.codigoempleado)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(actualizar);
			int lin=sent.executeUpdate();
			System.out.println("Numclientes actualizados"+lin);
			
			sent.close();
			
		} catch (SQLException e) {
			System.out.println("Los empleados ya fueron actualizados");
		}
	}

	private static void crearTablaClientes() {
		// Crear tabla, para meter ahí todos los clientes sin pedido
		String crear="create table clientessinpedido as "
				+ "select * from clientes where codigocliente not in (select codigocliente from pedidos) order by codigocliente";
		// Añadir PK a la table
		String alter="alter table clientessinpedido add constraint CSP_PK PRIMARY KEY (codigocliente)";
		// Borrar clientes sin pedidos de la tabla original (clientes)
		String borrar="delete from clientes where codigocliente not in (select codigocliente from pedidos)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(crear);
			sent.executeUpdate();
			System.out.println("TABLA CLIENTESSINPEDIDO CREADA");
			System.out.println();
			
			sent= conexion.prepareStatement(alter);
			sent.executeUpdate();
			System.out.println("PK AGREGADA CON ÉXITO");
			System.out.println();

			sent= conexion.prepareStatement(borrar);
			sent.executeUpdate();
			System.out.println("CLIENTES SIN PEDIDOS BORRADOS EXITOSAMENTE");
			System.out.println();
			
			sent.close();
			
		} catch (SQLException e) {
			System.out.println("TABLA YA CREADA, REGISTROS YA BORRADOS");
		}
		
	}

	private static void visualizarPedidos(int cliente) {
		if(clienteExiste(cliente)) {
			if(clienteTienePedidos(cliente)) {
				String consulta1="select nombrecliente, lineadireccion1 from clientes where codigocliente=?";
				
				try {					
					java.sql.PreparedStatement sent=conexion.prepareStatement(consulta1);
					sent.setInt(1, cliente);
					ResultSet rset=sent.executeQuery();
					rset.next();
					
					System.out.printf("COD-CLIENTE: %s                    NOMBRE: %s %n", cliente, rset.getString(1));
					System.out.println("DIRECCIÓN: "+rset.getString(2)+"         Número de pedidos: ");
					System.out.println("------------------------------------------------------------------------------------------------------ ");
					
					listaPedidos(cliente);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else {
				System.out.println("El cliente no tiene pedidos");
			}
			
		} else {
			System.out.printf("El cliente %s no existe", cliente);
		}
	}

	private static void listaPedidos(int cliente) {
		String consulta="select codigopedido, fechapedido, estado from pedidos where codigocliente=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, cliente);
			ResultSet rset=sent.executeQuery();
			
			
			while(rset.next()) {
				System.out.println("COD-PEDIDO: "+rset.getInt(1)+"   FECHA PEDIDO: "+rset.getDate(2)+"   ESTADO: "+rset.getString(3));
				int codPedido=rset.getInt(1);
				
				listaProductos(codPedido);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void listaProductos(int codPedido) {
		String consulta="select numerolinea, codigoproducto, cantidad, preciounidad from detallepedidos where codigopedido=?";
		double importe=0;
		int cantidad=0;
		double precio=0;
		
		String consultaNombre="select nombre from productos where codigoproducto=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, codPedido);
			ResultSet rset=sent.executeQuery();
			
			System.out.printf("%10s %10s %50s %10s %10s %10s %n","NUM-LINEA","COD-PROD","NOMBRE PRODUCTO","CANTIDAD","PREC-UNID","IMPORTE");
			System.out.println("------------------------------------------------------------------------------------------------------ ");
			
			while(rset.next()) {
				cantidad=rset.getInt(3);
				precio=rset.getDouble(4);
				importe=precio*cantidad;
				
				
				java.sql.PreparedStatement sent2=conexion.prepareStatement(consultaNombre);
				sent2.setString(1, rset.getString(2));
				ResultSet rset2=sent2.executeQuery();
				rset2.next();
				
				System.out.printf("%10s %10s %50s %10s %10s %10s %n",rset.getInt(1),rset.getString(2),rset2.getString(1),rset.getInt(3),rset.getDouble(4),importe);
			}
			
			System.out.println("------------------------------------------------------------------------------------------------------ ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean clienteTienePedidos(int cliente) {
		boolean existe=false;
		String consulta="select count(*) from pedidos where codigocliente=?";
	
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, cliente);
			ResultSet rset=sent.executeQuery();
			rset.next();
			if(rset.getInt(1) > 0) {
				existe=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	private static boolean clienteExiste(int cliente) {
		boolean existe=false;
		
		String consulta="select * from clientes where codigocliente=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, cliente);
			ResultSet rest=sent.executeQuery();
			if(rest.next()) {
				existe=true;
			}
			rest.close();
			sent.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	private static void insertarEmpleado(String n, String a1p, String a2p, String ext, String email, String codOf,
			int codJefe, String puesto) {
		String mensaje="";
		int error=0;
		
		if(!verificarJefe(codJefe)) {
			mensaje+="CODJEFE NO DISPONIBLE";
			error=1;
		}
		
		if(!verificarOficina(codOf)) {
			mensaje+="COD OFICiNA NO DISPONIBLE";
			error=1;
		}
		
		if(error == 0) {
			String insercion="insert into empleados values"+"(?,?,?,?,?,?,?,?,?)";
			String codigoMax="select max(codigoempleado+1) from empleados";
			
			java.sql.PreparedStatement sent;
			try {								
				sent=conexion.prepareStatement(codigoMax);				
				ResultSet res=sent.executeQuery(codigoMax);
				res.next();
				int codigoEmpleado=res.getInt(1);

				sent=conexion.prepareStatement(insercion);
				sent.setInt(1, codigoEmpleado);
				sent.setString(2, n);
				sent.setString(3, a1p);
				sent.setString(4, a2p);
				sent.setString(5, ext);
				sent.setString(6, email);
				sent.setString(7, codOf);
				sent.setInt(8, codJefe);
				sent.setString(9, puesto);

				int filas = sent.executeUpdate();
				
				System.out.println("INSERCIÓN REALIZADA CON ÉXITO");
				
				res.close();
				sent.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("ERROR, DATOS SE PUDO INSERTAR");
			System.out.println(mensaje);
		}
		
	}

	private static boolean verificarOficina(String codOf) {
		boolean existe=false;
		
		String consulta="select count(*) from oficinas where codigooficina=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setString(1, codOf);
			ResultSet rset=sent.executeQuery();
			rset.next();
			if(rset.getInt(1) == 1) {
				existe=true;
			}
			
			rset.close();
			sent.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	private static boolean verificarJefe(int codigoJefe) {
		boolean existe=false;
		
		String consulta="select * from empleados where codigoempleado=?";
				
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);
			sent.setInt(1, codigoJefe);
			ResultSet rset=sent.executeQuery();
			if(rset.next()) {
				existe=true;
			}
			rset.close();
			sent.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	// Imprimir menú
	private static void menu() {
		System.out.println("-------------------------------------------------------------------------");		
		System.out.println("1. Insertar Empleado ");
		System.out.println("2. Visualizar pedidos de un cliente.");  
		System.out.println("3. Crear clientes sin pedido.");  
		System.out.println("4. Actualizar Clientes por empleado.");
		System.out.println("5. Crear STOCKACTUALIZADO.");
		System.out.println("6. Oficinas con función almacenada.");
		System.out.println("7. Ver los pedidos de todos los clientes.");
		System.out.println("8. Tratar nuevos empleados.");
		System.out.println("0. SALIR.");
		System.out.println("-------------------------------------------------------------------------");
	}
}
