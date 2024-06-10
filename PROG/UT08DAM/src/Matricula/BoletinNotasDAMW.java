package Matricula;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoletinNotasDAMW {
	private ArrayList<Alumno>dam;
	
	public BoletinNotasDAMW() {
		dam=new ArrayList<>();
	}
	
	// Método cargar alumnos
	public void cargaInicial() throws IOException {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File("Alumnos.csv"));
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		this.getDam().add(new Alumno(Integer.parseInt(linea[0]),linea[1],linea[2],linea[3]));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}

	public ArrayList<Alumno> getDam() {
		return dam;
	}

	public void setDam(ArrayList<Alumno> dam) {
		this.dam = dam;
	}

	public void generarBoletines(){
		File directorio = new File("boletines");
		if (!directorio.exists()) {
			directorio.mkdirs();
		}
		
		for(Alumno a: this.getDam()) {
			PrintWriter salida;
			double suma=0;
			try {
				salida = new PrintWriter(new File(directorio,"Boletin"+a.getNombre()+a.getApellidos()+".txt"));
				salida.println("----------- IES RIBERA DEL TAJO -----------");
				salida.println(a.getNombre()+" "+a.getApellidos()+"\n");
				for(Nota n: a.getNotas()) {
					if(a.getCodigo() == n.getCodigo_alumno()) {
						salida.println("\t"+n);
						suma+=n.getNota();
					}
				}
				salida.println("La nota media es: "+(suma/a.getNotas().size()));
				salida.flush();
				salida.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		BoletinNotasDAMW app=new BoletinNotasDAMW();
		app.cargaInicial();
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				for (Alumno a : app.getDam()) {
					a.cargarNotas();
				}
				break;
			case 2:
				app.generarBoletines();
				break;
			case 3:
				break;
			}
		} while (opcion!=3);
	}

	private static void menu() {
		System.out.println("1. Leer notas");
		System.out.println("2. Imprimir boletines");
		System.out.println("3. Salir");
	}

}
