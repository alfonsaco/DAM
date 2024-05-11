package Actividades;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("1. Área del círculo");
			System.out.println("2. Área del cuadrado");
			System.out.println("3. Área del rectángulo");
			System.out.println("4. Salir");
			System.out.println("Elija una opción");
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Dame el radio: ");
				double r=sc.nextDouble();
				double area=Math.PI*(r*r);
				System.out.println("El área del círculo es "+area);
				break;
			case 2:
				System.out.println("Dame el lado: ");
				double lado=sc.nextDouble();
				double area1=lado*lado;
				System.out.println("El area del cuadrado es "+area1);
				break;
			case 3:
				System.out.println("Dame la altura");
				double h=sc.nextDouble();
				System.out.println("Dame la base: ");
				double b=sc.nextDouble();
				double area2=b*h;
				System.out.println("El área del rectángulo es "+area2);
				break;
			}
			
		} while(opcion!=4);
	}

}
