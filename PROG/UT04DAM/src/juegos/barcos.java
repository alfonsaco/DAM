package juegos;

import java.util.Scanner;

public class barcos {

	public static void main(String[] args) {
		String boleto="AAAAAAAAAA";
		Scanner sc=new Scanner(System.in);
		int contador=0;
		int posicion=0;
		//Colocar 4 barcos de forma aleatoria
		while(contador<4) {
			posicion=(int)(Math.random()*10);
			if(boleto.charAt(posicion)!='B') {
				if(posicion!=9) 
					boleto=boleto.substring(0, posicion)+'B'+boleto.substring(posicion+1);
				else 
					boleto=boleto.substring(0, posicion)+'B';
				contador++;
			}
		}
		System.out.println(boleto);
		int intentos=6;
		do {
			System.out.println("Dame una posición");
			posicion=sc.nextInt();
			if(boleto.charAt(posicion)=='A')
				System.out.println("Agua");
			else{
				System.out.println("Hundido");
				if(posicion!=9)
					boleto=boleto.substring(0, posicion)+'A'+boleto.substring(posicion+1);
				else
					boleto=boleto.substring(0, posicion)+'A';
			}
			intentos--;
		} while(!boleto.equals("AAAAAAAAAA") && intentos>0);
		if(intentos>=0 && boleto.equals("AAAAAAAAAA"))
			System.out.println("Has ganado!!!");
		else 
			System.out.println("LOOSERRR!!!");
		sc.close();
	}
}

