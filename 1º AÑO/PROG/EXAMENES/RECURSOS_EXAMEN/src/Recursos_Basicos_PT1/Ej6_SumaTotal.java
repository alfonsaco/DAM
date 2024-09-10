package Recursos_Basicos_PT1;

import java.util.Scanner;

public class Ej6_SumaTotal {

	public static void main(String[] args) {
		// Pedir números hasta que se teclee un 0, mostrar la suma de todos los números introducidos.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int suma=0;
		System.out.println("Dame números y te mostraré su suma (0 para cerrar el programa)");
		
		do {
			System.out.println("Dame un número");
			n=sc.nextInt();
			
			if(n!=0) {
				suma+=n;
			}else {
				System.out.println("Se cerró el programa");
				System.out.println("La suma total es de "+suma);
			}
		}while(n!=0);
	}

}
