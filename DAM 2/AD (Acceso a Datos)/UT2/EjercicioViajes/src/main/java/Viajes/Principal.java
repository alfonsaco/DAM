package Viajes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Principal {

	static Connection conexion=Conexion.getOracle("VIAJES", "DAM");
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion=-1;
		
		do {
			menu();
			opcion=sc.nextInt();
			
			switch (opcion) {
			case 1:
				mostrarReservas();
				break;
				
			case 2:
				crearTabla();
				break;
				
			case 3:
				insertarReservas(400, 10, 5, 1);
				break;
			
			case 0:
				System.out.println("Se finalizó el programa");
				break;
			}
			
		} while (opcion!=0);
	}

	private static void insertarReservas(int codReserva, int numPlaza, int codCliente, int codViaje) {
		String mensaje="";
		int error=0;
		
		if(reservaExiste(codReserva)) {
			error=1;
			mensaje+="\nLA RESERVA YA EXISTE";
		}
		
		if(!clienteExiste(codCliente)) {
			error=1;
			mensaje+="\nEL CLIENTE INTRODUCIDO NO EXISTE";
		}
		
		if(!viajeExiste(codViaje)) {
			error=1;
			mensaje+="\nEL VIAJE INTRODUCIDO NO EXISTE";
		}
		
		if(numPlaza < 1 || numPlaza > 60) {
			error=1;
			mensaje+="\nLA PLAZA ESTÁ FUERA DE LOS LÍMITES";
		}
		
		if(plazaOcupada(numPlaza, codViaje)) {
			error=1;
			mensaje+="\nLA PLAZA ESTÁ OCUPADA";
		}
		
		if(error == 0) {
			String insercion="insert into reservas values"+"(?,?,?,?,?)";			
			LocalDate hoy=LocalDate.now();	
			java.sql.Date fechaHoy=java.sql.Date.valueOf(hoy);
			
			try {								
				java.sql.PreparedStatement sent=conexion.prepareStatement(insercion);				
				sent=conexion.prepareStatement(insercion);
				sent.setInt(1, codReserva);
				sent.setInt(2, numPlaza);
				sent.setDate(3, fechaHoy);
				sent.setInt(4, codCliente);
				sent.setInt(5, codViaje);

				int filas = sent.executeUpdate();
				
				System.out.println("INSERCIÓN REALIZADA CON ÉXITO");
				
				sent.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("ERROR, DATOS NO SE PUDO INSERTAR");
			System.out.println(mensaje);
		}
		
	}
		

	private static boolean plazaOcupada(int numPlaza, int codViaje) {
		boolean ocupada=false;
		
		String consulta="select * from reservas where codviaje=? and numplaza=?";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codViaje);
			sent.setInt(2, numPlaza);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				ocupada=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ocupada;
	}

	private static boolean viajeExiste(int codViaje) {
		boolean existe=false;
		
		String consulta="select * from viajes where codviaje=?";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codViaje);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				existe=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	private static boolean clienteExiste(int codCliente) {
		boolean existe=false;
		String consulta="select * from clientes where codclien=?";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codCliente);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				existe=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	private static boolean reservaExiste(int codReserva) {
		String consulta="select codreserva from reservas where codreserva=?";
		boolean existe=false;
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(consulta);
			sent.setInt(1, codReserva);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				existe=true;
			}
			
		} catch (SQLException e) {
			return false;
		}
		
		return existe;
	}

	private static void crearTabla() {
		String crear="create table ESTADISTICACIUDADES as"
				+ "(select * from ciudades)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(crear);
			sent.executeUpdate();
			System.out.println("TABLA CREADA");
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("LA TABLA YA FUE CREADA ANTERIORMENTE");
		}
		
		String alter="alter table ESTADISTICACIUDADES ADD constraint EC_PK PRIMARY KEY (CIUDAD)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(alter);
			sent.executeUpdate();
			System.out.println("PK AÑADIDA");
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("LA PK YA FUE AÑADIDA ANTERIORMENTE");
		}
		
		// PRIMERA COLUMNA
		String columa1="alter table ESTADISTICACIUDADES add numviajesdestino number(5)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(columa1);
			sent.executeUpdate();
			System.out.println("NUMVIAJESDESTINO AÑADIDA");
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("NUMVIAJESDESTINO AÑADIDA ANTERIORMENTE");
		}
		
		String update1="update estadisticaciudades e set numviajesdestino="
				+ "(select count(*) from viajes where ciudaddestino LIKE e.ciudad)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(update1);
			sent.executeUpdate();
			System.out.println("NUMVIAJESDESTINO ACTUALIZADO");
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("NUMVIAJESDESTINO YA FUE ACTUALIZADO");
		}
		
		// SEGUNDA COLUMNA
		String columa2="alter table ESTADISTICACIUDADES add numviajesprocedencia number(5)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(columa2);
			sent.executeUpdate();
			System.out.println("numviajesprocedencia AÑADIDA");
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("numviajesprocedencia AÑADIDA ANTERIORMENTE");
		}
		
		String update2="update estadisticaciudades e set numviajesprocedencia="
				+ "(select count(*) from viajes where ciudadorigen LIKE e.ciudad)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(update2);
			sent.executeUpdate();
			System.out.println("NUMVIAJESPROCEDENCIA ACTUALIZADO");
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("NUMVIAJESPROCEDENCIA YA FUE ACTUALIZADO");
		}
	}

	private static void mostrarReservas() {
		String consulta="select codclien, nombre from clientes";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);				
			ResultSet rset=sent.executeQuery();
		
			int totalReserva=0;
			int totalImporte=0;
			
			int masReservas=0;
			String nombreMasReservas="";
			
			System.out.printf("%15s %30s %15s %15s %n","COD CLIENTE","NOMBRE","NUM RESERVAS","TOTAL IMPORTE");
			System.out.printf("%15s %30s %15s %15s %n","----------------","--------------------------","--------------","-------------");
						
			while(rset.next()) {
				int codClient=rset.getInt(1);
				int numReservas=numReservas(codClient);
				totalReserva+=numReservas;
				
				if(numReservas > masReservas) {
					masReservas=numReservas;
					nombreMasReservas=rset.getString(2);
				}
				
				int importe=calcularImporte(codClient);				
				totalImporte+=importe;
				
				System.out.printf("%15s %30s %15s %15s %n",rset.getInt(1), rset.getString(2), numReservas,importe+"€");				
			}
			
			System.out.printf("%15s %30s %15s %15s %n","----------------","--------------------------","--------------","-------------");
			System.out.printf("%-15s %30s %15s %15s %n","Totales: ","", totalReserva, totalImporte+"€");
			System.out.println("Cliente con más reservas: "+nombreMasReservas+"\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int calcularImporte(int codClient) {
		int importe=0;
		
		double precio=0;
		double sumar=0;
		
		double tasa=0;
		double sumarTasa=0;
		
		String consulta="select codviaje from reservas where codclien=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);	
			sent.setInt(1, codClient);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				sumar=obtenerPrecio(rset.getInt(1));
				precio+=sumar;
				
				sumarTasa=obtenerTasa(rset.getInt(1));
				tasa+=sumarTasa;
			}
			importe+=precio+tasa;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return importe;
	}

	private static double obtenerTasa(int codViaje) {
		double tasa=0;
		
		String consulta1="select ciudaddestino from viajes where codviaje=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta1);	
			sent.setInt(1, codViaje);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				
				String consulta2="select codpais from ciudades where ciudad like ?";				
				try {
					java.sql.PreparedStatement sent2=conexion.prepareStatement(consulta2);	
					sent2.setString(1, rset.getString(1));
					ResultSet rset2=sent2.executeQuery();
					while(rset2.next()) {
						
						String consulta3="select tasa from paises where codpais like ?";						
						try {
							java.sql.PreparedStatement sent3=conexion.prepareStatement(consulta3);	
							sent3.setString(1, rset2.getString(1));
							ResultSet rset3=sent3.executeQuery();
							while(rset3.next()) {
								tasa+=rset3.getFloat(1);
							}
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tasa;
	}

	private static double obtenerPrecio(int codViaje) {
		double precio=0;
		
		String consulta="select precio from viajes where codviaje=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);	
			sent.setInt(1, codViaje);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				precio+=rset.getDouble(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return precio;
	}

	private static int numReservas(int codClient) {
		int numReservas=0;
		
		String consulta="select * from reservas where codclien=?";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);	
			sent.setInt(1, codClient);
			ResultSet rset=sent.executeQuery();
			while(rset.next()) {
				numReservas++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numReservas;
	}

	private static void menu() {
		System.out.println("--------------------------------------------");
		System.out.println("1. Mostrar reservas");
		System.out.println("2. Crear tabla de estadisticas de ciudades");
		System.out.println("3. Insertar datos");
		System.out.println("0. Salir");
		System.out.println("--------------------------------------------");
	}
}
