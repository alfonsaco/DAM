package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i;
		do{
			i=sc.nextInt();
			System.out.println("El cuadrado de "+i+" es "+i*i);
		} while(i>=0);
		System.out.println("Mal");

	}

}
