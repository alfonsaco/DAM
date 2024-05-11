package Bucles;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		int numero;
		System.out.println("Introduce un número: ");
		numero=teclado.nextInt();
		while(numero!=0) {
			if(numero>0)
				System.out.println("Es positivo");
			else
				System.out.println("Es negativo");
			
			System.out.println("Dame un número");
			numero=teclado.nextInt();
		}
	}

}
