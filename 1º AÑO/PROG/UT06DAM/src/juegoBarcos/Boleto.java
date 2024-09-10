package juegoBarcos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Boleto {
	private char[] b;
	private int longitud;
	
	// Constructor
	public Boleto(int longitud) {
		this.longitud = longitud;
		this.b=new char[longitud];
		for (int i = 0; i < longitud; i++) {
			b[i]='A';
		}
	}
	
	// Getters y Setters
	public char[] getB() {
		return b;
	}
	public void setB(char[] b) {
		this.b = b;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	
	public void rellenarBoleto() {
		int pos1=(int)(Math.random()*longitud);
		int pos2=pos1;
		
		do {
			pos2=(int)(Math.random()*longitud);
		}while(pos1==pos2);
		
		b[pos1]='B';
		b[pos2]='B';
	}
	
	public void imprimirBoleto() {
		System.out.println(Arrays.toString(this.getB()));
	}
	
	// Prueba unitaria
	public static void main(String[] args) {
		Boleto bol=new Boleto(10);
		bol.rellenarBoleto();
		bol.imprimirBoleto();
		
	}

	@Override
	public String toString() {
		return Arrays.toString(this.getB());
	}	
}
