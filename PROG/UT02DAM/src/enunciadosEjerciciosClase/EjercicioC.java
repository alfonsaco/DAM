package enunciadosEjerciciosClase;

import java.util.Scanner;

public class EjercicioC {

	public static void main(String[] args) {
		/*Crea un programa que lea números enteros desde teclado hasta que introduce un 3. Si el
		primer número introducido es impar muestra el número de pares que se han introducido por
		teclado. Si el primer número es par muestra la suma de los impares mayores que 3.*/
		Scanner sc=new Scanner(System.in);
		int contadorPares=0;
		int sumaImparesMayoresDe3=0;
		System.out.println("Introduzca un número: ");
		int n=sc.nextInt();
		int primerNumero=n;
		while (n!=3) {
			if (n%2==0)
				contadorPares++;
			else if (n>3)
				sumaImparesMayoresDe3+=n;
			System.out.println("Introduzca un número (3 para salir): ");
			n=sc.nextInt();
		}
		if (primerNumero%2!=0)
			System.out.println("Se han introducido "+contadorPares+" pares");
		else
			System.out.println("La suma de los impares mayores que 3 es "+sumaImparesMayoresDe3);
		sc.close();
	}

}
