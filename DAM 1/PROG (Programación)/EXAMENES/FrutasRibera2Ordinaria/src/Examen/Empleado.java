package Examen;

public class Empleado extends Persona {
	private int turno;

	// Constructores
	public Empleado(String dni, String nombre, String apellidos, String direccion, int turno) {
		super(dni, nombre, apellidos, direccion);
		this.turno = turno;
	}
	public Empleado() {
		super();
		this.turno = 0;
	}
	
	// Getters y Setters
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	// toString
	@Override
	public String toString() {
		return "Empleado [turno=" + turno + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + "]";
	}
}
