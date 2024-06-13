package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_CifraMayor {

	public static void main(String[] args) {
		// Realiza un programa que calcule la mayor cifra de un número introducido
			Scanner sc=new Scanner (System.in);
			System.out.println("Introduzca un número: ");
			int n=sc.nextInt();
			digitoMayor(n);
			sc.close();
		}
	
		private static void digitoMayor(int n) {
			n=Math.abs(n);
	        int mayorCifra=0;
	        while(n>0){
	            int digito=n%10;
	            if (digito>mayorCifra) {
	                mayorCifra=digito;
	            }
	            n=n/10;
	        }
	        System.out.println("La cifra mayor es: "+mayorCifra);
		}

}
