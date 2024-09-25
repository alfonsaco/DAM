package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_EsCapicua {

	public static void main(String[] args) {
		// Decir si es capicua o no
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int n=sc.nextInt();
		esCapicua(n);
		sc.close();
	}

	private static void esCapicua(int n) {
		int nOriginal=n;
		int nInvertido=0;
		while(n>0) {
			int cifra=n%10;
			nInvertido=nInvertido*10+cifra;
			n=n/10;
		}
		if(nOriginal==nInvertido)
			System.out.println(nOriginal+" es capicua");
		else
			System.out.println(nOriginal+" no es capicua");
		
	}

}
