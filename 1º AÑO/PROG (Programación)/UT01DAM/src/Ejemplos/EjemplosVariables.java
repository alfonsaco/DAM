package Ejemplos;

import java.nio.file.spi.FileSystemProvider;

public class EjemplosVariables {

	public static void main(String[] args) {
//		Esto es un ejemplo
		
		System.out.println("Variables");
		//Declaramos el tipo y nombre de variable
		//Declarar e inicializat una variable tipo nombre = valor
		int edadAlumno;
		int edadProfesor=140;
		
		int x=1;
		float tamaño=5.7f;
		double distancia=20000;
		boolean encontrado=true;
		
		x=4;
		System.out.println("x"+x);
		x=x+2;
		System.out.println("Suma x="+x);
		x=7/4;
		System.out.println("División x="+x);
		x=7%4;
		System.out.println("Resto x="+x);

		
	}
}