package Examen;

import java.sql.Connection;

import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BD {

	private static BD miInstancia = null;
	private static boolean permitirInstanciaNueva;
	private Connection conn;
	private Statement stmt;
	private String cadenaConexion; //driver@servidor:puerto:sid
	private String usuario;
	private String pass;
	
	public BD() throws Exception {
		if (!permitirInstanciaNueva) {
			throw new Exception("No se puede crear otro objeto. Usa getInstance");
		}
	}
	
	public static BD getInstance() {
		
		if (miInstancia == null) {
			permitirInstanciaNueva = true;
			try {
				miInstancia = new BD();
			} catch (Exception e) {
				e.printStackTrace();
			}
			permitirInstanciaNueva = false;
		}
		
		return miInstancia;
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public Statement getStmt() {
		return stmt;
	}
	
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
	public String getCadenaConexion() {
		return cadenaConexion;
	}
	
	public void setCadenaConexion(String cadenaConexion) {
		this.cadenaConexion = cadenaConexion;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public ResultSet consultaBD(String consulta) {
		ResultSet rset = null;
		
		try {
			this.conn = DriverManager.getConnection(this.getCadenaConexion(), this.getUsuario(), this.getPass());
			this.stmt = conn.createStatement();
			rset = stmt.executeQuery(consulta);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rset;
		
	}
	
	public void cerrarConsulta() {
		try {
			this.stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarParametrosConexionJSON() {
		try {
			Scanner entrada = new Scanner(new File("config.json"));
			String cadena;
			String conexion = ""; 
			String usuario = "";
			String contraseña = "";
			
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				if(cadena.contains("DRIVER")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length())+":"+cadena.split(":")[2]+":"+cadena.split(":")[3]+":";
				}
				if(cadena.contains("SERVIDOR")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2)+":";
				}
				if(cadena.contains("PUERTO")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2)+":";
				}
				if(cadena.contains("SID")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2);
				}
				if(cadena.contains("USUARIO")) {
					usuario=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2);
				}
				if(cadena.contains("CLAVE")) {
					contraseña=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-1);
				}
			}

			this.cadenaConexion = conexion;
			this.usuario = usuario;
			this.pass = contraseña;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			
			BD.getInstance().cargarParametrosConexionJSON();
			ResultSet rset = BD.getInstance().consultaBD("select count(*) from totalguia");
			
			// Primera consulta
			if (rset.next()) {
				System.out.println("Hay "+rset.getString(1)+" clientes");
			}
			BD.getInstance().cerrarConsulta();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
