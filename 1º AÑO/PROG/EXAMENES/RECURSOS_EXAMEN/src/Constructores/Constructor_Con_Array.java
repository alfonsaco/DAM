package notasAlumnos;

import java.util.Scanner;
import java.util.Arrays;

public class Alumno {
	private String nombre;
	private String apellidos;
	private int edad;
	private Nota[]notas;
	
	//CONSTRUCTOR
	
	public Alumno() {
		this.nombre="";
		this.apellidos="";
		this.edad=0;
		this.notas=new Nota[7];//int []numeros=new int[7];
		for(int i=0; i<notas.length; i++) {
			notas[i]=new Nota();
		}
		
	}
	public Alumno(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.notas =new Nota[7];
		for(int i=0; i<notas.length; i++) {
			notas[i]=new Nota();
		}
	}


	
	

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



	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", notas="
				+ Arrays.toString(notas) + "]";
	}
