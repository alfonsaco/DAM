package Recursos_Basicos_PT2;

import java.util.Scanner;

public class A_Menu_Entero {

	public static void main(String[] args) {

			Scanner sc=new Scanner (System.in);
			int n1,n2;
			int opcion;
			do {
	            System.out.print("Ingrese el primer número entero positivo: ");
	            n1=sc.nextInt();
	            System.out.print("Ingrese el segundo número entero positivo: ");
	            n2=sc.nextInt();
	        } while (!correctos(n1, n2));
			sc.nextLine();
			do {
				mostrarmenu();
				opcion=sc.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Caso 1");
					break;
				case 2:
					System.out.println("Caso 2");
					break;
				case 3:
					System.out.println("Caso 3");
					break;
				case 4:
					System.out.println("Caso 4");
					break;
				}
			} while (opcion!=5);
			System.out.println("Caso 5");
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
			System.out.println("1) ");
			System.out.println("2) ");
			System.out.println("3) ");
			System.out.println("4) ");
			System.out.println("5) ");
		}

	}
