package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_NumeroCifras {

	public static void main(String[] args) {
		// Decir el número de cifras de un número
		Scanner sc=new Scanner(System.in);
		System.out.println("Intoduzca un número: ");
		int n=sc.nextInt();
		cantidadCifrasNumero(n);
		sc.close();

	}

	private static void cantidadCifrasNumero(int n) {
		int contador=0;
		while(n>0) {
			int cifra=n%10;
			contador++;
			n=n/10;
		}
		System.out.println("El número de cifras es "+contador);
		
	}

}
