package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número del 1 al 10");
		int n=sc.nextInt();
		
		if(n<=10 && n>=0) {
			if(n<=4) {
				System.out.println("Has suspendido amigo");
			} else if(n==5) {
				System.out.println("Has aprobado por los pelos amigo");
			} else if(n==6) {
				System.out.println("Tienes un bien amigo");
			} else if(n>=7 && n<=8) {
				System.out.println("Tienes un notable amigo");
			} else if(n>=9 && n<=10) {
				System.out.println("Tienes un sobresaliente crack");
			}
		} else {
			System.out.println("Numero no válido");
		}
		
		
	}
}
