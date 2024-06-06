package ejercicio8;

import java.util.Scanner;
/**
 * Esta clase está diseñara para realizar 4 operaciones básicas: suma, resta, multiplicacióm
 * y división.
 * Contiene un main
 * 
 * @author alfonso
 * @version 1.0
 */
public class AlfonsoRinconEjercicio8 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		System.out.print("Dame el primer número: ");
		double a=sc.nextDouble();
		System.out.print("Dame el segundo número: ");
		double b=sc.nextDouble();
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println(suma(a,b));
				break;
			case 2:
				System.out.println(resta(a,b));
				break;
			case 3:
				System.out.println(multi(a,b));
				break;
			case 4:
				division(a,b);
				break;
			}
		}while(opcion!=5);
		System.out.println("Fin del programa");
		
	}
	/**
	 * Método para realizar la división
	 * 
	 * @param a
	 * @param b
	 */
	private static void division(double a, double b) {
		if(a==0 && b==0) {
			System.out.println("Indeterminación");
		}else if(b==0) {
			System.out.println("Infinito");
		}else {
			System.out.println(a/b);
		}
	}
	/**
	 * Método para realizar la multiplicación
	 * 
	 * @param a
	 * @param b
	 * @return		devuelve la multiplicación de a por b, de tipo double
	 */
	private static double multi(double a, double b) {
		return a*b;
	}
	/**
	 * Método para realizar la resta
	 * 
	 * @param a
	 * @param b
	 * @return		devuelve la resta de a menos b, de tipo double
	 */
	private static double resta(double a, double b) {
		return a-b;
	}
	/**
	 * Método para realizar la suma
	 * 
	 * @param a
	 * @param b
	 * @return		devuelve la suma de a más b, de tipo double
	 */
	private static double suma(double a, double b) {
		return a+b;
	}
	/**
	 * Menú con las diferentes operaciones que podemos realizar
	 */
	private static void menu() {
		System.out.println("1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Multiplicación");
		System.out.println("4. División");
		System.out.println("5. Salir");
	}
}
