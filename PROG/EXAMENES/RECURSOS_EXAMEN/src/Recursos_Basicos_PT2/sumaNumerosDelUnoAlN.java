package Recursos_Basicos_PT2;

import java.util.Scanner;

public class sumaNumerosDelUnoAlN {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Ingresa un número entero positivo n: ");
	    int n=sc.nextInt();
	        if (n<1) 
	            System.out.println("El número debe ser un entero positivo.");
	        else {
	            int resultado=sumaRecursiva(n);
	            System.out.println("La suma de los números del 1 al "+n+" es: "+resultado);
	        }
	        sc.close();
	    }

	public static int sumaRecursiva(int n) {
        if (n==1) 
            return 1;
        else 
            return n+sumaRecursiva(n-1);
    }
}
