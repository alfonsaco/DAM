package pruebasentencias;

import java.sql.*;

public class Conexiones {

	public static Connection getMysql(String bd, String usuario, String pass) {

		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + bd, usuario, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("ERROR DRIVER: "+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("ERROR SQLException: "+e.getMessage());
		}
		return conexion;

	}

	public static Connection getMariaDB(String bd, String usuario, String pass) {

		Connection conexion = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/" + bd, usuario, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;

	}

	public static Connection getOracle(String usuario, String pass) {

		Connection conexion = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", usuario, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;

	}

	public static Connection getSQlite(String bd) {

		Connection conexion = null;
		try {
			// modelo de bd ".\\basedatos\\ejemplo.db"
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:" + bd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;

	}

	public static Connection getDerby(String bd) {

		Connection conexion = null;
		try {
			// modelo de bd ".\\basedatos\\bdderby\\ejemplo"
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conexion = DriverManager.getConnection("jdbc:derby:" + bd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;

	}
}