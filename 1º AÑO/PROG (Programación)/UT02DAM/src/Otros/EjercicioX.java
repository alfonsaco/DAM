package Otros;

import java.util.Scanner;

public class EjercicioX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();
        if (esCapicua(numero)) {
            System.out.println(numero + " es un número capicúa.");
        } else {
            System.out.println(numero + " no es un número capicúa.");
        }
        sc.close();
    }
    public static boolean esCapicua(int numero) {
        int original = numero;
        int invertido = 0;
        
        while (numero > 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero /= 10;
        }
        
        return original == invertido;
    }
}
