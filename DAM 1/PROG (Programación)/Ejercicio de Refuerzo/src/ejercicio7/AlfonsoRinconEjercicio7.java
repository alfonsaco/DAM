package ejercicio7;

import java.util.Scanner;
/**
 * Clase destinada a pasar un número decimal a binario 
 * Esta clase contiene un método main
 * 
 * @author alfonso
 * @version 1.0
 */
public class AlfonsoRinconEjercicio7 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame un número y te daré su binario: ");
		int numero=sc.nextInt();
		String binarioInvertido=sacarBinario(numero);
		String binario=invertirBinario(binarioInvertido);
		System.out.println(binario);
	}
	/**
	 * Método para invertir el número binario y devolverlo correctamente
	 * 
	 * @param binario
	 * @return			cadena, de tipo String
	 */
	private static String invertirBinario(String binario) {
		String cadena="";
		for (int i = binario.length()-1; i>=0 ; i--) {
			cadena+=binario.charAt(i);
		}
		return cadena;
	}
	/**
	 * Método para sacar el binario. Nos lo dará invertido
	 * 
	 * @param numero
	 * @return		binario invertido, de tipo String
	 */
	private static String sacarBinario(int numero) {
		int resto;
		String binario="";
		do {
			resto=numero%2;
			numero/=2;
			binario+=String.valueOf(resto);
		} while (numero>=1);
		return binario;
	}
}