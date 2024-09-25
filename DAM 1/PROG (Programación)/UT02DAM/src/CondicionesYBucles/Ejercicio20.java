package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int edad=0;
		double altura=0;
		double sumaAltura=0;
		double mediaAltura=0;
		double sumaEdad=0;
		double mediaEdad=0;
		int contador=0;
		int contadorMas18=0;
		int contadorAltura17=0;
		
		while(contador<5) {
			System.out.println("Dame la edad de un niño: ");
			edad=sc.nextInt();
			System.out.println("Dame la altura de un niño (en metros): ");
			altura=sc.nextDouble();
			
			sumaEdad=sumaEdad+edad;
			sumaAltura=sumaAltura+altura;
			contador++;
			
			if(edad>=18) {
				contadorMas18++;
			} else if(altura>1.75) {
				contadorAltura17++;
			}
		}
		mediaEdad=sumaEdad/contador;
		mediaAltura=sumaAltura/contador;
		System.out.println("La media de edad es "+mediaEdad);
		System.out.println("La media de altura es "+mediaAltura);
		System.out.println("Hay "+contadorMas18+" niños mayores de 18");
		System.out.println("Hay "+contadorAltura17+" niños mayores de 1.75m");
		

	}

}
