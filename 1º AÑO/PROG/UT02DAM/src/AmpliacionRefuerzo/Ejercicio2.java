package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=5;
		int b=7;
		int c=9;
		int suma=a+b+c;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("Su suma es "+suma);
		System.out.println("    ");
		System.out.println("Introduce nuevos valores");
		
		System.out.println("a=");
		a=sc.nextInt();
		System.out.println("b=");
		b=sc.nextInt();
		System.out.println("c=");
		c=sc.nextInt();
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		suma=a+b+c;
		System.out.println("Su suma es "+suma);
	}

}
