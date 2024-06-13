package Recursos_Basicos_PT1;

import java.util.Scanner;

public class C_Ej7_ImparesMedia {

	public static void main(String[] args) {
		// Dados 8 números introducidos por teclado muestra la media de los impares y 
		// menores de 20. También indica qué número de esos impares y menores de 20 es el 
		// mayor.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador=0;
		int suma=0;
		int mayor=0;
		int contadorI=0;
		System.out.println("Dame 8 números");
		
		do {
			System.out.println("Dame un número");
			n=sc.nextInt();
			contador++;
			
			if(n%2!=0 && n<20) {
				suma+=n;
				contadorI++;
				if(mayor<n)
					mayor=n;
			}
		}while(contador<8);
		
		double media=suma/contadorI;
		System.out.println("La media de los impares menores de 20 es "+media);
		
		if(suma>0) {
			System.out.println("El impar menor de 20 mayor es "+mayor);
		}else {
			System.out.println("No hay impares menores de 20");
		}
	}

}
