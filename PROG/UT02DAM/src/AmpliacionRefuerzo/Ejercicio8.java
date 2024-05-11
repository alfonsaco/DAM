package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Dame la cantidad de €: ");
		double euro=sc.nextDouble();
		
		double libra=euro*0.865;
		double dolar=euro*1.286;
		
		System.out.println("Tus "+euro+" euros valen "+dolar+" dolares y "+libra+" libras");

	}

}
