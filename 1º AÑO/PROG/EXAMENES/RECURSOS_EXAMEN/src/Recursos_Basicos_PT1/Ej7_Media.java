package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej7_Media {

	public static void main(String[] args) {
		// Pedir números hasta que se introduzca uno negativo, y calcular la media.
		Scanner sc=new Scanner(System.in);
		int n=0;
		double suma=0;
		double contador=0;
		System.out.println("Dame números positivos y te diré su media (Negativo para cerrar el programa)");
		
        do {
            System.out.println("Dame un número:");
            n = sc.nextInt();

            if (n >= 0) {
                suma += n; // Corregido de =+ a +=
                contador++;
            } else {
                System.out.println("Se cerró el programa.");
                if (contador > 0) {
                    double media = (double) suma / contador; // Se añadió el cálculo de la media
                    System.out.println("La media es " + media);
                } else {
                    System.out.println("No se introdujo ningún número positivo.");
                }
            }
        } while (n >= 0);

        sc.close(); // Cierra el Scanner al final para evitar posibles problemas de recursos.
    }
}
