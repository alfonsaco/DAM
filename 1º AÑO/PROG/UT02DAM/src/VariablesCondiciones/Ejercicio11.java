package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        long numero = sc.nextLong();

        int cifras = 0;
        if (numero == 0) {
            cifras = 1; // Si el número es 0, tiene una cifra
        } else {
            while (numero != 0) {
                cifras++;
                numero = numero / 10;
            }
        }

        System.out.println("El número tiene " + cifras + " cifras.");

        sc.close(); // Cierra el Scanner
    }
}
