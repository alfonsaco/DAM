package Bucles;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);		
		int numero=1;
		int suma=0;
		while(numero!=0) {
			System.out.println("Introduce un número: ");
			numero=sc.nextInt();
			suma=numero;
		}
		
		System.out.println("La suma es: "+suma);

	}

}
