package Matricula;

public class Profesor extends Persona {
	private String titulacion;

	public Profesor(int codigo, String dNI, String nombre, String apellidos, String titulacion) {
		super(codigo, dNI, nombre, apellidos);
		this.titulacion = titulacion;
	}
	public Profesor() {
		super();
		this.titulacion = titulacion;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	
	// toString
	@Override
	public String toString() {
		return "Profesor [titulacion=" + titulacion + ", codigo=" + codigo + ", DNI=" + DNI + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + "]";
	}
	
	
}
