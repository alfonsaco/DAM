package Ejercicios;

import java.util.Scanner;

public class Nivel_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		int contPar=0;
		int contPos=0;
		int cont=0;
		// Pedir números
		do {
			System.out.print("Dame un número (0 para terminar): ");
			n=sc.nextInt();
			cont++;
			// Verificar pares y positivos
			if(n%2 == 0) {
				contPar++;
			}
			if(n > 0) {
				contPos++;
			}
		} while (n != 0);
		// Resultado. Se resta 1 para no contar el 0
		System.out.println("\nContador total: "+(cont-1)+"\nContador pares: "+(contPar-1)+"\nContador positivos: "+contPos);
	}

}
