package VariablesCondiciones;

import java.util.Scanner;

public class Nota {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un numero nen: ");
		int nota=sc.nextInt();

		switch(nota) {
			case 1:
			case 2:
			case 3:
			case 4:
				System.out.println("Has suspendido");
				break;
		
			case 5:
				System.out.println("Suficiente");
				break;
			
			case 6:
				System.out.println("Tienes un bien");
				break;
			
			case 7:
			case 8:
				System.out.println("Notable");
				break;
			
			case 9:
			case 10:
				System.out.println("Sobresaliente");
				break;
			
			default:
				System.out.println("No válido");
		}

	}

}
