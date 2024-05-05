/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIO_6;

import static EJERCICIO_6.CalculadoraGeometria.areaCirculo;
import static EJERCICIO_6.CalculadoraGeometria.areaCuadrado;
import static EJERCICIO_6.CalculadoraGeometria.volumenCuadrado;
/**
 * Clase para llamar a los métodos y realizar las operaciones de geometría
 * Este clase contiene el main
 */
public class UsoCalculadoraGeometria {
    public static void main(String[] args) {
        double r = 5;
        double l = 10;
        // Area del circulo
        System.out.println("Área del círculo: " + areaCirculo(r));
        // Area de cuadrado
        System.out.println("Área del cuadrado: " + areaCuadrado(l));
        // Volumen del cuadrado
        System.out.println("Volumen del cuadrado: " + volumenCuadrado(l));
    }
    
}
