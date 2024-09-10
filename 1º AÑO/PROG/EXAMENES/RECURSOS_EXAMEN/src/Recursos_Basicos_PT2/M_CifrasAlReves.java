package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_CifrasAlReves {

	public static void main(String[] args) {
		// Escribir al revés las cifras de un número
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int n=sc.nextInt();
		alReves(n);
		sc.close();
	}

	private static void alReves(int n) {
		while(n>0) {
			int cifra=n%10;
			System.out.print(cifra);
			n/=10;
		}
		
	}

}
