package Actividades_Repaso;

import java.util.Scanner;

public class Ej13_10Sueldos {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Pedir 10 sueldos. Mostrar su suma y cuantos hay mayores de 1000€.
		int s=0;
		int suma=0;
		int mayor1k=0;
		
		System.out.println("Dame 10 sueldos, y te daré 2 datazos");
		for(int i=0; i<10; i++) {
			System.out.println("Dame un sueldo");
			s=sc.nextInt();
			suma+=s;
			
			if(s>1000) {
				mayor1k++;
			}	
		}
		System.out.println("La suma total de los sueldos es "+suma+"€");
		System.out.println("En total, hay "+mayor1k+" sueldos mayores de 1000€");

	}

}
