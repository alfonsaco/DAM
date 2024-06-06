package actividadNotasAlumnos;

import java.util.Iterator;
import java.util.Scanner;

public class Nota {
	private String modulo;
	private double nota;
	
	// Constructores
	public Nota(String modulo, double nota) {
		this.modulo = modulo;
		this.nota = nota;
	}
	public Nota() {
		this.modulo = "";
		this.nota = 0;
	}
	
	// getters y Setters
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	// toString
	@Override
	public String toString() {
		return "Módulo: "+modulo+" => "+nota;
	}
	
	// Prueba unitaria
	public static void main(String[] args) {
		Nota n=new Nota("Lenguaje de Marcas", 10);
		System.out.println(n);
	}
	
}
