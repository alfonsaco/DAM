package Recursos_Basicos_PT1;

import java.util.Scanner;

public class E_Ej1_EsPar {

	public static void main(String[] args) {
		// Calcula si un número introducido por teclado es par
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número");
		int n=sc.nextInt();
		
		if(n%2==0) {
			System.out.println("Es par");
		}else {
			System.out.println("Es impar");
		}

	}

}
