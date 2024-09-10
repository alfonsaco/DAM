package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej11_Primeros10Impares {

	public static void main(String[] args) {
		// Diseñar un programa que muestre el producto de los 10 primeros números impares.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador=0;
		int producto=1;
		System.out.println("Dame 10 números impares, y te mostraré su producto");
		
		do {
			System.out.println("Dame un número amigo");
			n=sc.nextInt();
			
			if(n%2!=0) {
				contador++;
				producto*=n;
			}else if(n%2==0) {
				System.out.println("Eso no es un número impar amigo");
			}
		}while(contador!=10);
		System.out.println("El total del producto es "+producto);
		

	}

}
