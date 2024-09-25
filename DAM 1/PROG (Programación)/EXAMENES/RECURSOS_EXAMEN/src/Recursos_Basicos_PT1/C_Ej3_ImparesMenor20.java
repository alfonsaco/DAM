package Recursos_Basicos_PT1;

import java.util.Scanner;

public class C_Ej3_ImparesMenor20 {

	public static void main(String[] args) {
		// Dados 12 números introducidos por teclado muestra cuántos hay que sean 
		// impares y menores de 20. También indica qué número de esos impares y menores de 
		// 20 es el menor.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador=0;
		int contadorImpar=0;
		int menor=20;
		System.out.println("Dame 12 números");
		
		do {
			System.out.println("Dame un número");
			n=sc.nextInt();
			contador++;
			
			if(n%2!=0 && n<20) {
				contadorImpar++;
				if(menor>n)
					menor=n;
			}
		}while(contador<12);
		
		System.out.println("Hay un total de "+contadorImpar+" números impares y menores que 20");
		
		if(contadorImpar>0) {
			System.out.println("El impar menor es "+menor);
		}else {
			System.out.println("No hay impares menores que 20");
		}

	}

}
