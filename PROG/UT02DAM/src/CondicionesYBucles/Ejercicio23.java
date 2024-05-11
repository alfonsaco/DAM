package CondicionesYBucles;

import java.util.Scanner;

public class Ejercicio23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el tamaño del lado del cuadrado: ");
        int n = scanner.nextInt();

        // Este bucle exterior controla las filas del cuadrado
        for (int i = 0; i < n; i++) {
            // Este bucle interior controla las columnas del cuadrado
            for (int j = 0; j < n; j++) {
                // Si estamos en el borde del cuadrado (primera fila, última fila, primera columna o última columna),
                // imprimimos un asterisco '*'
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    // Si no estamos en el borde, imprimimos espacios en blanco para el interior del cuadrado
                    System.out.print("  ");
                }
            }
            System.out.println(); // Salto de línea al final de cada fila para pasar a la siguiente fila
        }

        scanner.close();
    }
}
