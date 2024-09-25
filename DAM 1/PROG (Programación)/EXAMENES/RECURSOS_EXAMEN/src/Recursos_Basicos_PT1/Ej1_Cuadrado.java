package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej1_Cuadrado {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=2;
		
		do {
			System.out.println("Dame un número y te mostraré su cuadrado");
			n=sc.nextInt();
			
			if(n>0) {
				int cuadrado=n*n;
				System.out.println("El cuadrado de "+n+" es "+cuadrado);
			}else {
				System.out.println("Se cerró el programa");
			}
		}while(n>0);
//		AL HACERLO CON UN IF Y ELSE DENTRO DEL DO WHILE, LO QUE HACEMOS ES QUE 
//		CUANDO PONGAMOS UN NÚMERO NEGATIVO NOS DIGA DIRECTAMENTE "Se cerró el 
//		programa", EN LUGAR DE DARNOS EL CUADRADO DEL NEGATIVO Y DARNOS LUEGO
//		LA FRASE
	}

}
