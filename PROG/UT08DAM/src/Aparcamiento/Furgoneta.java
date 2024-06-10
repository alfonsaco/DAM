package Aparcamiento;

public class Furgoneta extends Vehiculo {
	private int capacidad;

	// Constructores
	public Furgoneta(String matricula, String color, String marca, String modelo, int capacidad) {
		super(matricula, color, marca, modelo);
		this.capacidad = capacidad;
	}
	public Furgoneta() {
		super();
		this.capacidad = 0;
	}
	
	// Getters y Setters
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	// toString
	@Override
	public String toString() {
		return "Furgoneta [capacidad=" + capacidad + ", matricula=" + matricula + ", color=" + color + ", marca="
				+ marca + ", modelo=" + modelo + "]";
	}
	
}
