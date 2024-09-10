package Ejemplos;

import java.util.*;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Dame un número:");
		int n1=teclado.nextInt();
		System.out.println("El primer número es: "+n1);
		System.out.println("Dame otro número: ");
		int n2=teclado.nextInt();
		System.out.println("El segundo número es: "+n2);
		
		System.out.println("La suma es: "+ (n1+n2));
		System.out.println("La resta es: "+ (n1-n2));
		System.out.println("La multiplicación es: "+ (n1*n2));
		System.out.println("La división es: " + ((float)n1/n2));
		System.out.println("El resto es: "+ ((float)n1%n2));
	}
}
