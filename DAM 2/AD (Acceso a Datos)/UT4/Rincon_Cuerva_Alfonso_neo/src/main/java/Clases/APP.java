package Clases;

import java.util.Scanner;
public class APP {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcion;
        do {
        	menu();            
            System.out.print("Selecciona una opción: ");
            opcion=sc.nextInt();

            switch (opcion) {
            	// Transferir datos de SQL a NeoDatis	 	
                case 1:
                    CrearBD.transferirDatos();
                    break;
                case 2:
                    System.out.print("Introduce el código del proyecto: ");
                    int codigoProyecto = sc.nextInt();
                    ListarProyecto.listarProyecto(codigoProyecto);
                    break;
                case 3:
                    System.out.print("Introduce el código del estudiante: ");
                    int codEstudiante = sc.nextInt();
                    System.out.print("Introduce el código del proyecto: ");
                    int codProyecto = sc.nextInt();
                    System.out.print("Introduce el tipo de participación: ");
                    String tipoParticipacion = sc.next();
                    System.out.print("Introduce el número de aportaciones: ");
                    int numAportaciones = sc.nextInt();
                    InsertarParticipantes.insertarParticipacion(codEstudiante, codProyecto, tipoParticipacion, numAportaciones);
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción no válida.\n");
            }
        } while (opcion != 0);

        sc.close();
    }

    // Método con el menú a imprimir
	private static void menu() {
		System.out.println("-----------------------------------");
		System.out.println("OPERACIONES PROYECTOS");
        System.out.println("1. Crear BD");
        System.out.println("2. Listar un proyecto");
        System.out.println("3. Insertar participación");
        System.out.println("0. Salir");
        System.out.println("-----------------------------------");
	}
}