package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio22 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=0;
		int contador=0;
		int contadorMul=0;
		
		while(contador<5) {
			System.out.println("Dame un número: ");
			i=sc.nextInt();
			contador++;
			
			if(i%3==0) {
				contadorMul++;
			}
		}
		System.out.println("Hay "+contadorMul+" números múltiplos de 3");

	}

}
