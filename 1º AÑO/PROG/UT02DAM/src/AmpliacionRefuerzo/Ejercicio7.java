package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame el tiempo en segundos: ");
		int s=sc.nextInt();
		
		int m=s/60;
		int seg=s%60;
		System.out.println(m+"."+seg+" s");

	}

}
