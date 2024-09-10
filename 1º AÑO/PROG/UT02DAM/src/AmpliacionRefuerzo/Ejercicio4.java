package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Vamos a calcular el área de un triángulo");
		
		System.out.println("Dame la altura: ");
		double a=sc.nextDouble();
		System.out.println("Dame la base: ");
		double b=sc.nextDouble();
		
		double area=(a*b)/2;
		System.out.println("Un triángulo rectángulo de altura "+a+" y base "+b+", tiene un área de "+area);

	}

}
