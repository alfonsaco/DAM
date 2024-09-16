package Ejercicios;

import java.util.Scanner;

public class Nivel_6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		int cont=1;
		int contVeces=1;
		int masVeces=0;
		int anterior=0;
		int numeroFinal=0;
		// Pedir números
		do {
			System.out.print("Dame un número (0 para terminar): ");
			n=sc.nextInt();
			
			if(n == anterior) {
				cont++;
			} else {
				contVeces=cont;
				if(contVeces > masVeces) {
					masVeces=contVeces;
					numeroFinal=anterior;
				}
				anterior=n;
				cont=1;
			}
		} while (n != 0);
		// Resultado
		System.out.println("El número aparece "+numeroFinal+" aparece "+masVeces+" veces");
	}

}
