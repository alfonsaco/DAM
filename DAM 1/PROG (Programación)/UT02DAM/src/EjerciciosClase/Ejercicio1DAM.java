package EjerciciosClase;

import java.util.Scanner;

public class Ejercicio1DAM {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame 2 números de 3 cifras: ");
		int a=sc.nextInt();
		
		do {
			System.out.println("Número incorrecto, debe ser de 3 cifras");
			a=sc.nextInt();
		}while(a<=99 && a>999);
		
		int b=sc.nextInt();
		do {
			System.out.println("Número incorreto, debe ser de 3 cifras: ");
			b=sc.nextInt();
		}while(b<=99 && b>999);

	}

}
