/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades;

import java.util.Scanner;
/**
 *
 * @author Alfonso
 */
public class actividad5 {
    // Crea un programa que pida al usuario un número entero positivo y calcule su factorial
    // usando un bucle while.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Pedimos un número
        System.out.print("Dame un número entero positivo: ");
        int n=sc.nextInt();
        // En caso de que sea menor de 0, se pide otro
        while(n < 0) {
            System.out.println("Número no válido");
            System.out.print("Dame un número entero positivo: ");
            n=sc.nextInt();
        }
        // Cálculo del factorial
        int factorial=1;
        int cont=1;
        while(cont <= n) {
            factorial*=cont;
            cont++;
        }
        // Imprimimos el resultado
        System.out.println("El factorial de "+n+" es "+factorial);
        // Cerramos el scanner
        sc.close();
    }
}
