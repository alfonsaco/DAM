package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Buenos días");
		
		System.out.println("Por favor, introduzca el año en que nació");
		int fecha=sc.nextInt();
		
		int edad=2023-fecha;
		System.out.println("Si usted nació en el año "+fecha+", usted tiene "+edad+" años");
		

	}

}
