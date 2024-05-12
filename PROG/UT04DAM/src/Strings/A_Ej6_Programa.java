package Strings;

import java.util.Scanner;

public class A_Ej6_Programa {

	public static void main(String[] args) {
//		Realizar un programa que haga lo siguiente:
//			1) Pida al usuario un número entero comprendido entre [10,25] y repita la solicitud en caso
//				de que el número no pertenezca al intervalo.
//			2) Una vez introducido el número el programa debe detectar si es divisible por 5 y mostrar el
//				mensaje adecuado.
//			3) Luego, el programa pedirá al usuario su nombre para mostrarle lo siguiente:
//				Número de caracteres del nombre
//				Carácter inicial y final
//				Nombre e mayúsculas
//				Indicación de si la lentra ñ o la Ñ forman parte de su nombre
//			NOTA 1: las excepciones deben gestionarse con la cláusula “throws IOException”.
//			NOTA 2: la letra ñ es el carácter 164 de la tabla Unicode, la Ñ el 165.
			Scanner sc=new Scanner(System.in);
			int n=0;
			
			do {
				System.out.println("Dame un número entre 10 y 25");
				n=sc.nextInt();
				if(n<10 || n>25)
					System.out.println("Número no válido");
				else
					System.out.println("Número válido");
			}while(n<10 || n>25);
			
			divisible(n);
			
			System.out.println("Dame tu nombre: ");
			sc.nextLine();	// Consumir el salto de línea anterior ***
			String nombre=sc.nextLine();
			
			caracteres(nombre);
			inicialYfinal(nombre);
			enMayusculas(nombre);
			
			boolean contieneÑ = nombre.contains("\u00D1") || nombre.contains("\u00F1");
			System.out.println("La letra ñ o la Ñ " + (contieneÑ ? "sí" : "NO") + " forman parte del nombre.");
	}

	private static void inicialYfinal(String nombre) {
		char incial=nombre.charAt(0);
		char final1=nombre.charAt(nombre.length()-1);
		System.out.println("La letra inicial es "+incial+" y la última letra es "+final1);
	}

	private static void enMayusculas(String nombre) {
		String resultado=nombre.toUpperCase();
		System.out.println(nombre+" en mayúsculas es "+resultado);
		
	}

	private static void caracteres(String nombre) {
		int contador=0;
		for(int i=nombre.length()-1; i>=0; i--) {
			contador++;
		}
//		La forma más sencilla de hacerlo es:
//		int numCaracteres = nombre.length();
//        System.out.println("Número de caracteres del nombre: " + numCaracteres);
		System.out.println("El número de carácteres de "+nombre+" es "+contador);
	}

	private static void divisible(int n) {
		if(n%5==0) {
			System.out.println(n+" es divisible entre 5");
		}else {
			System.out.println(n+" no es divisible entre 5");
		}
		
	}

}

//***	Cuando se utiliza el método sc.nextLine() después de leer un valor numérico con
//		sc.nextInt(), puede haber un problema debido a que nextInt() no consume el carácter 
//		de salto de línea (new line) que se ingresa después de presionar Enter.
//
//		Esto puede generar un comportamiento inesperado cuando se lee una cadena de texto 
//		con nextLine() después de nextInt(), ya que nextLine() lee el carácter de salto de 
//		línea pendiente en lugar de esperar una nueva entrada del usuario.
//
//		Para solucionar este problema, se puede agregar una llamada adicional a sc.nextLine() 
//		después de nextInt() para consumir el carácter de salto de línea antes de leer la 
//		siguiente línea de texto. Esto se conoce como "consumir el salto de línea anterior".
