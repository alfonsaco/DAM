package Examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Guia extends Persona {
	private String titulacion;
	private int añosExperiencia;
	private ArrayList<Turista> turistas;
	
	// Constructores
	public Guia(String id, String nombre, String apellidos, String titulacion, int añosExperiencia,
			ArrayList<Turista> turistas) {
		super(id, nombre, apellidos);
		this.titulacion = titulacion;
		this.añosExperiencia = añosExperiencia;
		this.turistas = turistas;
	}
	public Guia() {
		super();
		this.titulacion = "";
		this.añosExperiencia = 0;
		this.turistas = new ArrayList<Turista>();
	}
	public Guia(String id, String nombre, String apellidos, String titulacion, int añosExperiencia) {
		super(id, nombre, apellidos);
		this.titulacion = titulacion;
		this.añosExperiencia = añosExperiencia;
		this.turistas =new ArrayList<Turista>();
	}
	
	// Getters y Setters
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public int getAñosExperiencia() {
		return añosExperiencia;
	}
	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	public ArrayList<Turista> getTuristas() {
		return turistas;
	}
	public void setTuristas(ArrayList<Turista> turistas) {
		this.turistas = turistas;
	}
	
	// toString
	@Override
	public String toString() {
		return "Guia [titulacion=" + titulacion + ", añosExperiencia=" + añosExperiencia + ", turistas=" + turistas
				+ ", id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	// Método para cargar turistas en el ArrayList
	public void cargarTuristas(String filename) {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File(filename));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		if(!linea[1].isEmpty() && linea[0].equals(this.getId())) {
        			Turista t=new Turista(linea[1],linea[2],linea[3],linea[6],linea[7]);
        			t.cargarVisita("visitasHoy.txt");
            		turistas.add(t);
        		}
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	public void crearEntradas() {
		File directorio=new File(this.getId());
		if(!directorio.exists()) {
			directorio.mkdir();
		}
		
		try {
			PrintWriter salida;
			for (Turista t : turistas) {
				salida = new PrintWriter(new File(directorio,"Entrada"+t.getId()+".txt"));
				salida.println("Visita guiada a la Alhambra y al Generalife");
				// Fecha
				LocalDateTime hoy=LocalDateTime.now();
				DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("EEEE"+" "+"dd-MMMM-YYYY HH:mm:ss");
				String fechaFinal = hoy.format(fechaFormato);
				salida.println("Fecha y hora de la impresión: "+fechaFinal);
				
				// Datos
				salida.println("Guia titulado: "+this.getNombre()+" "+this.getApellidos());
				salida.println("Nº Entrada: "+t.getId());
				salida.println(t.getNombre()+" "+this.getApellidos());
				salida.println("Hora visita: "+t.getVisita().getHoraVisita());
				salida.println("Idioma: "+t.getIdioma());
				salida.println("\n\t\tIMPORTE TOTAL: "+t.getVisita().getPrecio()+"€");
				
				salida.flush();
				salida.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Pruebas unitarias
	public static void main(String[] args) {
		Guia g=new Guia();
		
		g.setId("200");
		g.cargarTuristas("personas.csv");
		for (Turista t : g.getTuristas()) {
			System.out.println(t);
		}
		
		g.crearEntradas();
	}
}
