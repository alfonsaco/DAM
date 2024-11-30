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
public class actividad4 {
    // Escribe un programa que solicite un número y muestre su tabla de multiplicar (del 1 al 10)
    // en la consola.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Pedimos un número
        System.out.print("Dame un número: ");
        int n=sc.nextInt();
        // Se imprime por pantalla el resultado de cada operación de la tabla de multiplicar
        // con ese número
        for (int i=1; i<=10; i++) {
            System.out.println(n+" x "+i+" = "+(i*n));
        }
        // Cerramos el scanner
        sc.close();
    }
}
