package EJERCICIO_4;

import java.util.Scanner;
/**
 * Clase principal que hará el factorial de un número
 * Esta clase contiene el método main
 * 
 * @author Alfonso
 * @version 1.0
 */
public class Factorial {
/**
 * Main que contiene los métodos principales, además de hacer referencia a otros métodos para 
 * calcular el factorial
 * 
 * @param args
 */
	public static void main ( String [ ] args ) {
		//Creación de un scanner utilizando las librerias java.util.Scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero mayor o igual a cero: ");
		// Se introduce una variable por teclado
		double num = sc.nextInt();
		//Calcula el factorial de un número
		System.out.println(calcularFactorial(num));
	}
	/**
	 * 
	 * @param num	Parametro num, de tipo int
	 * @return		Devuelve el factorial, tipo int
	 */
	private static double calcularFactorial(double num) {
		double factorial=1;
		while ((num!= 0) && (num!= 1)) {
			factorial *= num;
			num--;
		}
		// Devuelve la solución del factorial
		return factorial;
	}
 
}