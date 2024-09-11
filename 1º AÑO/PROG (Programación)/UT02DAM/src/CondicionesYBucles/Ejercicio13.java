package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=1;
		int suma=0;
		int contador=0;
		double media;
		
		while(i>=0) {
			System.out.println("Dame un número: ");
			i=sc.nextInt();
			suma=suma+i;
			contador++;
		}
		
		media=suma/contador;
		System.out.println("La media de los números es "+media);
		

	}

}
