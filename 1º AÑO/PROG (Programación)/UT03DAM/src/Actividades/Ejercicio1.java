package Actividades;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame el radio del círculo: ");
		int r=sc.nextInt();
		
		double a=Math.PI*(r*r);
		System.out.println("El área del círculo es "+a);

	}

}
