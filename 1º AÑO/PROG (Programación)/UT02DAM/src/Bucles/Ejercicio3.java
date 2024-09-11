package Bucles;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numero;
		
		while(true) {
			System.out.println("Introduce un número amigo: ");
			numero=sc.nextInt();
			
			if(numero==0) {
				System.out.println("Se acabó");
			}
		}

	}

}
