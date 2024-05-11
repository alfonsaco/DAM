package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int i;
	int contador=0;
	
	do {
		i=sc.nextInt();
		contador++;
	}while(i>=0);
	System.out.println(contador);
}
}
