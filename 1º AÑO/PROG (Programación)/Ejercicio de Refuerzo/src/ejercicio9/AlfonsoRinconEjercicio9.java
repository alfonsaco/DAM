package ejercicio9;

import java.util.Scanner;
/**
 * Método para calcular el area de distintos polígonos
 * 
 * @author alfonso
 * @version 1.0
 */
public class AlfonsoRinconEjercicio9 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame la base: ");
		double base=sc.nextDouble();
		System.out.print("Dame la altura: ");
		double altura=sc.nextDouble();
		System.out.print("Dame el lado: ");
		double lado=sc.nextDouble();
		System.out.println();
		// Llamamos al método
		System.out.println("Área triángulo: "+calcularArea("Triángulo",base, altura,lado));
		System.out.println("Área cuadrado: "+calcularArea("Cuadrado",base, altura,lado));
		System.out.println("Área rectángulo: "+calcularArea("Rectángulo",base, altura,lado));
	}
	/**
	 * Método para calcular el área de un cuadrado, triángulo y rectángulo
	 * 
	 * @param tipo
	 * @param base
	 * @param altura
	 * @param lado
	 * @return		area, de tipo double
	 */
	private static double calcularArea(String tipo, double base, double altura, double lado) {
		double area=0;
		switch(tipo) {
		case "Triángulo":
			area=(base*altura)/2;
			break;
		case "Cuadrado":
			area=lado*lado;
			break;
		case "Rectángulo":
			area=base*altura;
			break;
		}
		return area;
	}
}
