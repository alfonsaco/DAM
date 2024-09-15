package Ejercicios;

public class Nivel_9_2 extends Nivel_9_1 {
	String direccion;
	// Constructor
	public Nivel_9_2(int edad, String nombre, String apellidos, String direccion) {
		super(edad, nombre, apellidos);
		this.direccion = direccion;
	}
	// getters y Setters
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Nivel_9_2 [direccion=" + direccion + ", edad=" + edad + ", nombre=" + nombre + ", apellidos="
				+ apellidos + "]";
	}
}
