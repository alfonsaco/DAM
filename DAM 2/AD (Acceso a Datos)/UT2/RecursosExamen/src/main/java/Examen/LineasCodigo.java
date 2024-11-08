package Examen;

import java.sql.*;

public class LineasCodigo {

	static Connection conexion=ConexionOracle.getOracle(null, null);
	
	public static void main(String[] args) {
		String consulta="";
		String codigoMax="";
		
		
		// ---------------------------------------------------
		try {	
			PreparedStatement sent=conexion.prepareStatement(consulta);
			sent=conexion.prepareStatement(codigoMax);				
			ResultSet res=sent.executeQuery(codigoMax);
			res.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ---------------------------------------------------
	}
}
