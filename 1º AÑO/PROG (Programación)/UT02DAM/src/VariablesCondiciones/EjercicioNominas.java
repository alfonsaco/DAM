package VariablesCondiciones;

import java.util.Scanner;

public class EjercicioNominas {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("****************************************");
		System.out.println("Cálculo de nómina");
		System.out.println("****************************************");
		System.out.println("1) Programador junior");
		System.out.println("2) Programador senior");
		System.out.println("3) Jefe de proyecto");
		
		System.out.println("Introduzca el cargo del empleado: ");
		int cargo=sc.nextInt();
		
		System.out.println("¿Cuántos días ha estado visitando clientes?");
		int dias=sc.nextInt();
		
		System.out.println("Introduzca su estado civil (1. Soltero / 2. Casado)");
		int estado=sc.nextInt();
		
		System.out.println("____________________________________________________");
		
		switch(cargo) {
			case 1:
				System.out.println("Sueldo base 950.00€");
			
				break;
			case 2:
				System.out.println("Sueldo base 1200.00");
				break;
			case 3:
				System.out.println("Sueldo base 1600.00€");
				break;
			default:
				System.out.println("No válido"); 
				return;
		}
		double dietas=dias*30;
		System.out.println("Dietas ("+dias+" viajes): "+dietas+"€");
		
		
		System.out.println("____________________________________________________");
		
		double bruto=cargo+dietas;
		System.out.println("Sueldo bruto: "+bruto);
		
		double irpf;
		switch(estado) {
			case 1:
				irpf=0.25;
				System.out.println("Retención IRPF (0.25): "+irpf*bruto);
				break;
			case 2:
				irpf=0.20;
				System.out.println("Retención IRPF (0.20): "+irpf*bruto);
				break;
		}
		System.out.println("____________________________________________________");

	}

}
