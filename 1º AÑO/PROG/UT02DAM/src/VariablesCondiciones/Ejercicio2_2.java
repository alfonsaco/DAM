package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio2_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Vamos a calcular el radio del círculo.");
		System.out.println("La fórmula es P=2piR");
		
		System.out.println("INTRODUCE UN NÚMERO: ");
		double r=sc.nextDouble();
		System.out.println("A="+Math.PI*r*r);

	}

}
