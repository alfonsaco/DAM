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
public class actividad2 {
    // Crea un programa que convierta una temperatura dada en grados Celsius a Fahrenheit.
    // La fórmula es: F = (C * 9/5) + 32.
    public static void main(String [] args) {
        Scanner sc=new Scanner(System.in);
        // Pedimos la temperatura al usuario
        System.out.print("Dame una temperatura en grados Celsius: ");
        double tempCelsius=sc.nextDouble();
        // Creamos una variable para la nueva temperatura Fahrenheit y la imprimimos
        double tempFahrenheit=(tempCelsius * 9/5) + 32;
        System.out.printf("Temperatura en grados Celsius: %.2f \nTemperatura en grados Fahrenheit: %.2f",tempCelsius, tempFahrenheit);
    }
}
