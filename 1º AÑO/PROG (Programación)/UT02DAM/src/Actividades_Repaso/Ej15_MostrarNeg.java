package Actividades_Repaso;

import java.util.Scanner;

public class Ej15_MostrarNeg {

	public static void main(String[] args) {
		// Pedir 10 números, y mostrar al final si se ha introducido alguno negativo.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contadorNeg=0;
		
		for(int i=0; i<10; i++) {
			System.out.println("Dame números");
			n=sc.nextInt();
			
			if(n<0)
				contadorNeg++;
		}
		System.out.println("Se ha introducido un total de "+contadorNeg+" negativos");
	}

}
