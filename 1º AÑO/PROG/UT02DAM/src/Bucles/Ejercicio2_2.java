package Bucles;

import java.util.Scanner;

public class Ejercicio2_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Dame un número: ");
			int numero=sc.nextInt();
			
			if(numero==0) {
				System.out.println("Se finalizará el programa");
				break;
			} else if(numero>0) {
				System.out.println("Tu número es positivo");
			} else if(numero<0) {
				System.out.println("Tu número es negativo");
			}
		}

	}

}
