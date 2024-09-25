package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame el radio para calcular la longitud de circunferencia.");
		
		System.out.println("r: ");
		double r=sc.nextDouble();
		System.out.println("C= "+2*Math.PI*r);

	}

}
