package Juegos;

import java.util.Scanner;
import java.util.Arrays;

public class dado {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		String j1,j2;
		int[]resultado1=new int[5];
		int[]resultado2=new int[5];
		int contador1=0;
		int contador2=0;
		int contadorJugadas=0;
		do {
			System.out.println("Jugador1: Introduce el nick");
			j1=sc.nextLine();
		} while(!nickCorrecto(j1));
		do {
			System.out.println("Jugador2: Introduce el nick");
			j2=sc.nextLine();
		} while(!nickCorrecto(j2));
		generarResultado(j1,resultado1);
		generarResultado(j2,resultado2);
		mostrarResultado(j1,resultado1);
		mostrarResultado(j2,resultado2);
		System.out.println("*****************Comienza el juego*****************");
		do {
			for(int i=0;i<resultado1.length;i++){
				int resultadoDado=(int)(1+Math.random()*6);
				System.out.println("Dado: "+resultadoDado);
				if(resultadoDado==resultado1[i]) {
					System.out.println("	"+j1+" coincide con el resultado del lanzamiento "+i);
					contador1++;
				}
				if(resultadoDado==resultado2[i]) {
					System.out.println("	"+j2+" coincide con el resultado del lanzamiento "+i);
					contador2++;
				}
			}
			contadorJugadas++;
		} while(contadorJugadas==5);
		mostrarResultado(j1,contador1,j2,contador2);
		sc.close();
	}


	private static void mostrarResultado(String j1, int contador1, String j2, int contador2) {
		if (contador1>contador2)
			System.out.println("Gana "+j1+" con aciertos="+contador1);
		else if(contador2>contador1)
			System.out.println("Gana "+j2+" con aciertos="+contador2);
		else
			System.out.println("Empatan "+j1+" y "+j2+" con los mismos aciertos");
	}



	private static void generarResultado(String j2, int[] resultado) {
		for(int i=0;i<resultado.length;i++)
			resultado[i]=(int)(1+Math.random()*5);
		
	}

	private static void mostrarResultado(String jugador, int[]resultado) {
		System.out.println(jugador+" tiene "+Arrays.toString(resultado));
	}

	private static boolean nickCorrecto(String jugador) {
		return jugador.matches("^J[A-Z]{3}[0-9]");
	}

}
