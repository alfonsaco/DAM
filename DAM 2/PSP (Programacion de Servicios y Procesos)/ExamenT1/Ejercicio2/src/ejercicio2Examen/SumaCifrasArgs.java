package ejercicio2Examen;

import java.util.Scanner;

public class SumaCifrasArgs {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n1=Integer.parseInt(args[0]);
		int n2=Integer.parseInt(args[1]);
		
		int suma=n1+n2;
		System.out.println("La suma es "+suma);
	}
}
