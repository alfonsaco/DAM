package Otros;

import java.util.Arrays;
import java.util.Scanner;

public class AlfonsoRinconEjercicio3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] caracteres= {'C','G','T','J','L','Q'};
		System.out.println("El Array es el siguiente: "+Arrays.toString(caracteres));
		int opcion=0;
		do {
			menu();
			opcion=sc.nextInt();
			if(opcion==1) {
				ascendente();
			}else if(opcion==2) {
				System.out.println();
			}
		} while (opcion!=10);
	}

	private static void ascendente() {
		char[] letras= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'}; 
	}

	private static void menu() {
		System.out.println("Ordenar el Array:");
		System.out.println("\t1. Asc");
		System.out.println("\t2. Desc");
	}	
}
