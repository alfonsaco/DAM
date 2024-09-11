package Aparcamiento;

public class Coche extends Vehiculo {
	private int numPuertas;

	// Constructores
	public Coche(String matricula, String color, String marca, String modelo, int numPuertas) {
		super(matricula, color, marca, modelo);
		this.numPuertas = numPuertas;
	}
	public Coche() {
		super();
		this.numPuertas = 0;
	}
	
	// Setters y Getters
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	
	// toString
	@Override
	public String toString() {
		return "Coche [numPuertas=" + numPuertas + ", matricula=" + matricula + ", color=" + color + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
	}
	
}
