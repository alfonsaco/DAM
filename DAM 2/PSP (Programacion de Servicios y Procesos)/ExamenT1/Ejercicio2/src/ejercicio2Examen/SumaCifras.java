package ejercicio2Examen;

import java.util.Scanner;

public class SumaCifras {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Dame un número: ");
		int n1=sc.nextInt();
		System.out.print("Dame un numero: ");
		int n2=sc.nextInt();
		
		int suma=n1+n2;
		System.out.println("La suma es: "+suma);
	}
}
