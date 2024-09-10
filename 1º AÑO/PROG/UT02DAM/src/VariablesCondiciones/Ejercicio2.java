package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame el radio: ");
		double radio=sc.nextDouble();
		if(radio>0) {
			double longitud=2*Math.PI*radio;
			System.out.println("La longitud es: "+longitud);
		}else if(!sc.hasNextDouble()) {
			System.out.println("Gay");
		}else {
			System.out.println("Error! El radio tiene que ser mayor que 0");
		}
	System.out.println("FIN");
	
	}
}
