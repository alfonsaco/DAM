package Ejercicios;

import java.util.Scanner;

public class Nivel_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int a,b,c;
		// Comprobación de que se puede hacer
		do {
			System.out.print("Dame la a: ");
			a=sc.nextInt();
			System.out.print("Dame la b: ");
			b=sc.nextInt();
			System.out.print("Dame la c: ");
			c=sc.nextInt();
		} while ((Math.pow(b, 2)-4*a*c) < 0);
		
		// Resultados
		double resultado1=(-b-Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		double resultado2=(-b+Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		System.out.println(a+"x2+"+b+"x+"+c+" = "+resultado1+" y "+resultado2); 	
		
		sc.close();
	}

}
