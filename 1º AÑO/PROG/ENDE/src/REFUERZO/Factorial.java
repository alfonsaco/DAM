package REFUERZO;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame un número, y te daré su factorial: ");
		int n=sc.nextInt();
		System.out.println(factorial(n));
	}

	/**
	 * Método para calcular el factorial
	 * 
	 * @param numero
	 * @return result  Devuelve el factorial
	 */
	private static int factorial(int numero) {
		int result=1;
		for(int i=1; i<=numero; i++) {
			result*=i;
		}
		return result;
	}
}
