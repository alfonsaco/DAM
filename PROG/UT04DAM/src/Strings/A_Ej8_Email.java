package Strings;

import java.util.Scanner;

public class A_Ej8_Email {

	public static void main(String[] args) {
//		Realizar una clase, que permita cargar una dirección de mail en el constructor, 
//		luego en otro método mostrar un mensaje si contiene el caracter '@'.
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un email: ");
		String email=sc.nextLine();
		
		esEmail(email);
	}

	private static void esEmail(String email) {
		if(email.contains("@")) {
			System.out.println("Es un email válido");
		}else {
			System.out.println("No es válido tu email");
		}
		
	}

}
