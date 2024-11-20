package programaBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BinarioTxt {
	public static void main(String[] args) {
		File f = new File("numero.txt");

		try {
			Scanner entrada = new Scanner(new FileInputStream(f));

			if (entrada.hasNextInt()) {
				int numero = entrada.nextInt();

				String binario = Integer.toBinaryString(numero);

				System.out.println("El numero es: " + binario);

				PrintWriter p = new PrintWriter("salida.txt");
				p.write("El numero en binario es: " + binario);
				p.close();

			} else {
				// Si no hay un número en el archivo
				PrintWriter error = new PrintWriter("error.txt");
				error.write("Error: No se ha introducido ningún número en el archivo.");
				error.close();
				System.out.println("Error: No se han introducido números.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
