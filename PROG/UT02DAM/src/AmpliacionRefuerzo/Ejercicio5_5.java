package AmpliacionRefuerzo;

import java.util.Scanner;

public class Ejercicio5_5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingresa tu edad: ");
		int edad=sc.nextInt();
		int precio=7;
		
		if(edad>5 && edad<60) {
			System.out.println("El precio de la entrada es de "+precio+"€");
		} else if(edad<5) {
			System.out.println("El precio es de "+(precio*0.6)+"€");
		} else if(edad>60) {
			System.out.println("El precio es de "+(precio*0.55)+"€");
		}
		

	}

}
