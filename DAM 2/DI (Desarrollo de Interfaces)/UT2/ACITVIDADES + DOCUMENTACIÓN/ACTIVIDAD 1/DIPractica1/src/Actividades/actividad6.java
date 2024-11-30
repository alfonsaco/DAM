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
public class actividad6 {
    // Realiza un programa que pida al usuario una palabra y cuente cuántas vocales tiene.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Pedimos una palabra al usuario
        System.out.print("Introduce una palabra: ");
        String palabra=sc.next();
        // Array de vocales
        char[] vocales={'a','e','i','o','u','A','E','I','O','U'};
        int contVocal=0;
        // For para calcular cuántas vocales hay, usando el contador. Recorremos cada letra de la palabra
        for (int i=0; i<palabra.length(); i++) {
            char letra=palabra.charAt(i);
            // Recorremos cada letra del Array y la comparamos con la letra de la palabra
            for (int j=0; j<vocales.length; j++) {
                if(vocales[j] == letra) {
                    contVocal++;
                }
            }
        }
        // Resultado
        System.out.println("La palabra "+palabra+" tiene "+contVocal+" vocales");
        // Cerramos el scanner
        sc.close();
    }
}
