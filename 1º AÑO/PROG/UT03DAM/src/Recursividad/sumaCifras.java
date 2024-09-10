package Recursividad;

import java.util.Scanner;

public class sumaCifras {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n=sc.nextInt();
        System.out.println("La suma de las cifras de "+n+" es: "+sumarCifrasRecursivo(n));
        sc.close();
    }

    public static int sumarCifrasRecursivo(int n) {
        if (n<10) 
            return n; 
        else 
            return n%10+sumarCifrasRecursivo(n/10);
    }
}
