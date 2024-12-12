package Material;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class EstructuraInicial {
	public static void main(String[] args) {
		LogManager.getLogManager().reset();
		Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		globalLogger.setLevel(java.util.logging.Level.OFF);
		//sesion=Conexion.getSession();
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		while(op!=4) {
			menu();
			op = sc.nextInt();
			switch(op) {
			case 1:
				System.out.println();
				//actualizarCamisetas();
				System.out.println();
				break;
			case 2:
				System.out.print("\nDigame el código del equipo: ");
				BigInteger cod2 = sc.nextBigInteger();
				//resumenEquipo(cod2);
				System.out.println();
				break;
			case 3:
				System.out.println();
				//consultarGenerales();
				System.out.println();
				break;
			case 4:
				System.out.println("\nHASTA PRONTO!!\n");
				break;
			default:
				System.out.println("\nEsrá opción no esta disponible!!\n");
				break;
			}
		}
	}
	

	private static void menu() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("OPERACIONES CON PROYECTOS. Realizado por Alfonso Rincón");
		System.out.println("1. EJERCICIO 1: Insertar evaluaciones");
		System.out.println("2. EJERCICIO 2: Actualizar contadores");
		System.out.println("3. EJERCICIO 3: Mostrar datos de todos los cursos");
		System.out.println("4. EJERCICIO 4: Mostrar estadísticas de centros");
		System.out.println("5. EJERCICIO 5: Realizar consultas");
		System.out.println("6. Salir");
		System.out.println("-------------------------------------------------------------");
	} 
}
