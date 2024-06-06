package actividadNotasAlumnos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ClaseDAM {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Alumnos al=new Alumnos();
		Nota nota=new Nota();
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				al.insertarAlumno();
				break;
			case 2:
				String[] asignaturas= {"SISI","PROG","LMGSI","ING","FOL","ENDE","BDD"};
				for (int i = 0; i < al.getNotas().length; i++) {
					System.out.print("Nota para "+asignaturas[i]+": ");
					int not=sc.nextInt();
					// Dentro del atributo notas del alumno, entramos a los atributos de cada nota
					// Asignamos el valor del módulo del Array en el módulo del alumno
					al.getNotas()[i].setModulo(asignaturas[i]);
					// Asignamos el valor de la nota en la nota
					al.getNotas()[i].setNota(not);
				}
				for (int i = 0; i < al.getNotas().length; i++) {
					System.out.println(al.getNotas()[i]);
				}
				break;
			case 3:
				int susp=0;
				for (int i = 0; i < al.getNotas().length; i++) {
					if(al.getNotas()[i].getNota() < 5) {
						susp++;
					}
				}
				System.out.println("El alumno tiene un total de "+susp+" suspensos");
				break;
			case 4:
				double suma=0;
				// Función para redondear a 2 números
				DecimalFormat df = new DecimalFormat("#.00");
				for (int i = 0; i < al.getNotas().length; i++) {
					suma+=al.getNotas()[i].getNota();
				}
				double media=(suma/(al.getNotas().length));
				System.out.println("Media de las notas: "+df.format(media));
				break;
			}
		} while (opcion!=5);
	}

	// Método menú
	private static void menu() {
		System.out.println("1. Dar de alta");
		System.out.println("2. Asignar nota");
		System.out.println("3. Mostrar número de suspensos del alumno");
		System.out.println("4. Calcular la nota media");
		System.out.println("5. Salir");
	}
}
