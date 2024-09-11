package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_CifrasSuma {

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
    
    
//    Sin recursividad sería:
//    	private static void sumacifras(int n2) {
//		int sumaCifrasN2=0;
//		int auxN2=n2;
//		while (auxN2>0) {
//			int cifraN2=auxN2%10;
//			sumaCifrasN2+=cifraN2;
//			auxN2/=10;
//		}
//		System.out.println("La suma de cifras de "+n2+" es de "+sumaCifrasN2);
}
