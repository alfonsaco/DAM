package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame dos números amigo");
		
		System.out.println("Primer número: ");
		int n1=sc.nextInt();
		
		System.out.println("Segundo número: ");
		int n2=sc.nextInt();
		
		if(n1>n2) {
			System.out.println(n2+"<"+n1);
		} else {
			System.out.println(n1+"<"+n2);
		}
		
		sc.close();

	}

}
