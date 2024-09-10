package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio7_7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número de 2 cifras");
		int i=sc.nextInt();
		int suma=0;
		
		if(i>9 && i<=99) {
			int cifra1=i/10;
			int cifra2=i%10;
			suma=cifra1+cifra2;
			System.out.println("La suma es "+suma);
			if(cifra1%2==0 || cifra2%2==0) {
				System.out.println("Tiene 1 cifra par");
			} else if(cifra1%2==0 && cifra2%2==0) {
				System.out.println("Tiene 2 cifras pares");
			}
		} else {
			System.out.println("El número no es de 2 cifras");
		}

	}

}
