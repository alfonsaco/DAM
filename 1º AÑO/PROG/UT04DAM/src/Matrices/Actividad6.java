package Matrices;

import java.util.Random;

public class Actividad6 {
    public static void main(String[] args) {
        int[][] matriz = new int[10][10];

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = random.nextInt(100) + 1;
            }
        }
        System.out.println("Matriz generada:");
        mostrarMatriz(matriz);

        diagonal(matriz);
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Método para calcular la diagonal y mostrar resultados
    public static void diagonal(int[][] matriz) {
        int suma = 0;
        int min = matriz[0][0];
        int max = matriz[0][0];

        System.out.print("\nElementos en la diagonal: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(matriz[i][i] + " ");
            suma += matriz[i][i];
            if (matriz[i][i] < min) {
                min = matriz[i][i];
            }
            if (matriz[i][i] > max) {
                max = matriz[i][i];
            }
        }

        double media = (double) suma / 10;
        System.out.println("\nMínimo en la diagonal: " + min);
        System.out.println("Máximo en la diagonal: " + max);
        System.out.println("Media de la diagonal: " + media);
    }
}
