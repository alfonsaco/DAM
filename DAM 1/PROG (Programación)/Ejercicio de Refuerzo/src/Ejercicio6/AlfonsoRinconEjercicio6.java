package Ejercicio6;

import java.util.Iterator;
import java.util.Scanner;

public class AlfonsoRinconEjercicio6 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame una cadena: ");
		String cadena=sc.nextLine();
		System.out.println("Dame el número del desplazamiento que queremos realizar");
		int desp=sc.nextInt();
		char[] cadenaNueva=cesar(cadena,desp);
		System.out.println(cadenaNueva);
	}
	/**
	 * Método para realizar el cifrado césar
	 * 
	 * @param cadena
	 * @param desp
	 * @return	
	 */
	private static char[] cesar(String cadena, int desp) {
		char [] letras={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','z'};
		char[] nuevo=new char[cadena.length()];
		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < letras.length; j++) {
				// Ponemos en minúsculas las letras en mayúsculas
				if(cadena.toLowerCase().charAt(i) == letras[j]) {
					nuevo[i]=letras[j+desp];
				}
				if(cadena.charAt(i) != letras[i]) {
					nuevo[i]=nuevo[i];
				}
			}
		}
		return nuevo;
	}
}