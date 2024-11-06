package Examen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementoExisteONo {

	static Connection conexion=ConexionOracle.getOracle(null, null);
	
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

}
