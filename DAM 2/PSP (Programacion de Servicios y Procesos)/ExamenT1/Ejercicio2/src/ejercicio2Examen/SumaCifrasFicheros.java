package ejercicio2Examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SumaCifrasFicheros {
	public static void main(String[] args) {
		File archivo=new File("numero.txt");

		try {
			Scanner sc=new Scanner(new FileInputStream(archivo));

			if (sc.hasNextInt()) {
				int numero=sc.nextInt();
				int numero2=sc.nextInt();
				int suma=numero+numero2;
				
				String sumaFinal=String.valueOf(suma);

				System.out.println("La suma es: " + sumaFinal);

				PrintWriter p = new PrintWriter("salida.txt");
				p.write("La suma de los números es: " + sumaFinal);
				p.close();

				// Cuando no hay errores, se lanza esto
			} else {
				PrintWriter error = new PrintWriter("error.txt");
				error.write("Error: No se han introducido números en el archivo.");
				error.close();
				System.out.println("Error: No se han introducido números en el archivo.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
