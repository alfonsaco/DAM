package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio11_11 {

	public static void main(String[] args) {
		//Este es el ejercicio 10 no el 11
		Scanner sc=new Scanner(System.in);
		String letra=sc.next();
		
		switch(letra) {
		case "a":
		case "e":
		case "i":
		case "o":
		case "u":
			System.out.println(letra+" es una vocal");
			break;
			
		default:
			System.out.println(letra+" no es una vocal");
		}
		
		System.out.println("Ahora lo haremos con if");
		letra=sc.next();
		if(letra!="a" || letra!="e" || letra!="i" || letra!="o" || letra!="u") {
			System.out.println(letra+" no es una vocal");
		} else {
			System.out.println(letra+" es una vocal");
		}
		

	}

}
