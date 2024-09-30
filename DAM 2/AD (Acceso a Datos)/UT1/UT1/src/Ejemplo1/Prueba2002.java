package Ejemplo1;

import java.util.Arrays;

public class Prueba2002 {
	public static void main(String[] args) {
		int a=0;
		int b=0;
		
		try {
			System.out.println("A / B ="+(a/b));
		} catch (Exception e) {
			System.err.println("ERRRO");
		} finally {
			System.out.println("Esto se ejecuta sí o sí");
		}
	}
}