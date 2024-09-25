package Recursos_Basicos_PT2;

import java.util.Scanner;

public class numerosPrimosEntreDosNumeros {

	public static void main(String[] args) {
		// Cuántos numeros primos hay entre dos números introducidos
		Scanner sc=new Scanner(System.in);
		System.out.println("Intoduzca un número: ");
		int n1=sc.nextInt();
		System.out.println("Intoduzca un número: ");
		int n2=sc.nextInt();
		cantidadPrimosEntreNumeros(n1,n2);
		sc.close();

	}

	private static void cantidadPrimosEntreNumeros(int n1, int n2) {
		int contadorPrimos=0;
		for (int i=n1;i<=n2;i++) {
			if (esprimo(i))
				contadorPrimos++;
		}
		System.out.println("Hay "+contadorPrimos+" números primos entre "+n1+" y "+n2);	
	}

	public static boolean esprimo(int n){
		for (int i=2;i<=n/2;i++){
		if (n%i==0)
			return false;
		}
		return true;	
	}
}
