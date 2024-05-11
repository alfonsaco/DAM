package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		Scanner teclado=new Scanner (System.in);
		System.out.println("Dame el radio del círculo");
		double radio=teclado.nextDouble();
		double area=Math.PI*radio*radio;
		System.out.println("El area del círculo es: "+area);
	}
	

}
