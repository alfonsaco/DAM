package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=0;
		int contador=0;
		int contadorMax=0;
		int suma=0;
		
		while(contador<10) {
			System.out.println("Escribe un sueldo: ");
			i=sc.nextInt();
			suma=suma+i;
			contador++;
			
			if(i>1000) {
				contadorMax++;
			}
		}
		System.out.println("La suma es "+suma);
		System.out.println("En total, hay "+contadorMax+" sueldos de más de 1000€");
		

	}

}
