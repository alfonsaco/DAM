package enunciadosEjerciciosClase;

import java.util.Scanner;

public class EjercicioB {

	public static void main(String[] args) {
		/*Crea un programa que lea números enteros desde teclado hasta que introduce un 0. Si el
		primer número introducido es mayor o igual a 2 muestra el número de impares que se han
		introducido por teclado. Si el primer número es menor a 2 muestra la suma de los pares
		mayores que 5.*/
		Scanner sc=new Scanner(System.in);
		int contadorImpares=0;
		int sumaParesMayoresDe5=0;
		System.out.println("Introduzca un número: ");
		int n=sc.nextInt();
		int primerNumero=n;
		while (n!=0) {
			if (n%2!=0)
				contadorImpares++;
			else if (n>5)
				sumaParesMayoresDe5+=n;
			System.out.println("Introduzca un número (0 para salir)");
			n=sc.nextInt();		
		}
		if (primerNumero>=2)
			System.out.println("Se han introducido "+contadorImpares+" impares");
		else
			System.out.println("La suma de los pares mayores que 5 introducidos es "+sumaParesMayoresDe5);
		sc.close();
	}

}
