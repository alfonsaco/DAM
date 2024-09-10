package Recursos_Basicos_PT2;

import java.util.Scanner;

public class numeroMayorIgual {

	public static void main(String[] args) {
		/*Escriba un programa en Java que pida dos números enteros al usuario,
		y determine cuál es mayor, el primero o el segundo. Modifíquelo para 
		considerar también la posibilidad de que sean iguales.*/
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el valor de a: ");
		int a=sc.nextInt();
		System.out.println("Introduzca el valor de b: ");
		int b=sc.nextInt();
		numeroMayor(a,b);
		sc.close();
	}

	private static void numeroMayor(int a, int b) {
		if(a>b)
			System.out.println(a+">"+b);
		else if(b>a)
			System.out.println(b+">"+a);
		else
			System.out.println(a+"="+b);		
	}

}
