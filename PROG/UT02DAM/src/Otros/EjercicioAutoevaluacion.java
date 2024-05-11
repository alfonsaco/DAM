package Otros;

import java.util.Scanner;

public class EjercicioAutoevaluacion {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingresa tu nomnbre");
		String nombre=sc.next();
		System.out.println("Bienvenido "+nombre);

		
		System.out.println("Inserta tu año de nacimiento");
		int aNac=sc.nextInt();
		int edad=2023-aNac;
		System.out.println("Tienes "+edad+" años");
		
		if(edad==18) {
			System.out.println("Tienes 18 años");
		} else if(edad<18) {
			System.out.println("Eres menor de 18 años");
		} else {
			System.out.println("Eres mayor de 18 años");
		}
		
		System.out.println("*****************************************");
		System.out.println("Nombre: "+nombre);
		System.out.println("Año de nacimiento: "+aNac);
		System.out.println("Edad: "+edad);
		System.out.println("*****************************************");
		
		
		System.out.println("Dame un número para ver a que día de la semana corresponde");
		int numero=sc.nextInt();
		switch(numero) {
			case 1:
				System.out.println("Pertenece al lunes");
				break;
			case 2:
				System.out.println("Pertenece al martes");
				break;
			case 3:
				System.out.println("Pertenece al miercoles");
				break;
			case 4:
				System.out.println("Pertenece al jueves");
				break;
			case 5:
				System.out.println("Pertenece al viernes");
				break;
			case 6:
				System.out.println("Pertenece al sábado");
				break;
			case 7:
				System.out.println("Pertenece al domingo");
				break;
			default:
				System.out.println("Número inválido");
				break;
		}
		
		System.out.println("*****************************************");
		int suma=0;
		for(int i=0; i<=6; i++) {
			System.out.println("Dame 6 números");
			double nota=sc.nextDouble();
			suma += nota;
		}
		
		double media=suma/6;
		System.out.println("La media es "+media);
		System.out.println("*****************************************");
		
		System.out.println("Dame un número: ");
		int n1=sc.nextInt();
		
		for(int e=1; e<=n1; e++) {
			if(n1%2!=1);
			System.out.println(e);
		}
		
		
		
		
	}

}
