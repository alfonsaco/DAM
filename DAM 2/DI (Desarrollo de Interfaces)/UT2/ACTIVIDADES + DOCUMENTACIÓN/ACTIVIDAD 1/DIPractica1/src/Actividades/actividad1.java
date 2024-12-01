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
public class actividad1 {
    // Crea un programa que le pida al usuario dos números y luego imprima la suma de esos
    // dos números.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Pedimos 2 números al usuario
        System.out.println("Dame un número: ");
        int n1=sc.nextInt();
        System.out.println("Dame otro número: ");
        int n2=sc.nextInt();
        // Realizamos la suma y la imprimimos
        int suma=n1+n2;
        System.out.printf("La suma de %d y %d es %d", n1, n2, suma);
    }
}
