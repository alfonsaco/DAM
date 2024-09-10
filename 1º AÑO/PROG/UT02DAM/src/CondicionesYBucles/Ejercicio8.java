package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i;
		do {
			i=sc.nextInt();
			if(i>0) {
				System.out.println("Es positibvo");
			} else if(i<0) {
				System.out.println("Es negativo");
			}
		} while(i!=0);
			System.out.println("Es 0");

	}

}
