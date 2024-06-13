package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_Potencia {

	public static void main(String[] args) {
		/* Escriba un programa que eleve un número a una potencia, utilizando dos métodos:
		a) utilizando la función potencia Math.pow()
		b) usando un bucle, sin recurrir al operador potencia*/
		Scanner teclado=new Scanner(System.in);
		int n=0;
		int numeroOpcion=0;
		int exponente;
		int resultado=1;
		System.out.println("Introduzca un número:");
		n=teclado.nextInt();
		System.out.println("Introduzca el exponente al que quieres elevar "+n+":");
		exponente=teclado.nextInt();
		System.out.println("Eliga que método usar para calcular la potencia de "+n);
		System.out.println("1) Utilizando la función potencia Math.pow()");
		System.out.println("2) Usando un bucle, sin recurrir al operador potencia");
		numeroOpcion=teclado.nextInt();
		switch(numeroOpcion) {
			case 1:
				resultado=(int)Math.pow(n, exponente);
				break;
			case 2:
				for (int i=1;i<=exponente;i++)
					resultado*=n;
				break;
		}
		System.out.println(n+"^"+exponente+"= "+resultado);
		teclado.close();
	}
}
