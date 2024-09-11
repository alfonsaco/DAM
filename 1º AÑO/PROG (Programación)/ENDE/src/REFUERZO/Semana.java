package REFUERZO;

import java.util.Scanner;
/**
 * Clase destinada a decir qué dia de la semana corresponde a cada número
 */
public class Semana {
	public static void main(String[] args) {
		int dia=pedirDia();
		String nombre=diaSemana(dia);
		System.out.println("El dia de la semana es "+nombre);
	}
	/**
	 * Método para pedir un número
	 * 
	 * @return   Dia   Devuelve el número que será el día de la semana
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

	private static String diaSemana(int dia) {
		String [] dias= {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		String nombre=dias[dia-1];
		
		return nombre;
	}
}