package Spotify;

public class Canciones {
	private int codigo;
	private String disco;
	private String nombre;
	private String duracion;
	
	// CONSTRUCTORES
	public Canciones(int codigo, String disco, String nombre, String duracion) {
		this.codigo = codigo;
		this.disco = disco;
		this.nombre = nombre;
		this.duracion = duracion;
	}
	public Canciones() {
		this.codigo = 0;
		this.disco = "";
		this.nombre = "";
		this.duracion = "";
	}
	
	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
}
