package Actividades;

import java.util.Scanner;

public class Metodos {

	private static int suma(int n1, int n2) {
		return (n1+n2);
	}
	
	private static int resta(int n1, int n2) {
		return (n1-n2);
	}
	
	private static int mult(int n1, int n2) {
		return (n1*n2);
	}
	
	private static float div(float n1, float n2) {
		return (n1/n2);
	}
	
	public static void menu() {
		System.out.println("1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Multiplicación");
		System.out.println("4. División");
		System.out.println("5. Salir");
		System.out.println("Elija una opción");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a,b;
		int opcion=0;
		
		System.out.println("Dame el valor de a: ");
		a=sc.nextInt();
		System.out.println("Dame el valor de b: ");
		b=sc.nextInt();
	
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("La suma es "+suma(a,b));
				break;
			case 2:
				System.out.println("La resta es "+resta(a,b));
				break;
			case 3:
				System.out.println("La multiplicación es "+mult(a,b));
				break;
			case 4:
				System.out.println("La división es "+div(a,b));
				break;
			case 5:
				System.out.println("Adios");
				break;
			}
		}while(opcion!=5);
	

	}



}

