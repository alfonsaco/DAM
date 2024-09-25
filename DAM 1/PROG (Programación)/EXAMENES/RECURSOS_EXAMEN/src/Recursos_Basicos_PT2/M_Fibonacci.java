package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_Fibonacci {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Introduzca un número: ");
	    int n=sc.nextInt(); 
        System.out.println("Sucesión de Fibonacci para "+n+" términos:");
        for (int i=0;i<n;i++) 
            System.out.print(calcularFibonacci(i)+" ");
        sc.close();
    }

    public static int calcularFibonacci(int n) {
        if (n<=1)
            return n;
        else 
            return calcularFibonacci(n-1)+calcularFibonacci(n-2);
	}

}
