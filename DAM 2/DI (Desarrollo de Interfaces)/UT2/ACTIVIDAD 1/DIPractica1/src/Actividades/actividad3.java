/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades;

/**
 *
 * @author Alfonso
 */
public class actividad3 {
    // Realiza un programa que imprima los números del 1 al 10 utilizando un bucle for.
    public static void main(String [] args) {
        String cadena="";
        // Metemos cada número en una cadena
        for (int i=1; i<=10; i++) {
            cadena+=i+", ";
        }
        // Recortamos la coma final de la cadena
        cadena=cadena.substring(0, cadena.length()-2);
        System.out.println(cadena);
    }
}
