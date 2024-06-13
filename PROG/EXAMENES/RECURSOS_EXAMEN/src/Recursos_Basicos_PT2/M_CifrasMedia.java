package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_CifrasMedia {

	public static void main(String[] args) {
		// Calcular la media de las cifras
		Scanner sc=new Scanner (System.in);
		System.out.println("Introduzca un número: ");
		int n=sc.nextInt();
		mediaCifras(n);
		sc.close();
	}

	private static void mediaCifras(int n) {
		int suma=0;
		int contador=0;
		while(n>0) {
			int cifra=n%10;
			suma+=cifra;
			contador++;
			n=n/10;
		}
		double area=(double) suma/contador;
		System.out.println("La media de las cifras es "+area);
		
	}

}
