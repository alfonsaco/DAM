package Recursos_Basicos_PT1;

import java.util.Scanner;

public class B_Ej2_CuadradoAsteriscos {

	public static void main(String[] args) {
		// Dibuja un cuadrado de n elementos de lado utilizando *.
		Scanner sc=new Scanner(System.in);		
		System.out.println("Dame el tamaño del cuadrado");
		int n=sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int e=0; e<n; e++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
