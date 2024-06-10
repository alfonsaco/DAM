package Matricula;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Alumno extends Persona {
	private ArrayList<Nota> notas;

	public Alumno(int codigo, String dNI, String nombre, String apellidos, ArrayList<Nota> notas) {
		super(codigo, dNI, nombre, apellidos);
		this.notas = notas;
	}
	public Alumno() {
		super();
		this.notas =new ArrayList<Nota>();
	}
	public Alumno(int codigo, String dNI, String nombre, String apellidos) {
		super(codigo, dNI, nombre, apellidos);
		this.notas =new ArrayList<Nota>();
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	
	
	@Override
	public String toString() {
		return "Alumno [notas=" + notas + ", codigo=" + codigo + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos="
				+ apellidos + "]";
	}

	public void cargarNotas() {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File("matricula.csv"));
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		this.getNotas().add(new Nota(Integer.parseInt(linea[0]),linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Alumno a=new Alumno();
		a.cargarNotas();
	}
	

	
	
	
	
	

}
