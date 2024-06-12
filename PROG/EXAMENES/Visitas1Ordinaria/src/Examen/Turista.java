package Examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Turista extends Persona {
	private String nacionalidad;
	private String idioma;
	private Visita visita;
	
	// Constructores
	public Turista(String id, String nombre, String apellidos, String nacionalidad, String idioma, Visita visita) {
		super(id, nombre, apellidos);
		this.nacionalidad = nacionalidad;
		this.idioma = idioma;
		this.visita = visita;
	}
	public Turista() {
		super();
		this.nacionalidad = "";
		this.idioma = "";
		this.visita =new Visita();
	}
	public Turista(String id, String nombre, String apellidos, String nacionalidad, String idioma) {
		super(id, nombre, apellidos);
		this.nacionalidad = nacionalidad;
		this.idioma = idioma;
		this.visita = new Visita();
	}
	
	// Getters y Setters
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Visita getVisita() {
		return visita;
	}
	public void setVisita(Visita visita) {
		this.visita = visita;
	}
	
	// toString
	@Override
	public String toString() {
		return "Turista [nacionalidad=" + nacionalidad + ", idioma=" + idioma + ", visita=" + visita + ", id=" + id
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	// Método para cargar visitas
	public void cargarVisita(String filename) {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File(filename));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		if(linea[1].equals(this.getId())) {
        			Visita v=new Visita(linea[1],Integer.parseInt(linea[3]),linea[4],Double.parseDouble(linea[5]));
        			this.setVisita(v);
        		}
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	// Prueba unitaria
	public static void main(String[] args) {
		Turista t=new Turista();
		
		t.setId("654KJ5345");
		t.cargarVisita("visitasHoy.txt");
		System.out.println(t.getVisita());
	}
}
