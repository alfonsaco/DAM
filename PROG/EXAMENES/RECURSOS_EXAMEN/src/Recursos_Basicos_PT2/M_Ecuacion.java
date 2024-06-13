package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_Ecuacion {

	public static void main(String[] args) {
		/*Pedir los coeficientes de una ecuación de segundo grado y mostar las soluciones. Si
		no existen indicarlo también*/
		// Pedir los coeficientes de una ecuación de segundo grado y mostar las soluciones. Si no existen indicarlo también
    	System.out.println("Este programa calcula las soluciones de una ecuación de segundo grado (ax^2 + bx + c = 0)");
    	Scanner sc=new Scanner(System.in);
        double a,b,c;
        // Solicitar al usuario el coeficiente de segundo grado (a)
        do{
            System.out.print("Introduzca el valor del coeficiente de segundo grado: ");
            while(!sc.hasNextDouble()) {// Detectar si el valor introducido es un valor numérico
                System.err.println("Error! Introduzca un valor numérico");
                sc.next();
            }
            a=sc.nextDouble();
            if(a==0) {
                System.err.println("Error! Introduzca un valor distinto a 0	");// Corregir al usuario si introduce un 0, pues estaría resolviendo una ecuación de primer grado y no de segundo
            }
        }while(a==0); 
        // Solicitar al usuario el coeficiente de primer grado (b)
        System.out.println("Introduzca el valor del coeficiente de primer grado: ");
        while(!sc.hasNextDouble()) {
            System.err.println("Error! Introduzca un valor numérico");
            sc.next();
        }
        b=sc.nextDouble();
        // Solicitar al usuario el coeficiente independiente (c)
        System.out.print("Introduzca el valor del coeficiente independiente: ");
        while(!sc.hasNextDouble()) {
            System.err.println("Error! Introduzca un valor numérico");
            sc.next();
        }
        c=sc.nextDouble();
        calcularecuacion(a,b,c);
        sc.close();
	}

	private static void calcularecuacion(double a, double b, double c) {
		// Calcular el determinante
        double discriminante=(b*b)-(4*a*c);
        // Determinar y mostrar las soluciones
        if(discriminante>0) {
            double x1=(-b+Math.sqrt(discriminante))/(2*a);
            double x2=(-b-Math.sqrt(discriminante))/(2*a);
            System.out.println("Las soluciones son x1= "+x1+" y x2= "+x2);
        }else if (discriminante==0) {
            double x1=-b/(2*a);
            System.out.println("La solución es x= "+x1);
        }else{
            System.out.println("No existen soluciones reales");
        }
	}

}
