package arraysUnidimensionales;

import java.util.Scanner;

public class EncontrarValorEnArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		int[] numerosAleatorios=new int[20];
		System.out.println("Dame el valor que deseas buscar: ");
		n=sc.nextInt();
		generarNumerosAleatorios(numerosAleatorios);
		encontrarValorEnArray(numerosAleatorios,n);
		mostrarNumerosAleatorios(numerosAleatorios);
		sc.close();
	}
	
	private static void encontrarValorEnArray(int[]numerosAleatorios, int n) {
		int contador=0;
		for (int i=0;i<=numerosAleatorios.length-1;i++) {
			if (numerosAleatorios[i]==n) {
				System.out.println("Se ha encontrado el valor en la posición: "+i);
				contador++;
			}
		}
		System.out.println("El valor "+n+" ha aparecido "+contador+" veces en los números generados.");	
		
	}

	private static void generarNumerosAleatorios(int[] numerosAleatorios) {
        for (int i=0;i<numerosAleatorios.length;i++) 
            numerosAleatorios[i]=(int)(Math.random()*25)+ 1;
        
    }
	
	private static void mostrarNumerosAleatorios(int[] numerosAleatorios) {
    	System.out.println("Los 20 números generados son: ");
        for (int i=0;i<numerosAleatorios.length;i++) 
            System.out.print(numerosAleatorios[i]+" ");
    }

}
