package enunciadosDAM;

import java.util.Scanner;

public class EjercicioB {

	public static void main(String[] args) {
		/*Dados 8 números introducidos por teclado muestra cuántos hay que sean múltiplos de 5 y
		mayores que 10. También indica qué número de esos múltiplos de 5 mayores que 10 es el
		mayor.*/
		Scanner sc=new Scanner(System.in);
		int contador=0;
		int mayor=0;
		for (int i=1;i<=8;i++) {
			System.out.println("Introduzca el valor número "+i+": ");
			int n=sc.nextInt();
			if (n%5==0 && n>10) {
				contador++;
				if (n>mayor)
					mayor=n;
			}
		}
		System.out.println("Se han introducido "+contador+" múltiplos de 5 mayores que 10");
		System.out.println("El mayor de los múltiplos de 5 mayores que 10 introducidos es "+mayor);
		sc.close();
	}

}
