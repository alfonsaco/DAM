package Examen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {

	
	/*
	 *  MÉTODO PARA CONECTARNOS CON LA BASE DE DATOS EN ORACLE
	 */
	
	public static Connection getOracle(String usuario, String pass) {
		Connection conexion = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", usuario, pass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return conexion;
	}
	
	/*
	 *  FIN DEL MÉTODO PARA CONECTARNOS CON LA BASE DE DATOS EN ORACLE
	 */

	
}
