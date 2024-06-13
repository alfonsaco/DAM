package Recursos_Basicos_PT2;

import java.util.Scanner;

public class numeroPerfecto {

	public static void main(String[] args) {
		/*Un número perfecto es aquel que es igual a la suma de sus divisores 
		(excepto él mismo). Haz un programa Java que dado un número por teclado 
		diga si es perfecto o no*/
		Scanner sc=new Scanner (System.in);
		System.out.println("Introduzca un número: ");
		int n=sc.nextInt();
		esperfecto(n);
		sc.close();
	}

	private static void esperfecto(int n) {
		int sumaDivisores=0;
		for (int i=1;i<n;i++) {
			if (n%i==0)
				sumaDivisores+=i;
		}
		if (sumaDivisores==n)
			System.out.println("El número "+n+" es perfecto");
		else
			System.out.println("El número "+n+" NO es perfecto");
	}

}
