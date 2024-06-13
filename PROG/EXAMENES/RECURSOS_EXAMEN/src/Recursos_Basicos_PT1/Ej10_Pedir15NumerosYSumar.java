package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej10_Pedir15NumerosYSumar {

	public static void main(String[] args) {
		// Pedir 15 números y escribir la suma total.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int suma=0;
		
		for(int i=0; i<15; i++) {
			n=sc.nextInt();
			suma+=n;
		}
		System.out.println("La suma es "+suma);

	}

}
