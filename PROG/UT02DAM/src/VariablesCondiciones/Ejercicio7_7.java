package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio7_7 {

	public static void main(String[] args) {
		//Es ejercicio también actúa como el 8, ya que hace lo mismo
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame 2 números amigo");
		
		System.out.println("Primer número: ");
		int n1=sc.nextInt();
		
		System.out.println("Segundo número: ");
		int n2=sc.nextInt();
		
		if(n1==n2) {
			System.out.println("Son iguales");
		} else if(n1>n2) {
			System.out.println(n1+" es el número más alto");
		} else {
			System.out.println(n2+" es el número más alto");
		}
	}

}
