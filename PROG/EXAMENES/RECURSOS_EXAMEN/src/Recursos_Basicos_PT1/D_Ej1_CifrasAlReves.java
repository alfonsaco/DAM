package Recursos_Basicos_PT1;

import java.util.Scanner;

public class D_Ej1_CifrasAlReves {

	public static void main(String[] args) {
		// Crea un programa Java que muestre las cifras de un número al revés
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número");
		int n=sc.nextInt();
		int cifra=0;
		
		while(n!=0) {
			cifra=cifra+(n%10);
			n=n/10;
		}

	}

}
