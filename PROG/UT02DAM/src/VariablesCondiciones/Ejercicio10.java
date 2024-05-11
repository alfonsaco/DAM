package VariablesCondiciones;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double numero1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = sc.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double numero3 = sc.nextDouble();

        if (numero1 < numero2) {
            double temp = numero1;
            numero1 = numero2;
            numero2 = temp;
        }

        if (numero1 < numero3) {
            double temp = numero1;
            numero1 = numero3;
            numero3 = temp;
        }

        if (numero2 < numero3) {
            double temp = numero2;
            numero2 = numero3;
            numero3 = temp;
        }

        System.out.println("Números ordenados de mayor a menor: " + numero1 + ", " + numero2 + ", " + numero3);

        sc.close(); // Cierra el Scanner
    }
}
