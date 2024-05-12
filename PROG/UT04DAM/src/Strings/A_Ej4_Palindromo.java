package Strings;

import java.util.Scanner;

public class A_Ej4_Palindromo {

	public static void main(String[] args) {
//		Determina si una cadena leída por teclado es o no un palíndromo
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un String palindromo: ");
		String frase=sc.nextLine();
		
		String resultado="";
		for(int i=frase.length()-1; i>=0; i--) {
			resultado+=frase.charAt(i);
			
		}
		
		if(frase.equals(resultado))
			System.out.println(frase+" es palíndromo");
		else
			System.out.println(frase+" no es palíndromo");

	}

}
