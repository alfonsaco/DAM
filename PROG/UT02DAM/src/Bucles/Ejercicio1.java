package Bucles;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numero;
		
		while(true) {
			System.out.println("Dame un número amigo: ");
			numero=sc.nextInt();
			
			if(numero<0) {
				System.out.println("Numero no válido");
				break;
			}
			int numeroFinal=numero*numero;
			System.out.println("El cuadrado de "+numero+" es "+numeroFinal);
			break;
		
		}

	}

}
