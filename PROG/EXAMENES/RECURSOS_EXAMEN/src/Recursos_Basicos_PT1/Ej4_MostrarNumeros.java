package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej4_MostrarNumeros {

	public static void main(String[] args) {
		//Pedir números hasta que se teclee uno negativo, y mostrar cuántos números se han introducido.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador=0;
		
		do {
			System.out.println("Dame un número positivo (Negativo para cerrar el programa)");
			n=sc.nextInt();
			
			if(n>=0) {
				contador++;
			}else {
				System.out.println("Se cerró el programa");
				System.out.println("El total de número ha sido "+contador);
			}
		}while(n>=0);

	}

}
