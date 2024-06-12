package Examen;

public abstract class Persona {
	protected String id;
	protected String nombre;
	protected String apellidos;
	
	// Constructores
	public Persona(String id, String nombre, String apellidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Persona() {
		this.id = "";
		this.nombre = "";
		this.apellidos = "";
	}
	
	// Getters y Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
}
