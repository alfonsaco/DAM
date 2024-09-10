package actividadPerro;

import java.util.Random;

public class Perro {
	private String id;
	private String nombre;
	private String raza;
	private int edad;
	private boolean sobrepeso;
	
	
	// Consrtructores
	public Perro(String nombre) {
		this.nombre = nombre;
		this.id=generarId();
	}
	public Perro(String nombre, String raza, int edad) {
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.id=generarId();
	}
	
	
	// Getters y Setters
	protected String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getRaza() {
		return raza;
	}
	protected void setRaza(String raza) {
		this.raza = raza;
	}
	protected int getEdad() {
		return edad;
	}
	protected void setEdad(int edad) {
		this.edad = edad;
	}
	protected boolean isSobrepeso() {
		return sobrepeso;
	}
	protected void setSobrepeso(boolean sobrepeso) {
		this.sobrepeso = sobrepeso;
	}
	
	// toString
	@Override
	public String toString() {
		return "Nombre: "+nombre+"\nRaza: "+raza+"\nEdad"+edad;
	}
	
	
	public String generarId() {
		Random r=new Random();
		int ran=r.nextInt(20)+1;
		String id=ran+nombre.substring(0,2)+raza.substring(0,3).toUpperCase();
		return id;
	}
	
	
}
