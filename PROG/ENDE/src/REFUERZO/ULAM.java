package REFUERZO;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ULAM {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Dame distinto a 1: ");
		int n=sc.nextInt();
		System.out.println(sucesionULAM(n));
	}
	
	private static String sucesionULAM(int n) {
		int contador=0;
		String cadena="";
		do {
			if(n%2==0) {
				n=n/2;
			}else if(n%2!=0) {
				n=n*3+1;
			}
			cadena+=n+", ";
		} while (n!=1);
		return cadena.substring(0, cadena.length()-2);
	}
}
