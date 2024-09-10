package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int n=sc.nextInt();
		System.out.println("El factorial de "+n+" es "+factorial(n));
		sc.close();
	}

	private static int factorial(int n) {
		if(n==0) {
			return 1;
		}else {
			return n*factorial(n-1);
//	        ESTO ESTÁ HECHO CON RECURSIVIDAD. Si recursividad sería asi:
//	        
//	    	private static int factorial(int a) {
//	    		int suma=1;
//	    		for(int i=1; i<=a; i++) {
//	    			suma*=i;
//	    		}
//	    		return suma;
//	    	}
		}
	}

}
