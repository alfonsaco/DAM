package Actividades;

import java.util.Scanner;

public class Ejercicio2_Metodo {

	private static double areaR(int n1, int n2) {
		return (n1*n2);
	}

	private static double areaCi(int n1) {
		return (n1*n1*Math.PI);
	}

	private static int areaCu(int n1) {
		return (n1*n1);
	}
	
	public static void menu() {
		System.out.println("1. Área del cuadrado");
		System.out.println("2. Area del círculo");
		System.out.println("3. Area del rectángulo");
		System.out.println("4. Salir");
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Dame el lado del cuadrado: ");
				int l=sc.nextInt();
				System.out.println("El area es "+areaCu(l));
				break;
			case 2:
				System.out.println("Dame el radio del círculo: ");
				int r=sc.nextInt();
				System.out.println("El area es "+areaCi(r));
				break;
			case 3:
				System.out.println("Dame la base del rectangulo: ");
				int b=sc.nextInt();
				System.out.println("Dame la altura: ");
				int h=sc.nextInt();
				System.out.println("El area es "+areaR(b,h));
				break;
			}
		} while(opcion!=4);
		System.out.println("Se cerró el programa");
		

	}

}
