package enunciadosEjerciciosClase;

import java.util.Scanner;

public class EjercicioA {

	public static void main(String[] args) {
		/*Crea un programa que lea números enteros desde teclado hasta que introduce un 2. Si el
		primer número introducido es par muestra el número de pares que se han introducido por
		teclado. Si el primer número es impar muestra la suma de los impares menores de 10.*/
		Scanner sc=new Scanner(System.in);
        int primerNumero=0;
        int contadorPares=0;
        int sumaImparesMenoresDe10=0;
        System.out.println("Introduzca un número: ");
        int n=sc.nextInt();
        primerNumero=n;
        while (n!=2) {
            if (n%2==0) 
                contadorPares++;
            else if (n<10) 
                sumaImparesMenoresDe10+=n;
            System.out.println("Introduce un número (2 para salir): ");
            n=sc.nextInt();
        }
        if (primerNumero%2==0) 
            System.out.println("Se introdujeron "+contadorPares+" números pares.");
        else 
            System.out.println("La suma de los impares menores de 10 es: "+sumaImparesMenoresDe10);
        sc.close();
	}

}
