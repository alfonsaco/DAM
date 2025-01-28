package Clases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	// Método para conectar con la base de datos de Oracle
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; 
    private static final String USUARIO = "PROYECTOS";
    private static final String CONTRASEÑA = "PROYECTOS";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos Oracle: " + e.getMessage());
            return null;
        }
    }
}