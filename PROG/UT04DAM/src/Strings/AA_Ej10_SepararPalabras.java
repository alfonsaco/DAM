package Strings;

import java.util.Scanner;

public class AA_Ej10_SepararPalabras {

	public static void main(String[] args) {
//		Codifique un programa que permita cargar una oración por teclado, luego mostrar cada
//		palabra ingresada en una línea distinta.
		Scanner sc=new Scanner(System.in);
		System.out.println("Dime una frase: ");
		String frase=sc.nextLine();
		
		String[] palabras=frase.split(" ");
		
		for(String palabra: palabras) {
			System.out.println(palabra);
		}


	}

}

//		utilizamos el método split de la clase String para dividir la oración en palabras, 
//		utilizando un espacio como delimitador.
//	
//		Después, utilizamos un bucle for-each para recorrer cada palabra del arreglo palabras y
//		las mostramos en una línea distinta utilizando el método println de la clase System.out.