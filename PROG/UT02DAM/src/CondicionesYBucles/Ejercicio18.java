package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=0;
		int contador=0;
		int ceros=0;
		int sumaPos=0;
		int mediaPos;
		int sumaNeg=0;
		int mediaNeg;
		int contadorPos=0;
		int contadorNeg=0;
		
		while(contador<10) {
			System.out.println("Dame un número: ");
			i=sc.nextInt();
			contador++;
			
			if(i==0) {
				ceros++;
			} else if(i>0) {
				sumaPos=sumaPos+i;
				contadorPos++;
			} else if(i<0) {
				sumaNeg=sumaNeg+i;
				contadorNeg++;
			}
		}
		mediaPos=sumaPos/contadorPos;
		mediaNeg=sumaNeg/contadorNeg;
		System.out.println("Hay un total de "+ceros+" ceros");
		System.out.println("La media de los positivos es "+mediaPos);
		System.out.println("La media de los negativos es "+mediaNeg);
		
	}

}
