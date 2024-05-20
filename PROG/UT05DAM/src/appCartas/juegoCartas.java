package appCartas;

public class juegoCartas {
	public static void main(String[] args) {		
		// Creamos 2 cartas
		Carta c1=new Carta();
		Carta c2=new Carta();
		// Creamos 2 jugadores, que tendrán estas cartas
		Jugador jug1=new Jugador("Pepe", c1);
		Jugador jug2=new Jugador("Jorge", c2);

		// COMIENZA EL JUEGO
		// El jugador que consiga una mayor suma con sus cartas pares gana
		int suma1=juegoPar();
		int suma2=juegoPar();
		System.out.println(jug1.getNombre()+" ha conseguido "+suma1+" puntos");
		System.out.println(jug2.getNombre()+" ha conseguido "+suma2+" puntos");
		
		// Elegir un ganador
		System.out.println();
		if(suma1>suma2) {
			System.out.println(jug1.getNombre()+" gana!");
		}else {
			System.out.println(jug2.getNombre()+" gana!");
		}
	}

	private static int juegoPar() {
		Carta c=new Carta();
		int suma=0;
		int cont=0;
		do {
			c.extraerCarta();
			if(c.getNumero()%2==0) {
				suma+=c.getNumero();
			}
			cont++;
		}while(cont<3);
		return suma;
	}
}
