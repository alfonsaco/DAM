package Ejercicio2;

import java.util.Scanner;
/**
 * Programa que asigna un número a su día de la semana
 */
public class AlfonsoRinconEjercicio2 {
	public static void main(String[] args) {
		int dia=pedirDia();
		String nombre=diaSemana(dia);
		System.out.println("El dia de la semana es "+nombre);
	}

	/**
	 * Método para poder elegir un número
	 * 
	 * @return	Dia		Devuelve un int
	 */
	private static int pedirDia() {
		Scanner sc=new Scanner(System.in);
		int dia=11;
		do {
			System.out.print("Dime el día de la semana: ");
			dia=sc.nextInt();
		}while(dia<1 || dia>7);
		return dia;
	}
	/**
	 * Método para asociar el numero con el nombre
	 * 
	 * @param dia	Es el int que ha indicado el usuario
	 * @return	nombre	Devuelve el nombre asociado a ese día
	 */
	private static String diaSemana(int dia) {
		String [] dias= {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		String nombre=dias[dia-1];
		
		return nombre;
	}
}
