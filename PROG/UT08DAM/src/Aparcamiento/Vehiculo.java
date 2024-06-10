package Aparcamiento;

import java.io.Serializable;

public abstract class Vehiculo implements Valida, Serializable {
	protected String matricula;
	protected String color;
	protected String marca;
	protected String modelo;
	
	// Constructores
	public Vehiculo(String matricula, String color, String marca, String modelo) {
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
	}
	public Vehiculo() {
		this.matricula = "";
		this.color = "";
		this.marca = "";
		this.modelo = "";
	}
	
	// Getters y Setters
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	// toString
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", color=" + color + ", marca=" + marca + ", modelo=" + modelo
				+ "]";
	}
	
	// Método calcular aparcamiento
	public double calcularPrecio(int dias) {
		if(this instanceof Coche) {
			return 10*dias;
		} else if (this instanceof Moto) {
			return 5*dias;
		} else if (this instanceof Furgoneta) {
			return 15*dias;
		} else {
			return 0;
		}
	}
	
	// Pruebas unitarias
	public static void main(String[] args) {
		Coche c=new Coche();
		Moto m=new Moto();
		Furgoneta f=new Furgoneta();
		
		System.out.println(c);
		System.out.println(c.calcularPrecio(10));
		System.out.println(m.calcularPrecio(14));
		System.out.println(f.calcularPrecio(1));
	}
}
