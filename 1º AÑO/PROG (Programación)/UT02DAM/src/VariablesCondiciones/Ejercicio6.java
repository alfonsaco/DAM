package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame 2 números");
		
		System.out.println("Número 1: ");
		int n1=sc.nextInt();
		
		System.out.println("Número 2: ");
		int n2=sc.nextInt();
		
		if(n1%n2==0) {
			System.out.println(n1+" es múltiplo de "+n2);
		} else if(n1%n2!=0) {
			System.out.println(n1+" no es múltiplo de "+n2);
		}

	}

}
