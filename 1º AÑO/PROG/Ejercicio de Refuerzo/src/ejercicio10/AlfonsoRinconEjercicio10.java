package ejercicio10;

import java.util.Arrays;
import java.util.Scanner;

public class AlfonsoRinconEjercicio10 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int [] array=new int[numeroPos()];
		generarNumeros(array);
		int opcion=0;
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println(imprimirArray(ordenarArray(array)));
				break;
			case 2:
				System.out.println(buscarElemento(array));
				break;
			case 3:
				System.out.println(devolverIndice(array));
				break;
			}
		}while(opcion!=4);
		System.out.println("Se cerró el programa");
	}
	
	/**
	 * Método para buscar en qué índice está el número
	 * 
	 * @param array
	 * @return		Devolverá una cadena
	 */
	private static String devolverIndice(int[] array) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dime el elemento que quieres buscar: ");
		int n=sc.nextInt();
		for (int i = 0; i < array.length; i++) {
			if(array[i]==n) {
				return "Está en el índice "+i;
			}
		}
		return "No está presente";
	}
	/**
	 * Método para verificar si el número está presente en el array
	 * 
	 * @param array
	 * @return		cadena con un mensaje afirmativo o negativo
	 */
	private static String buscarElemento(int[] array) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dime el elemento que quieres buscar: ");
		int n=sc.nextInt();
		String afirmativo=n+" está presente";
		String negativo=n+" no está presente";
		for (int i = 0; i < array.length; i++) {
			if(array[i]==n) {
				return afirmativo;
			}
		}
		return negativo;
	}
	/**
	 * Método para ordenar un array 
	 * 
	 * @param array
	 * @return		array ordenado
	 */
	private static int[] ordenarArray(int[] array) {
		Arrays.sort(array);
		return array;
	}
	/**
	 * Método para imprimir el array
	 * 
	 * @param array
	 * @return		cadena, de  tipo String. Representa el array
	 */
	private static String imprimirArray(int[] array) {
		String cadena="";
		for (int i = 0; i < array.length; i++) {
			cadena+=array[i]+", ";
		}
		return cadena.substring(0, cadena.length()-2);
	}
	/**
	 * Menú
	 */
	private static void menu() {
		System.out.println();
		System.out.println("1. Ordenar array");
		System.out.println("2. Buscar elemento (decir si está o no)");
		System.out.println("3. Buscar elemento y devolver índice en el array");
		System.out.println("4. Salir");
	}
	/**
	 * Método para agregar números a cada posición del array
	 * 
	 * @param array
	 * @return		devuelve el array
	 */
	private static int[] generarNumeros(int[] array) {
		Scanner sc=new Scanner(System.in);
		int cont=0;
		for (int i=0; i<array.length; i++) {
			System.out.print("Número de la posición "+cont+": ");
			cont++;
			array[i]=sc.nextInt();
		}
		return array;
	}

	/**
	 * Metodo para asignar el número de posiciones que queremos que tenga el array
	 * 
	 * @return	n, de tipo int
	 */
	private static int numeroPos() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame el número de posiciones que quieres que tenga tu Array: ");
		int n=sc.nextInt();
		return n;
	}
}