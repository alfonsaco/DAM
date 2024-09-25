package Otros;

import java.util.Scanner;

public class EjercicioClase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número: ");
		int numero1=sc.nextInt();
		
		System.out.println("Dame otro número: ");
		int numero2=sc.nextInt();
		
		try {
			System.out.println("a/b="+numero1/numero2);
		}catch(Exception e) {
			System.out.println("Error, has dividido entre 0");
		}
		
		System.out.println("FIN");

	}

}
