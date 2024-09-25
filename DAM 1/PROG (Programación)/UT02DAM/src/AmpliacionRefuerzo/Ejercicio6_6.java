package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio6_6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce 3 números del 1 al 10");
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int n3=sc.nextInt();
		
		if(n1==1 || n2==1 || n3==1) {
			if(n1==2 || n2==2 || n3==2) {
				if(n1==3 || n2==3 || n3==3) {
					System.out.println("Acceso permitido");
				}
			}
		} else {
			System.out.println("Acceso denegado");
		}

	}

}
