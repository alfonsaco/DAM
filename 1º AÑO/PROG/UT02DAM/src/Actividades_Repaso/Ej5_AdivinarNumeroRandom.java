package Actividades_Repaso;

import java.util.Scanner;
import java.util.Random;

public class Ej5_AdivinarNumeroRandom {

	public static void main(String[] args) {
		// Realizar un juego para adivinar un número. Para ello generar un número N 
//		aleatorio entre 1 y 20, y luego ir pidiendo números indicando “mayor” o “menor” 
//		según sea mayor o menor con respecto a N. El proceso termina cuando el usuario 
//		acierta
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		int nRandom=random.nextInt(21)+1; //PONEMOS +1 PARA QUE NO GENERE UN 0, YA QUE EL NÚMERO QUE QUEREMOS ESTÁ ENTRE 1-20 INCLUIDOS
		int n;
		System.out.println("Intenta adivinar un número entre 1 y 21");
		
		do {
			System.out.println("Dame un número");
			n=sc.nextInt();
			
			if(n>nRandom) {
				System.out.println("Es menor");
			} else if(n<nRandom) {
				System.out.println("Es mayor");
			} else if(n==nRandom) {
				System.out.println("Acertaste, El número era "+nRandom);
			} else if(n==0 || n<0 || n>20) {
				System.out.println("Número no válido");
			}
		}while(n!=nRandom);
		

	}

}
