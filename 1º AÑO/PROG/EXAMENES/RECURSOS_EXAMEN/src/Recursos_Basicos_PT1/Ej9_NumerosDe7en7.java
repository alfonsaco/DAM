package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej9_NumerosDe7en7 {

	public static void main(String[] args) {
		// Escribir todos los números del 100 al 0 de 7 en 7
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Los numeros del 0 al 100, yendo de 7 en 7 son:");
		for(int i=100; i>=0; i-=7) {
			System.out.print(i+",");
		}

	}

}
