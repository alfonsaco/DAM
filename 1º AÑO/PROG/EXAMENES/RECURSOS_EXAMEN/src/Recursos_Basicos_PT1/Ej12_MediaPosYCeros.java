package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej12_MediaPosYCeros {

	public static void main(String[] args) {
		// Pedir 10 números. Mostrar la media de los números positivos, la media 
		// de los números negativos y la cantidad de ceros.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int positivosSuma=0;
		int contadorPos=0;
		int negativosSuma=0;
		int contadorNeg=0;
		int contadorCero=0;
		
		
		for(int i=0; i<10; i++) {
			System.out.println("Dame un número");
			n=sc.nextInt();
			
			if(n>0) {
				positivosSuma+=n;
				contadorPos++;
			} else if(n<0) {
				negativosSuma+=0;
				contadorNeg++;
			} else if(n==0) {
				contadorCero++;
			}
		}
		double mediaPos=(contadorPos>0) ? ((double) positivosSuma/contadorPos) : 0;
		double mediaNeg=(contadorNeg>0) ? ((double) negativosSuma/contadorNeg) : 0;
		// El (contadorPos > 0) ?, lo que hace es decir si es true o falso.
		// Si es mayor que 0, se hará la división, y será true. Por tanto, habrá cogido
		// la parte del código antes del :
		// Al ocntrario. cogerá la parte que está dsepués, es decir, el 0
		
		System.out.println("La media de los positivos es "+mediaPos);
		System.out.println("La media de los negativos es "+mediaNeg);
		System.out.println("La cantidad total de ceros es "+contadorCero);
	}

}
