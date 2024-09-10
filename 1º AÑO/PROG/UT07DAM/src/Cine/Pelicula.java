package Cine;

public class Pelicula {
	private int año;
	private String director;
	private String genero;
	private String nombre;
	
	// Constructores
	public Pelicula(int año, String director, String genero, String nombre) {
		this.año = año;
		this.director = director;
		this.genero = genero;
		this.nombre = nombre;
	}
	public Pelicula() {
		this.año = año;
		this.director = director;
		this.genero = genero;
		this.nombre = nombre;
	}


	// Getters y Setters
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Método
	public void mostrarPelicula() {
		System.out.println(this.getNombre()+" del director "+this.getDirector());
	}
}
