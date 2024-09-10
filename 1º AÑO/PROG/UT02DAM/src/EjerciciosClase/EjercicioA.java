package EjerciciosClase;

import java.util.Scanner;

public class EjercicioA {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame números enteros. Con el 2 se cierra el programa");
		int suma=0;
		int iPrimero=sc.nextInt();
		int contador=0;
		
		if(iPrimero!=2 && iPrimero%2==0) {
			contador++;
			while(iPrimero!=2 && iPrimero%2==0) {
				iPrimero=sc.nextInt();
				contador++;
			}
			System.out.println("El número de pares ha sido "+contador);
			
		} else if(iPrimero!=2 && iPrimero%2==1) {
			do {
				iPrimero=sc.nextInt();
				suma=suma+iPrimero;
			} while(iPrimero!=2 && iPrimero<10 && iPrimero%2==1);
			System.out.println("La suma es "+suma);
			
		} else if(iPrimero==2) {
			System.out.println("Se finalizó el programa");
		}
			


	}

}
