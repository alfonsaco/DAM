package juegos;

import java.util.Arrays;
import java.util.Scanner;

public class bingo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String j1,j2;
		int[]boleto1=new int[5];
		int[]boleto2=new int[5];
		int bola=0;
		System.out.println("Jugador 1: ");
		j1=sc.next();
		System.out.println("Jugador 2: ");
		j2=sc.next();
		getBoleto(boleto1);
		getBoleto(boleto2);
		imprimeJugador(j1,boleto1);
		imprimeJugador(j2,boleto2);	
		System.out.println("****************************************");
		do {
			//Genero una bola
			bola=(int)(1+Math.random()*20);
			System.out.println("	SALE EL NÚMERO: "+bola);
			//Busco el número
			for(int i=0;i<boleto1.length;i++){
				if(bola==boleto1[i]) {
					boleto1[i]=0;
					System.out.println("Encontrado "+bola+" en boleto1 "+Arrays.toString(boleto1));
				}
				if(bola==boleto2[i]) {
					boleto2[i]=0;
					System.out.println("Encontrado "+bola+" en boleto2 "+Arrays.toString(boleto2));
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(!gana(boleto1) && !gana(boleto2));
		imprimirGanador(boleto1, j1, j2);
		sc.close();
	}

	public static void getBoleto(int []b){		
		for(int i=0;i<b.length;i++)
			b[i]=(int)(1+Math.random()*20);
	}
	
	public static String getAlias(String nombre) {
		if(nombre.length()>=3)
			return "J"+nombre.substring(0,3)+(int)(Math.random()*100);
		else
			return "J"+nombre+(int)(Math.random()*100);
	}
	
	private static boolean gana(int []boleto) {
		for(int i=0;i<boleto.length;i++)
			if(boleto[i]!=0)
				return false;
		return true;
	}

	private static void imprimeJugador(String j, int[] boleto) {
		System.out.println("El jugador "+j+" con alias "+getAlias(j)+" tiene el boleto "+Arrays.toString(boleto));
	}
	
	private static void imprimirGanador (int[]boleto1, String j1, String j2) {
		if (gana(boleto1))
			System.out.println("Ha ganado "+j1);
		else
			System.out.println("Ha ganado "+j2);
	}
	
}
