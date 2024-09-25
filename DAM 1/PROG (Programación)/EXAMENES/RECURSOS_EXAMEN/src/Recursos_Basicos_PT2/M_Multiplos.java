package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_Multiplos {

	public static void main(String[] args) {
		// Pedir dos números y decir si uno es múltiplo de otro
		Scanner sc=new Scanner(System.in);
		System.out.println("Intoduzca el primer número: ");
		int n1=sc.nextInt();
		System.out.println("Intoduzca el segundo número: ");
		int n2=sc.nextInt();
		Multiplos(n1,n2);
		sc.close();
	}

	private static void Multiplos(int n1, int n2) {
		if(n1%n2==0 || n2%n1==0) {
			System.out.println(n1+" es múltiplo de "+n2);
		}else {
			System.out.println("No son múltiplos");
		}
		
	}

}
