package Gimnasio;

public abstract class Persona {
	protected String codigo;
	protected String nombre;
	protected String apellidos;
	protected String email;
	
	public Persona(String codigo, String nombre, String apellidos, String email) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}
	public Persona() {
		this.codigo = "";
		this.nombre = "";
		this.apellidos = "";
		this.email = "";
	}
	
	protected String getCodigo() {
		return codigo;
	}
	protected void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getApellidos() {
		return apellidos;
	}
	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ "]";
	}
	
}
