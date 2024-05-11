package EjerciciosClase;

import java.util.Scanner;

public class EjercicioC {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce números (Un 3 para cerrar el programa");
		int n=sc.nextInt();
		int nPrimer=n;
		int contadorPar=0;
		int suma=0;
		
		while(n!=3) {
			if(n%2==0)
				contadorPar++;
			else if(n%2!=0 && n>3)
				suma+=n;
			System.out.println("Introduce otro número: ");
			n=sc.nextInt();
//			
		}
		if(nPrimer%2!=0)
			System.out.println("El número de pares introducidos es "+contadorPar);
		else
			System.out.println("La suma de los impares es "+suma);
		sc.close();

	}

}
