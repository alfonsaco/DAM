package Recursos_Basicos_PT2;

import java.util.Scanner;

public class primosEntre1yN {

	public static void main(String[] args) {
		// Realizar un programa que nos pida un número n, y nos diga cuantos números hay entre 1 y n que son primos
		Scanner sc=new Scanner(System.in);
		System.out.println("Intoduzca un número: ");
		int n=sc.nextInt();
		numerosPrimosDelUnoAln(n);
		sc.close();

	}

	private static void numerosPrimosDelUnoAln(int n) {
		int contadorPrimos=0;
		for (int i=1;i<=n;i++) {
			if (esprimo(i))
				contadorPrimos++;
		}
		System.out.println("Hay "+contadorPrimos+" números primos entre 1 y "+n);	
	}
	
	public static boolean esprimo(int n){
		for (int i=2;i<=n/2;i++){
		if (n%i==0)
			return false;
		}
		return true;	
	}

}
