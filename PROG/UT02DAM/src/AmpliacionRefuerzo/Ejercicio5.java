package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Vamos a calcular el perímetro de una circunferencia");
		
		System.out.println("Dame el radio: ");
		int r=sc.nextInt();
		
		double perimetro=2*Math.PI*r;
		System.out.println("El perímetro es "+perimetro);

	}

}
