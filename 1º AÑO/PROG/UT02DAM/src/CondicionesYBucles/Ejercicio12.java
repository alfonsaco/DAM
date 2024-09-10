package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=1;
		int suma=0;
		
		while(i!=0) {
			System.out.println("Introduce un número: ");
			i=sc.nextInt();
			suma=suma+i;
		}
		System.out.println("La suma de los número es: "+suma);

	}

}
