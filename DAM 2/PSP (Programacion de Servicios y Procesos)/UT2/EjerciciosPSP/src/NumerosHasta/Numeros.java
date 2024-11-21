package NumerosHasta;

import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		String cadena="";
		
		for (int i = 1; i < n; i++) {
			cadena+=i+" ";
		}
		
		System.out.println("Los números que hay hasta "+n+" son "+cadena);
	}
}
