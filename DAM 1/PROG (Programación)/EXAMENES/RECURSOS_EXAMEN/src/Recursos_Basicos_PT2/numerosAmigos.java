package Recursos_Basicos_PT2;

import java.util.Scanner;

public class numerosAmigos {

	public static void main(String[] args) {
		/*Dados dos números A y B se dice que son amigos 
		cuando la suma de los divisores de A (excepto el mismo 
		número) es igual a B y la suma de los divisores de B 
		(excepto B) es A. */
		Scanner sc=new Scanner (System.in);
		System.out.println("Introduzca el primer número: ");
		int n1=sc.nextInt();
		System.out.println("Introduzca el segundo número: ");
		int n2=sc.nextInt();
		sonamigos(n1,n2);
		sc.close();

	}

	private static void sonamigos(int n1, int n2) {
		int sumaDivisoresN1=0;
		int sumaDivisoresN2=0;
		for (int i=1;i<n1;i++) {
			if (n1%i==0)
				sumaDivisoresN1+=i;
		}
		for (int j=1;j<n2;j++) {
			if (n2%j==0)
				sumaDivisoresN2+=j;
		}
		if (sumaDivisoresN1==n2 && sumaDivisoresN2==n1)
			System.out.println(n1+" y "+n2+" son números amigos");
		else
			System.out.println(n1+" y "+n2+" NO son números amigos");
	}
}
