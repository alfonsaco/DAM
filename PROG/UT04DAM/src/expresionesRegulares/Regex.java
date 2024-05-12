package expresionesRegulares;

import java.util.Scanner;

public class Regex {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		String palabra=sc.next();
		if (esDNI(palabra))
			System.out.println("Es un dni correcto");
		else
			System.out.println("NO es un dni correcto");
		if (esMatricula(palabra))
			System.out.println("Es una matrícula correcta");
		else
			System.out.println("NO es una matrícula correcta");
		if (esBinario(palabra))
			System.out.println("Es un número binario");
		else
			System.out.println("NO es un número binario");
		if (esEntero(palabra))
			System.out.println("Es un número entero");
		else
			System.out.println("NO es un número entero");
		if (esEnteroPositivo(palabra))
			System.out.println("Es un número entero positivo");
		else
			System.out.println("NO es un número entero positivo");
		if (esOctal(palabra))
			System.out.println("Es un número octal");
		else
			System.out.println("NO es un número octal");
		if (esEmail(palabra))
			System.out.println("Es un email válido");
		else
			System.out.println("NO es un email válido");
		if (esISBN(palabra))
			System.out.println("Es un ISBN válido");
		else
			System.out.println("NO es un ISBN válido");
		if (esUsuario(palabra))
			System.out.println("Es un usuario válido");
		else
			System.out.println("NO es un usuario válido");
		sc.close();
		
	}
	
	private static boolean esUsuario(String s) {
		return s.matches("^@[A-Za-z0-9_-]+$");
	}

	public static boolean esDNI (String s) {
		return s.matches("[0-9]{8}[A-Z]");
	}
	
	public static boolean esMatricula (String s) {
		return s.matches("[0-9]{4}[A-Z]{3}");
	}
	
	public static boolean esBinario (String s) {
		return s.matches("^[0-1]+$");
	}
	
	public static boolean esEntero (String s) {
		return s.matches("^[+-]?[0-9]+$");
	}
	
	public static boolean esEnteroPositivo (String s) {
		return s.matches("^+?[0-9]+$");
	}
	
	public static boolean esOctal (String s) {
		return s.matches("^[0-7]+$");
	}
	
	public static boolean esEmail(String s) {
	    return s.matches("^[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+$");
	}
	
	public static boolean esISBN(String s) {
	    return s.matches("^(978|979)[0-9]{10}$");
	}

}