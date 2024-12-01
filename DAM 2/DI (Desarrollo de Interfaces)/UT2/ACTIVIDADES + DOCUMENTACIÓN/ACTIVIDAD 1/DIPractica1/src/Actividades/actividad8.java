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
public class actividad8 {
    // Escribe un programa que genere un número aleatorio entre 1 y 100, y permita al usuario
    // adivinar el número. El programa debe dar pistas si el número es mayor o menor que la
    // adivinanza del usuario, hasta que acierte.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Número a adivinar
        int random=(int)(1+Math.random()*100);
        // 
        System.out.println("INTENTA ADIVINAR EL NÚMERO");
        int intentos=0;
        int numeroAdivinar=-1;
        // Do while que pide números hasta que se adivine el número
        do {
            // Se suman los intentos
            intentos++;
            System.out.print("\tIntento "+intentos+": ");
            numeroAdivinar=sc.nextInt();
            // Condicionales para los diferentes casos
            if(numeroAdivinar < random) {
                System.out.println("El número es mayor de "+numeroAdivinar);
            } else if(numeroAdivinar == random) {
                System.out.println("¡¡ACERTASTE!!");
            } else {
                System.out.println("El número es menor de "+numeroAdivinar);
            }
        } while(numeroAdivinar != random);
    }
}
