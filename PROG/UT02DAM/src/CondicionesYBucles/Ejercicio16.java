package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio16 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=0;
		int contador=0;
		int suma=0;
		
		while(contador<15) {
			System.out.println("Dame un número: ");
			i=sc.nextInt();
			suma=suma+i;
			contador++;
		}
		
		System.out.println("La suma total es "+suma);
		
		
	}
}
