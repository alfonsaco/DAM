package actividadContraseña;

import java.util.Scanner;

public class Password {
	private int longitud;
	private String contrasena;
	
	// Constructores
	public Password() {
		this.longitud=8;
		this.contrasena=generarPassword();
	}
	
	// Getters y setters
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	@Override
	public String toString() {
		return "Password [longitud=" + longitud + ", contrasena=" + contrasena + "]";
	}
	
	// Método para crear una contraseña
	public String generarPassword() {
		Scanner sc=new Scanner(System.in);
		String cadena="";
		do {
			System.out.print("Dame una cadena de 6 caracteres: ");
			cadena=sc.next();
		}while(cadena.length()!=6);
		String contra=cadena.substring(0,2).toUpperCase()+cadena.substring(2,6)+Math.round(Math.random()*99+1);
		return contra;
	}
}
