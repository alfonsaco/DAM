package Actividades_Repaso;

import java.util.Scanner;

public class Ej8_MostrarNumerosDeXaX {

	public static void main(String[] args) {
		// Pedir un número N, y mostrar todos los números del 1 al N.
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número");
		int n=sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.print(i+",");
		}
		

	}

}
