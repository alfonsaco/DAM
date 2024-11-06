package Examen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actualizar {

	static Connection conexion=ConexionOracle.getOracle(null, null);
	/*
	 *  EJEMPLO 1
	 */
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
	
	/*
	 *   EJEMPLO 2
	 */
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
}

