package enunciadosDAM;

import java.util.Scanner;

public class EjercicioC {

	public static void main(String[] args) {
		/*Dados 12 números introducidos por teclado muestra cuántos hay que sean impares y
		menores de 20. También indica qué número de esos impares y menores de 20 es el menor.*/
		Scanner sc=new Scanner(System.in);
		int contador=0;
		int menor=Integer.MAX_VALUE;
		for (int i=1;i<=12;i++) {
			System.out.println("Introduzca el valor número "+i+": ");
			int n=sc.nextInt();
			if (n%2!=0 && n<20) {
				contador++;
				if (n<menor)
					menor=n;
			}
		}
		System.out.println("Se han introducido "+contador+" impares menores que 20");
		System.out.println("El menor de los impares menores que 20 introducidos es "+menor);
		sc.close();
	}

}
