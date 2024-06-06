package Otros;

import java.util.Scanner;
/**
 * Método para invertir una cadena.
 * Contiene el método main
 * 
 * @author alfonso
 * @version 1.0
 */
public class AlfonsoRinconEjercicio1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame una cadena: ");
		String cadena=sc.nextLine();
		System.out.println(cadena+" invertido es "+invertirCadena(cadena));
	}
	/**
	 * Método para invertir una cadena
	 * 
	 * @param cadena
	 * @return		cadena invertida, de tipo String
	 */
	private static String invertirCadena(String cadena) {
		String invertida="";
		for (int i = cadena.length()-1; i>=0; i--) {
			invertida+=cadena.charAt(i);
		}
		return invertida;
	}
}
