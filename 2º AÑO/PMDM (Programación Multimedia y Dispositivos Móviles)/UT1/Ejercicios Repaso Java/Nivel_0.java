package Ejercicios;

import java.util.Scanner;

public class Nivel_0 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// PROGRAMA QUE PASA MILLAS MARINAS A KILÓMETROS
		System.out.print("Dame las millas, y lo pasaré a Kilómetros: ");
		double n=sc.nextDouble();
		
		// 1 Milla = 1,852 Km
		double kilometro=(n*1852)/1000;
		System.out.println(n+" a Kilómetro es "+kilometro+" km");
		
		sc.close();
	}

}
