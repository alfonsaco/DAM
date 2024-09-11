package CondicionesYBucles;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
	Random ran=new Random();
	Scanner sc=new Scanner(System.in);
	int r=ran.nextInt(20);
	int i;
	int contador=0;
	System.out.println("Intenta adivinar el número.");
	
	do {
		i=sc.nextInt();
		if(i<r) {
			System.out.println("El número es mayor");
			contador++;
		} else if(i>r) {
			System.out.println("El número es menor");
			contador++;
		}
	} while(i!=r && contador<5);
	System.out.println("Has acertado, el número era "+r);

	}

}
