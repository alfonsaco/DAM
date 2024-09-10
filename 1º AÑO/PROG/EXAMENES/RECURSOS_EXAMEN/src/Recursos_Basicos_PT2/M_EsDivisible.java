package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_EsDivisible {

	public static void main(String[] args) {
		/*Escriba un programa en Java que pida dos números enteros al usuario, 
		y determine si el primero es divisible entre el segundo*/
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el valor de a: ");
		int a=sc.nextInt();
		System.out.println("Introduzca el valor de b: ");
		int b=sc.nextInt();
		sonDivisibles(a,b);
		sc.close();
	}

	private static void sonDivisibles(int a, int b) {
		if (a%b==0)
            System.out.println(a+" es divisible por "+b);
        else 
            System.out.println(a+" no es divisible por "+b);
	}

}
