package Recursos_Basicos_PT2;

import java.util.Scanner;

public class A_Menu_String {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int n1,n2;
		String opcion;
		do {
            System.out.print("Ingrese el primer número entero positivo: ");
            n1=sc.nextInt();
            System.out.print("Ingrese el segundo número entero positivo: ");
            n2=sc.nextInt();
        } while (!correctos(n1, n2));
		sc.nextLine();
		do {
			mostrarmenu();
			opcion=sc.nextLine();
			switch (opcion) {
			case "a":
				break;
			case "b":
				break;
			case "c":
				break;
			case "d":
				break;
			}
		} while (!opcion.equals("e"));
		sc.close();
	}
	
	private static boolean correctos(int n1, int n2) {
		if (n1!=n2 && n1>0 && n2>0)
			return true;
		else {
			System.err.println("Los números deben ser diferentes, enteros y positivos. Inténtalo de nuevo.");
			return false;
		}
	}
	
	private static void mostrarmenu() {
		System.out.println();
		System.out.println("a) ¿Son números amigos?");
		System.out.println("b) ¿Cuántos primos hay entre ambos?");
		System.out.println("c) Imprimir las cifras de a");
		System.out.println("d) Sumar las cifras de b");
		System.out.println("e) Salir");
	}

}
