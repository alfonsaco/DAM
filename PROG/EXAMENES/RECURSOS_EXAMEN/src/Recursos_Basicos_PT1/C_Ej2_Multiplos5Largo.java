package Recursos_Basicos_PT1;

import java.util.Scanner;

public class C_Ej2_Multiplos5Largo {

	public static void main(String[] args) {
		// Dados 8 números introducidos por teclado muestra cuántos hay que sean
		// múltiplos de 5 y mayores que 10. También indica qué número de esos múltiplos de
		// 5 mayores que 10 es el mayor.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador=0;
		int contador5=0;
		int mayor=0;
		System.out.println("Dame 8 números");
		
		do {
			System.out.println("Dame un número");
			n=sc.nextInt();
			contador++;
			
			if(n%5==0 && n>10) {
				contador5++;
				if(n>mayor) {
					mayor=n;
				}
			}
			
		}while(contador<8);
		System.out.println("En total hay "+contador5+" números mútliplos de 5 y mayores que 10");
		
		if(contador5>0) {
			System.out.println("El mayor múltiplo de 5 es "+mayor);
		} else {
			System.out.println("No hay múltiplos de 5");
		}

	}

}
