package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej3_ParOImpar {

	public static void main(String[] args) {
		// Leer números hasta que se introduzca un 0. Para cada uno indicar si es par o impar.
		Scanner sc=new Scanner(System.in);
		int n=2;
		
		do {
			System.out.println("Dame un número, y te diré si es par o impar");
			n=sc.nextInt();
			
			if(n%2==0 && n!=0) {
				System.out.println(n+" es par");
			}else if(n==0){
				System.out.println("Se cerró el programa");
			}else {
				System.out.println(n+" es impar");
			}
		}while(n!=0);

	}

}
