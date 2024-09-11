package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_IntercambioValor {

	public static void main(String[] args) {
		/*Escriba un programa en el que se declaren dos variables, a y b, se pida 
		un valor para cada una de ellas, y se intercambien dichos valores*/
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el valor de a: ");
		int a=sc.nextInt();
		System.out.println("Introduzca el valor de b: ");
		int b=sc.nextInt();
		intercambioValores(a,b);
		sc.close();

	}

	private static void intercambioValores(int a, int b) {
		int temp=a;
		a=b;
		b=temp;
		System.out.println("El valor de a es: "+a);
		System.out.println("El valor de b es: "+temp);
	}

}
