package appCartas;

public class Jugador {
	private String nombre;
	private Carta carta;
	
	// Constructor
	public Jugador(String nombre, Carta carta) {
		this.nombre = nombre;
		this.carta = carta;
	}
	public Jugador() {
		this.nombre = "";
		this.carta=new Carta();
	}
	
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Carta getCarta() {
		return carta;
	}
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
}
