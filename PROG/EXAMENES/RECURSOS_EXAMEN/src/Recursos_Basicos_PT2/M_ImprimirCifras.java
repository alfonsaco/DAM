package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_ImprimirCifras {

	public static void main(String[] args) {
		// Imprimir las cifras de un número
		Scanner sc=new Scanner(System.in);
		System.out.println("Intoduzca un número: ");
		int n=sc.nextInt();
		mostrarcifras(n);
		sc.close();
	}
	
	private static void mostrarcifras(int n) {
		int divisor=1;
		while (n/divisor>=10)
			divisor*=10;
		System.out.println("Las cifras de "+n+" son: ");
		while (divisor>0) {
			int cifra=n/divisor;
			System.out.print(cifra+" ");
			n%=divisor;
			divisor/=10;
		}
		System.out.println();
	}

}
