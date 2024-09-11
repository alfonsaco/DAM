package Actividades_Repaso;

import java.util.Scanner;

public class C_Ej4_Multiplos3Menor18 {

	public static void main(String[] args) {
		// Dados 11 números introducidos por teclado muestra la suma de los números que sean 
		// múltiplos de 3 y menores de 18. También indica qué número de esos múltiplos de 3 y 
		// menores de 18 es el menor.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador=0;
		int suma=0;
		int menor=18;
		System.out.println("Dame 11 números");
		
		do {
			System.out.println("Dame un número");
			n=sc.nextInt();
			contador++;
			
			if(n%3==0 && n<18) {
				suma+=n;
				if(menor>n) {
					menor=n;
				}
			}
		}while(contador<11);
		
		System.out.println("La suma de los múltiplos de 3 menores de 18 es "+suma);
		
		if(suma>0) {
			System.out.println("El múltiplo de 3 menor de 18 menor es "+menor);
		}else {
			System.out.println("No hay múltiplos de 3 menores de 18");
		}
	}
}
