package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio2_2 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame 2 números: ");
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		
		if(n1%n2==0) {
			System.out.println("Son divisibles");
		} else {
			System.out.println("No son divisibles");
		}
	
		
		
	}
}
