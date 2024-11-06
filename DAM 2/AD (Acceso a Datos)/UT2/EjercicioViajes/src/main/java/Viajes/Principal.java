package Viajes;

import java.sql.Connection;
import java.util.Scanner;

public class Principal {

	static Connection conexion=Conexion.getOracle("VIAJES", "DAM");
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion=-1;
		
		do {
			menu();
			opcion=sc.nextInt();
			
			switch (opcion) {
			case 1:
				break;
				
			case 2:
				break;
				
			case 3:
				break;
			
			case 0:
				System.out.println("Se finalizó el programa");
				break;
			}
			
		} while (opcion!=0);
	}

	private static void menu() {
		System.out.println("--------------------------------------------");
		System.out.println("1. Mostrar reservas");
		System.out.println("");
		System.out.println("");
		System.out.println("0. Salir");
		System.out.println("--------------------------------------------");
	}
}
