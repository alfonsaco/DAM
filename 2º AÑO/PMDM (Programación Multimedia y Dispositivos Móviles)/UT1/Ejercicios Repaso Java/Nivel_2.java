package Ejercicios;

import java.util.Iterator;
import java.util.Scanner;

public class Nivel_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Pedimos números al usuario
		System.out.print("Número 1: ");
		int n1=sc.nextInt();
		System.out.print("Número 2: ");
		int n2=sc.nextInt();
		System.out.print("Número 3: ");
		int n3=sc.nextInt();
		
		String cadena="";
		// Comparaciones
		if(n1 > n2 && n1 > n3) {
			cadena+=n1;
			if(n2 > n3) {
				cadena+=">"+n2+">"+n3;
			} else {
				cadena+=">"+n3+">"+n2;				
			}
		} else if(n2 > n1 && n2 > n3) {
			cadena+=n2;
			if(n1 > n3) {
				cadena+=">"+n1+">"+n3;
			} else {
				cadena+=">"+n3+">"+n1;				
			}
		} else if(n3 > n1 && n3 > n2){
			cadena+=n3;
			if(n2 > n1) {
				cadena+=">"+n2+">"+n1;
			} else {
				cadena+=">"+n1+">"+n2;				
			}
		}
		
		System.out.println(cadena);
	}

}
