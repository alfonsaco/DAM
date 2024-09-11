package Examen;

public abstract class Persona {
	protected String nombre;
	protected String apellidos;
	protected String direccion;
	protected String correo;
	
	// Constructores
	public Persona(String nombre, String apellidos, String direccion, String correo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correo = correo;
	}
	public Persona() {
		this.nombre = "";
		this.apellidos = "";
		this.direccion = "";
		this.correo = "";
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
