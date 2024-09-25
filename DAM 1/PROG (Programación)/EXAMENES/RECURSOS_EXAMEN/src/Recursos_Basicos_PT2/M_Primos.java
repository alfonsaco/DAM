package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_Primos {

	public static void main(String[] args) {
		/*Dado un número por teclado comprueba si es o no primo. 
		Recuerda que un número primo es aquel que solo es divisible 
		entre él mismo y la unidad.*/
		Scanner sc=new Scanner (System.in);
		System.out.println("Introduzca un número: ");
		int n=sc.nextInt();
		if (esprimo(n))
			System.out.println(n+" es primo");
		else
			System.out.println(n+" no es primo");
		sc.close();
	}

	public static boolean esprimo(int n){
		for (int i=2;i<=n/2;i++){
		if (n%i==0)
			return false;
		}
		return true;	
	}

}
