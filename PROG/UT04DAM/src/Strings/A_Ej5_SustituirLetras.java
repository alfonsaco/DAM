package Strings;

import java.util.Scanner;

public class A_Ej5_SustituirLetras {
	
	public static void main(String[] args) {
//		Crea un programa Java que lea por teclado y muestre un mensaje con el número de veces
//		que ha aparecido la letra A y la letra E.
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame una frase: ");
		String frase=sc.nextLine();
		
		int contadorA=0;
		int contadorE=0;
		
		for(int i=0; i<frase.length(); i++) {
			char letra=frase.charAt(i);
			if(letra=='a' || letra=='A') {
				contadorA++;
			}else if(letra=='e' || letra=='E') {
				contadorE++;
			}
				
		}
		
		System.out.println("Número de veces que aparece la letra A: " + contadorA);
        System.out.println("Número de veces que aparece la letra E: " + contadorE);
	}

}
