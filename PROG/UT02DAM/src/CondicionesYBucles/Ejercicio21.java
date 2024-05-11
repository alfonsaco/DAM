package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int i=0;
			int contador=0;
			int contadorNeg=0;
			
			while(contador<10) {
				System.out.println("Inserta un número: ");
				i=sc.nextInt();
				contador++;
				
				if(i<0) {
					contadorNeg++;
				}
			}
			System.out.println("Se han introducido "+contadorNeg+" números negativos");

	}

}
