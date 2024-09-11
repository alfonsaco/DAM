package Otros;

import java.util.Scanner;
/**
 * Clase para poner la inicial de cada palabra en mayúsculas.
 * Contiene un main
 * 
 * @author PROGRAM
 * @version 1.0
 */
public class AlfonsoRinconEjercicio2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame una cadena de texto (con la primera letra en minúsculas): ");
		String cadena=sc.nextLine();
		System.out.println(ponerMayuscula(cadena));
	}
	/**
	 * Método para poner las iniciales de cada palabra en mayúsculas
	 * 
	 * @param cadena
	 * @return		nuevaCadena, que es la cadena con la inicial de cada palabra en mayúsculas 
	 */
	private static String ponerMayuscula(String cadena) {
		// Con esto pondremos la primera letra en mayúsculas
		String nuevaCadena=cadena.toUpperCase().substring(0,1)+cadena.substring(1,cadena.length());
		// Con este bucle, cada vez que haya un espacio, pondrá la palabra en mayúscuña
		for (int i = 1; i < cadena.length(); i++) {
			if(cadena.charAt(i-1) == ' ') {
				nuevaCadena=nuevaCadena.substring(0,i)+Character.toUpperCase(nuevaCadena.charAt(i))+nuevaCadena.substring(i+1,cadena.length());
			}
		}
		return nuevaCadena;
	}
}