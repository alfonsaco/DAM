package actividadNotasAlumnos;

import java.util.Arrays;
import java.util.Scanner;

public class Alumnos {
	private String nombre;
	private String apellidos;
	private int edad;
	private Nota[] notas;
	
	// Constructores
	public Alumnos(String nombre, String apellidos, int edad, Nota[] notas) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.notas =new Nota[7];
		for (int i = 0; i < notas.length; i++) {
			notas[i]=new Nota();
		}
	}
	public Alumnos() {
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.notas = new Nota[7];
		for (int i = 0; i < notas.length; i++) {
			notas[i]=new Nota();
		}
	}
	
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Nota[] getNotas() {
		return notas;
	}
	public void setNotas(Nota[] notas) {
		this.notas = notas;
	}
	
	// toString
	@Override
	public String toString() {
		return "El alumno "+nombre+" "+apellidos+" tiene "+edad+" años";
	}
	
	public void insertarAlumno() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame el nombre del alumno: ");
		String nombre=sc.nextLine();
		this.setNombre(nombre);
		
		System.out.print("Dame los apellidos del alumno: ");
		String apellidos=sc.nextLine();
		this.setApellidos(apellidos);
		
		System.out.print("Dame su edad: ");
		int edad=sc.nextInt();
		this.setEdad(edad);
	}
}
