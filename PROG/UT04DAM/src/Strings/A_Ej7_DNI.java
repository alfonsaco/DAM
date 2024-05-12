package Strings;

import java.util.Scanner;

public class A_Ej7_DNI {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el NIF: ");
        String nif = sc.nextLine();

        // Validar el formato y la longitud del NIF
        if (nif.matches("[0-9]{8}[a-zA-Z]")) {
            String parteNumerica = nif.substring(0, 8);
            System.out.println("Parte numérica del NIF: " + parteNumerica);
        } else {
            System.out.println("NIF no válido.");
        }
    }
}
