package Arrays;

import java.util.Iterator;
import java.util.Scanner;

public class Temperatura {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] temperaturas= {30,29,34,23,29,28,30,32,33,28};
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion){
			case 1:
				double media=media(temperaturas);
				System.out.println("La media es "+media);
				break;
			case 2:
				System.out.println("La temperatura máxima es "+maxima(temperaturas));
				break;
			case 3:
				System.out.println("La temperatura mínima es "+minima(temperaturas));
				break;
			case 4:
				double media1=media(temperaturas);
				encimaMedia(temperaturas, media1);
				break;
			}
		} while (opcion!=5);
	}

	private static void encimaMedia(int[] temperaturas, double media) {
		for (int i = 0; i < temperaturas.length; i++) {
			if(temperaturas[i] > media) {
				System.out.print(temperaturas[i]+ " ");
			}
		}
	}

	// Temperatura mínima
	private static int minima(int[] temperaturas) {
		int minima=99;
		for (int i = 0; i < temperaturas.length; i++) {
			if(minima>temperaturas[i]) {
				minima=temperaturas[i];
			}
		}
		return minima;
	}

	// Temperatura máxima
	private static int maxima(int[] temperaturas) {
		int maxima=0;
		for (int i = 0; i < temperaturas.length; i++) {
			if(maxima<temperaturas[i]) {
				maxima=temperaturas[i];
			}
		}
		return maxima;
	}

	// Media temperaturas
	private static double media(int[] temperaturas) {
		double media=0;
		double suma=0;
		for (int i = 0; i < temperaturas.length; i++) {
			suma+=temperaturas[i];
		}
		media=suma/temperaturas.length;
		return media;
	}
	// Menú
	private static void menu() {
		System.out.println();
		System.out.println("1. Temperatura media");
		System.out.println("2. Temperatura máxima");
		System.out.println("3. Temperatura mínima");
		System.out.println("4. Días por encima de la media");
		System.out.println("5. Salir");
	}
}
