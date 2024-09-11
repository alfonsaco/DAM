package Recursividad;

import java.util.Scanner;

public class factorial {
	
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
	    System.out.print("Introduzca un número: ");
	    int n=sc.nextInt();
        System.out.println("El factorial de "+n+ " es "+calcularFactorial(n));
        sc.close();
    }

    public static int calcularFactorial(int n) {
        if (n==0) 
            return 1;
        else 
            return n*calcularFactorial(n - 1);
    }
}

