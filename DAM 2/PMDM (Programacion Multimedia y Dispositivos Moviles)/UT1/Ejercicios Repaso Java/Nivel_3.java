package Ejercicios;

import java.util.Scanner;

public class Nivel_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Con este programa, pediremos calificaciones y daremos una nota
		System.out.print("Dame tu nota: ");
		double nota=sc.nextDouble();
		// Comparaciones
		if(nota < 3) {
			System.out.println("Muy deficiente");
		} else if(nota >= 3 && nota < 5) {
			System.out.println("Deficiente");
		} else if(nota >= 5 && nota < 6) {
			System.out.println("Suficiente");
		} else if(nota >=6 && nota < 7) {
			System.out.println("Bien");
		} else if(nota >= 7 && nota < 9) {
			System.out.println("Notable");
		} else if(nota >= 9) {
			System.out.println("Sobresaliente");
		}
	}

}
