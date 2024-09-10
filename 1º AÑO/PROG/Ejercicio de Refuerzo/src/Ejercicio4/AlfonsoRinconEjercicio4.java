package Ejercicio4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Programa para calcular la suceción de ULAM
 */
public class AlfonsoRinconEjercicio4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame un número: ");
		int n=sc.nextInt();
		System.out.println(sucesionULAM(n));
	}
	/**
	 * Método para calcular dicha sucesión
	 * 
	 * @param n
	 * @return	cadena
	 */
	private static String sucesionULAM(int n) {
		int contador=0;
		String cadena="";
		do {
			if(n%2==0) {
				n=n/2;
			}else if(n%2!=0) {
				n=n*3+1;
			}
			cadena+=n+", ";
		} while (n!=1);
		return cadena.substring(0, cadena.length()-2);
	}
}