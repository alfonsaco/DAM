package enunciadosEjerciciosClase;

import java.util.Scanner;

public class EjercicioD {

	public static void main(String[] args) {
		/*Crea un programa que lea números enteros desde teclado hasta que introduce un -1. Si el
		primer número introducido es múltiplo de 3 muestra la suma de los números menores de 10.
		Si el primer número no es múltiplo de 3 muestra la suma de los impares mayores que 6.*/
		Scanner sc=new Scanner(System.in);
		int sumaMenoresDe10=0;
		int sumaImparesMayoresDe6=0;
		System.out.println("Introduzca un número: ");
		int n=sc.nextInt();
		int primerNumero=n;{}
		while (n!=-1){
			if (n<10)
				sumaMenoresDe10+=n;
			if(n%2!=0 && n>6)
				sumaImparesMayoresDe6+=n;
			System.out.println("Introduzca un número(-1 para salir): ");
			n=sc.nextInt();			
		}
		if (primerNumero%3==0)
			System.out.println("La suma de los números menores de 10 es "+sumaMenoresDe10);
		else
			System.out.println("La suma de los impares mayores que 6 es "+sumaImparesMayoresDe6);
		sc.close();
	}

}
