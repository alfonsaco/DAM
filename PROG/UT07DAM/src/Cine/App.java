package Cine;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

public class App {
	private ArrayList<Pelicula> peliculas;

	// Constructor
	public App() {
		this.peliculas =new ArrayList<Pelicula>();
	}

	// Getters y Setters
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	// Primero, importamos el fichero cine.csv para cargar las películas
	public void cargarPeliculas(String fichero) throws FileNotFoundException {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File(fichero));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		this.getPeliculas().add(new Pelicula(Integer.parseInt(linea[0]),linea[1],linea[2],linea[3]));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	// Main
	public static void main(String[] args) throws FileNotFoundException {
		App app=new App();
		Scanner sc=new Scanner(System.in);
		app.cargarPeliculas("cine.csv");
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion){
				case 1:
					System.out.print("Año: ");
					int año=sc.nextInt();
					System.out.print("Director: ");
					String dir=sc.next();
					System.out.print("Género: ");
					String gen=sc.next();
					System.out.print("Título: ");
					String tit=sc.next();
					app.añadirPelicula(año,dir,gen,tit);
					break;
				case 2:
					System.out.print("Nombre de la película que quieres borrar: ");
					String nom=sc.next();
					app.borrarPelicula(nom);
					break;
				case 3:
					app.mostrarPeliculas();
					break;
				case 4:
					System.out.println("Dame el género que quieres buscar: ");
					String gene=sc.next();
					app.buscarGenero(gene);
					break;
			}
		} while (opcion!=5);
	}

	// Borrar película
	private void borrarPelicula(String nom) {
		ArrayList<Pelicula> peliculasABorrar = new ArrayList<>();
		for (Pelicula p : this.getPeliculas()) {
		    if (p.getNombre().equalsIgnoreCase(nom)) {
		        peliculasABorrar.add(p);
		    }
		}
		this.getPeliculas().removeAll(peliculasABorrar);
	}

	// Buscar películas por género
	private void buscarGenero(String gene) {
		for (Pelicula p : this.getPeliculas()) {
			if(p.getGenero().equalsIgnoreCase(gene)) {
				p.mostrarPelicula();
			}
		}
	}

	// Añadir nueva película
	private void añadirPelicula(int año, String dir, String gen, String tit) {
		this.getPeliculas().add(new Pelicula(año,dir,gen,tit));
	}

	// Mostrar películas
	private void mostrarPeliculas() {
		for (Pelicula p : this.getPeliculas()) {
			p.mostrarPelicula();
		}
	}

	// Menú
	private static void menu() {
		System.out.println("1. Añadir película");
		System.out.println("2. Borrar película");
		System.out.println("3. Mostrar películas");
		System.out.println("4. Buscar por género");
		System.out.println("5. Salir");
	}
	
	
}
