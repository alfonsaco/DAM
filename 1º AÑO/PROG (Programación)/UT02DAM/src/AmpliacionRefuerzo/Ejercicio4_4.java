package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio4_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame 2 números:");
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		
		if(n1>n2) {
			System.out.println(n1+" es el mayor");
		} else if(n1==n2) {
			System.out.println("Son iguales");
		} else {
			System.out.println(n2+" es el mayor");
		}

	}

}
