package juegoBarcos;

import java.util.Iterator;
import java.util.Scanner;

public class Juego {
	private Jugador j1;
	private Jugador j2;
	
	// Constructor
	public Juego(Jugador j1, Jugador j2) {
		this.j1 = j1;
		this.j2 = j2;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame el nombre del Jugador 1: ");
		String nombre1=sc.next();
		System.out.print("Dame la edad del Jugador 1: ");
		int edad1=sc.nextInt();
		System.out.print("Dame el nombre del Jugador 2: ");
		String nombre2=sc.next();
		System.out.print("Dame la edad del Jugador 2: ");
		int edad2=sc.nextInt();
		
		Jugador j1=new Jugador(nombre1,edad1);
		Jugador j2=new Jugador(nombre2,edad2);
		
		Juego j=new Juego(j1,j2);
		j.Partida();
	}

	private void Partida() {
		System.out.println(j1);
		System.out.println(j2);
		System.out.println();		
		
		System.out.println("***********************************************");
		System.out.println("**********     COMIENZA EL JUEGO    ***********");
		System.out.println("***********************************************");
		System.out.println();
		
		int gana1=0;
		int gana2=0;
		// Par: Jugador 1    Impar: Jugador 2
		int turno=0;
		int aleatorio=0;
		
		do {
			
			try {
				Thread.sleep(1000);			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			aleatorio=(int)(Math.random()*5);
			
			if(turno%2==0) {
				// Turno del jugador 1
				System.out.println("\t JUEGA "+j1.getNick());
				System.out.println(j1.getNick()+" dice "+(aleatorio+1));
				if(j2.getBoleto().getB()[aleatorio] == 'B') {
					gana1++;
					System.out.println(j2.getNick()+" responde HUNDIDO");
				} else {
					System.out.println(j2.getNick()+" responde AGUA");
				}
				System.out.println("--------------------------------------------");
			} else {
				// Turno del jugador 2
				System.out.println("\t JUEGA "+j2.getNick());
				System.out.println(j2.getNick()+" dice "+(aleatorio+1));
				if(j1.getBoleto().getB()[aleatorio] == 'B') {
					gana2++;
					System.out.println(j1.getNick()+" responde HUNDIDO");
				} else {
					System.out.println(j1.getNick()+" responde AGUA");
				}
				System.out.println("--------------------------------------------");
			}
			
			turno++;
			// Fin de la partida
			if(gana1==2) {
				System.out.println(j1+ " ha ganado!!");
				break;
			} else if (gana2 == 2) {
				System.out.println(j2+ " ha ganado!!");
				break;
			}
		} while (gana1!=2 || gana2!=2);
		
	}
	
}
