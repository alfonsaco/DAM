package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_CifraMenor {

	public static void main(String[] args) {
		// Para calcular la cifra menor del número introducido
		Scanner sc=new Scanner (System.in);
		System.out.println("Introduzca un número: ");
		int n=sc.nextInt();
		digitoMenor(n);
		sc.close();
	}

	private static void digitoMenor(int n) {
		n=Math.abs(n);
		int menor=9;
		while(n>0) {
			int cifra=n%10;
			if(cifra<menor)
				menor=cifra;
			n=n/10;
			
		}
		System.out.println("La cifra menor es "+menor);
		
	}

}
