package ejercicioproductos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				ejercicio1();
				break;
			case 2:
				
				ejercicio2();
				break;
			case 3:
				ejercicio3();

				break;
			case 4:
				ejercicio4();
				break;

			
			case 0:
				System.out.println("FIN DE MENÚ!");
				break;
			default:
				System.out.println("Seleccione una opción válida!");
				break;
			}
		} while (opcion != 0);

		sc.close();
	}

	private static void ejercicio1() {
	
		System.out.println("LISTADO DE PRODUCTOS");
		System.out.println("------------------------------");
		//Productos.dat, lon = 46
		int codigoPro;      //campo identificativo – código del producto – debe ser de 1 a 99
		String nombrePro;   //nombre de producto, 15 caracteres, se graba sin writeUTF
		int existencias;    //existencias del producto
	    double pvp;	   //precio del producto


	
		
	}

	private static void ejercicio2() {
		// TODO Auto-generated method stub
		
	}
	
	
	private static void ejercicio3() {
		// TODO Auto-generated method stub
		
	}
	
	
	private static void ejercicio4() {
		// TODO Auto-generated method stub
		
	}
	
	private static void mostrarMenu() {
		System.out.println("------------------------------------------------------");
		System.out.println("OPERACIONES CON DEPARTAMENTOS");
		System.out.println("  1. Ejercicio 1. Listar productos.");
		System.out.println("  2. Ejercicio 2. Listar ventas.");
		System.out.println("  3. Ejercicio 3. Actualizar.");
		System.out.println("  4. Ejercicio 4. Crear XML.");		
		System.out.println("  0. Salir");
		System.out.println("------------------------------------------------------");
	}
	
}
