package Examen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarSinPasarUnParametro {
	static Connection conexion=ConexionOracle.getOracle(null, null);
	
	private static void mostrarReservas() {
		String consulta="select codclien, nombre from clientes";
		
		try {
			java.sql.PreparedStatement sent=conexion.prepareStatement(consulta);				
			ResultSet rset=sent.executeQuery();
		
			System.out.printf("%15s %30s %15s %15s %n","COD CLIENTE","NOMBRE","NUM RESERVAS","TOTAL IMPORTE");
			System.out.printf("%15s %30s %15s %15s %n","----------------","--------------------------","-----------------","-----------------");
						
			while(rset.next()) {
				int codClient=rset.getInt(1);				
				
				System.out.printf("%15s %30s %15s %15s %n",rset.getInt(1),rset.getString(2),"-----------------","-----------------");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
