package Spotify;

public class Grupos {
	private int codigo;
	private String nombre;
	private int año;
	private String genero;
	
	// CONSTRUCTORES
	public Grupos(int codigo, String nombre, int año, String genero) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.año = año;
		this.genero = genero;
	}
	public Grupos() {
		this.codigo = 0;
		this.nombre = "";
		this.año = 0;
		this.genero = "";
	}
	
	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
