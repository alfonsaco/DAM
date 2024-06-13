package Examen;

import java.sql.Connection;

import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	public void cargarParametrosConexion() {
		
		try {
			Scanner entrada = new Scanner(new File("configTienda.txt"));
			String cadena;
			String conexion = ""; 
			String usuario = "";
			String contraseña = "";
			
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();
				
				// DRIVER
				if (cadena.contains("conection")) {
					conexion += cadena.split("=")[1];
				}
				
				// USUARIO
				if (cadena.contains("user")) {
					usuario = cadena.split("=")[1];
				}
				
				// CLAVE
				if (cadena.contains("pass")) {
					contraseña = cadena.split("=")[1];
				}
				
			}

			this.cadenaConexion = conexion;
			this.usuario = usuario;
			this.pass = contraseña;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente>cargarClientes() {
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();
		
		try {
			
			BD.getInstance().cargarParametrosConexion();
			ResultSet rset = BD.getInstance().consultaBD("select * from persona");
			
			// Obtener valores de la BD para insertarlo en un ArrayList
			while (rset.next()) {
				clientes.add(new Cliente(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),""));
			}
			BD.getInstance().cerrarConsulta();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public static void main(String[] args) {
		try {
			
			BD.getInstance().cargarParametrosConexion();
			ResultSet rset = BD.getInstance().consultaBD("select count(*) from persona");
			
			// Primera consulta
			if (rset.next()) {
				System.out.println("Hay "+rset.getString(1)+" clientes");
			}
			BD.getInstance().cerrarConsulta();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BD bd=BD.getInstance();
		ArrayList<Cliente> clientes=bd.cargarClientes();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
}
