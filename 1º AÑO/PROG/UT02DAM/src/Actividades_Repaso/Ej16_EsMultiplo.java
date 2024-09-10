package Actividades_Repaso;

import java.util.Scanner;

public class Ej16_EsMultiplo {

	public static void main(String[] args) {
		// Pedir 5 números e indicar si alguno es múltiplo de 3.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador3=0;
		
		for(int i=0; i<5; i++) {
			System.out.println("Dame un número");
			n=sc.nextInt();
			
			if(n%3==0) {
				contador3++;
			}
		}
		System.out.println("El número de números múltiplos de 3 es "+contador3);
	}
}
