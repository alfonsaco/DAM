package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i;
		
		do {
			i=sc.nextInt();
			if(i%2==1) {
				System.out.println("Es impar");
			} else if(i%2==0) {
				System.out.println("Es par");
			}
			
		}while(i!=0);
		System.out.println("Es cero amigo");

	}

}
