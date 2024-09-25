package EjerciciosClase;

import java.util.Scanner;

public class EjercicioB {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un número (0 para cerrar el programa): ");
		int n=sc.nextInt();
		int contador=0;
		int suma=0;
		int primerN=n;
		
		while(n!=0) {
			if(n%2!=0) 
				contador++;
			else if(n>5) 
				suma+=n;

			System.out.println("Dame otro número: ");
			n=sc.nextInt();
		}
		
		if(primerN>=2)
			System.out.println("El número de impares es "+contador);
		else
			System.out.println("La suma de los pares es "+suma);
		
	}

}
