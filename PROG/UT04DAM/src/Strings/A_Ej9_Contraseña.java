package Strings;

import java.util.Scanner;

public class A_Ej9_Contraseña {

	public static void main(String[] args) {
//		Desarrollar un programa que solicite la carga de una clave. La clase debe tener dos 
//		métodos uno para la carga y otro que muestre si la clave es la correcta (la clave a 
//		comparar es "123abc")
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una contraseña: ");
		String contraseña=sc.nextLine();
		
		System.out.println("Confirma tu contraseña: ");
		String verifica=sc.nextLine();
		
		verificacion(contraseña, verifica);
	}

	private static void verificacion(String contraseña, String verifica) {
		if(contraseña.equals(verifica)) {
			System.out.println("Las contraseñas coinciden");
		}else {
			System.out.println("Las claves no coinciden");
		}
		
	}

}
