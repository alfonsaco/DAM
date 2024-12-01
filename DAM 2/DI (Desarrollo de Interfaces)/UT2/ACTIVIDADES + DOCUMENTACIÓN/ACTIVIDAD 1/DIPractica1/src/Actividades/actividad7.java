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
public class actividad7 {
    // Crea un programa que pida 5 calificaciones, las guarde en un array y luego calcule y
    // muestre el promedio de las mismas.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Array para guardar las notas
        double[] notas=new double[5];
        double suma=0;
        // For para introducir cada una de las notas
        for (int i = 0; i <notas.length; i++) {
            double nota=0;
            // Do while para verificar que la nota sea mayor de 0 y menor de 10
            do {
                System.out.print("Dime una nota: ");
                nota=sc.nextDouble();
                // Mensaje de error en caso de que sea incorrecta
                if(nota<0 || nota>10) {
                    System.out.print("NOTA NO VÁLIDA\n");                    
                }
            } while(nota < 0 || nota > 10);
            // Insertamos la nota en el array
            notas[i]=nota;
            suma+=nota;
        }
        // Calculamos la media
        double media=(suma / notas.length);
        System.out.println("La media de las notas es "+media);
        // Cerramos el scanner
        sc.close();
    }
}