package Actividades;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame dos número: ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		System.out.println("1. Sumar a+b");
		System.out.println("2. Restar a-b");
		System.out.println("3. Multiplicar a*b");
		System.out.println("4. Dividir a/b");
		
		int opcion=sc.nextInt();
		switch(opcion) {
		case 1:
			int suma=a+b;
			System.out.println("La suma es "+suma);
			break;
		case 2:
			int resta=a-b;
			System.out.println("La resta es "+resta);
			break;
		case 3:
			int multi=a*b;
			System.out.println("La multiplicación es "+multi);
			break;
		case 4:
			int div=a/b;
			System.out.println("La división es "+div);
			break;
		}

	}

}
