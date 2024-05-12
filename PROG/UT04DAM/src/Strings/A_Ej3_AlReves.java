package Strings;

import java.util.Scanner;

public class A_Ej3_AlReves {

	public static void main(String[] args) {
		// Crea un programa Java que lea una cadena de teclado y la imprima al revés
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		String frase=sc.nextLine();
		
		String resultado="";
		for(int i=frase.length()-1; i>=0; i--) {
			resultado+=frase.charAt(i);
		}
		
		System.out.println(resultado);

	}
}
