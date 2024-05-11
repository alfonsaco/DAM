package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame un número: ");
		int dia=sc.nextInt();
		
		switch(dia){
		case 1:
			System.out.println("Corresponde al lunes");
			break;
		case 2:
			System.out.println("Corresponde al martes");
			break;
		case 3:
			System.out.println("Corresponde al miercoles");
			break;
		case 4:
			System.out.println("Corresponde al jueves");
			break;
		case 5:
			System.out.println("Corresponde al viernes");
			break;
		case 6:
			System.out.println("Corresponde al sábado");
			break;
		case 7:
			System.out.println("Corresponde al domingo");
			break;
		default:
			System.out.println("Número inválido");
	
		}

	}

}
