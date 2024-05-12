package arraysUnidimensionales;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenarNumeros {

	public static void main(String[] args) {
		int[]numeros=new int[5];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<5;i++) {
            System.out.print("Dame un número: ");
            numeros[i]=sc.nextInt();
        }
        ordenarNumeros(numeros);
        mostrarNumerosOrdenados(numeros);
        sc.close();
	}
	
	private static void ordenarNumeros(int[] numeros) {
        Arrays.sort(numeros);
    }

    private static void mostrarNumerosOrdenados(int[] numeros) {
        System.out.println("Números ordenados de menor a mayor:");
        for (int i=0;i<5;i++) {
            System.out.print(numeros[i]+" ");
        }
    }

}
