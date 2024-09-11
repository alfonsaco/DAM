package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej14_AlturaEdad {

	public static void main(String[] args) {
		// Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media, 
		// la cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden más 
		// de 1.75.
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame la altura y edad de 5 niños");
		double altura=0;
		int edad=0;
		int edadSuma=0;
		double alturaSuma=0;
		int m18=0;
		int a175=0;
		
		for(int i=0; i<5; i++){
			System.out.println("Dame la altura de un niño en cm");
			altura=sc.nextDouble();
			System.out.println("Ahora dame su edad");
			edad=sc.nextInt();
			edadSuma+=edad;
			alturaSuma+=altura;
			
			if(edad>=18)
				m18++;
			
			if(altura>1.75)
				a175++;	
		}
		double mediaEdad=edadSuma/5;
		double mediaAltura=alturaSuma/5;
		
		System.out.println("La media de edad es "+mediaEdad);
		System.out.println("La media de altura es "+mediaAltura);
		System.out.println("El total de +18 es "+m18);
		System.out.println("El total de alumnos mayores de 1.75 es "+a175);

	}

}
