package juegoBarcos;

import java.util.Arrays;

public class Jugador {
	private String nombre;
	private int edad;
	private String nick;
	private Boleto boleto;
	
	// Constructor
	public Jugador(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nick=generarNick();
		this.boleto=new Boleto(6);
		this.boleto.rellenarBoleto();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}
	
	public String generarNick() {
		if(this.nombre.length() > 3 ) {
			return "Jugador_"+nombre.substring(0,3)+edad;
		}else {
			return "Jugador_"+nombre+edad;
		}
	}
	
	@Override
	public String toString() {
		return "El jugador "+nick+" tiene el boleto "+boleto;
	}

	public static void main(String[] args) {
		Jugador j=new Jugador("MARIio", 23);
		System.out.println(j);
		
	}
	
	
}
