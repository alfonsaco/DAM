package appCartas;

public class Carta {
	private int numero;
	private String palo;
	
	// Constructor
	public Carta() {
		this.numero = 0;
		this.palo = "";
	}

	// Getters y Setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}

	// toString
	@Override
	public String toString() {
		return numero+" de "+palo;
	}
	
	public void extraerCarta() {
		// Número aleatorio
		this.setNumero((int)(1+Math.random()*12));
		// Palo aleatorio
		String[] palos={"Oros","Espadas","Bastos","Copas"};
		int n1=(int)(1+Math.random()*4);
		this.setPalo(palos[n1-1]);
	}
	
	// Prueba unitaria, generamos una carta y la imprimimos
	public static void main(String[] args) {
		Carta c=new Carta();
		c.extraerCarta();
		System.out.println(c);
	}
}
