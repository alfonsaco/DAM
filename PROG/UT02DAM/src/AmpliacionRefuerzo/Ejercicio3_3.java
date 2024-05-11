package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio3_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número: ");
		int i=sc.nextInt();
		
		if(i%2==0) {
			System.out.println("Es par");
			
			if(i%3==0) {
				System.out.println("y múltiplo de 3");
			}
		} 
		
		else {
			System.out.println("Es impar");
		}

	}

}
