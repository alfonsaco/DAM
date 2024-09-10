package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número: ");
		int numero=sc.nextInt();
		
		if(numero>0) {
			System.out.println("Tú número es mayor que cero");
		
		} else if(numero<0) {
			System.out.println("Tu número es menor que cero");

		} else {
			System.out.println("Tu numero es igual que cero");
		}

	}

}
