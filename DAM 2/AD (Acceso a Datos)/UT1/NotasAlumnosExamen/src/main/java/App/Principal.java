package App;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import XMLalumnos.Nota;

import java.io.*;

public class Principal {
		public static void main(String[] args) throws IOException {
			Scanner sc=new Scanner(System.in);
			
			int opcion=0;
			
			do {
				menu();
				opcion=sc.nextInt();
				
				switch(opcion) {
				case 1:
					listarAlumnos();
					break;
				case 2:
					listarNotas();
					break;
				case 3:
					actualizarFicheroAlumnos();
					break;
				case 4:
					crearXMLalumnos();
					break;
				case 5:
					System.out.println("Se finalizó el programa");
					break;
				}
				
			} while (opcion!=5);
			
		}

	    private static void crearXMLalumnos() throws IOException {
			File file=new File("Alumnos.dat");
			RandomAccessFile archivo=new RandomAccessFile(file, "r");
			
			int numAlum;
			char[] nombre=new char[20];
			char aux;
			char[] localidad=new char[20];
			int numAsig;
			float media;
			
			int posicion=0;
			int tamaño=4+40+40+4+4;
			
			ArrayList<XMLalumnos.Alumno> alumnos=new ArrayList<XMLalumnos.Alumno>();
			
			while(archivo.length() != archivo.getFilePointer()) {
				archivo.seek(posicion);
				
				numAlum=archivo.readInt();
				
				for (int i = 0; i < nombre.length; i++) {
					aux=archivo.readChar();
					nombre[i]=aux;
				}
				String nombreS=new String(nombre);
				
				for (int i = 0; i < localidad.length; i++) {
					aux=archivo.readChar();
					localidad[i]=aux;
				}
				String localidadS=new String(localidad);
				
				numAsig=archivo.readInt();
				
				media=archivo.readFloat();
				
				ArrayList<XMLalumnos.Nota> notas=listaNotas(numAlum);
				
				XMLalumnos.Alumno alu=new XMLalumnos.Alumno(numAlum,nombreS,localidadS,numAsig,media,notas);
				alumnos.add(alu);
				
				posicion+=tamaño;
			}
			
			XMLalumnos.ListaAlumnos list=new XMLalumnos.ListaAlumnos();
			list.setAlumnos(alumnos);
			
			JAXBContext context;
			try {
				
				context = JAXBContext.newInstance(XMLalumnos.ListaAlumnos.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(list, System.out);
				m.marshal(list, new File(".\\Alumnos.xml"));
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}

		private static ArrayList<Nota> listaNotas(int codigo) throws IOException {
			File file=new File("Notas.dat");
			RandomAccessFile archivo=new RandomAccessFile(file, "r");
			
			ArrayList<Nota> notas=new ArrayList<Nota>();
			
			int regis;
			int numAlum;
			char[] asignatura=new char[20];
			char aux;
			float nota;
			int cont=1;
			
			int posicion=0;
			int tamaño=4+40+4;
			
			while(archivo.length() != archivo.getFilePointer()) {
				archivo.seek(posicion);
				
				regis=cont;
				cont++;
				
				numAlum=archivo.readInt();
				
				for (int i = 0; i < asignatura.length; i++) {
					aux=archivo.readChar();
					asignatura[i]=aux;
				}
				String asignaturaS=new String(asignatura);
				
				nota=archivo.readFloat();
				
				if(codigo == numAlum) {
					XMLalumnos.Nota no=new XMLalumnos.Nota(asignaturaS,nota);
					notas.add(no);
				}
				
				posicion+=tamaño;
			}
			
			return notas;
		}

		private static void actualizarFicheroAlumnos() throws IOException {
	        // Abrimos los ficheros Alumnos.dat y Notas.dat
	        File fileAlumnos = new File("Alumnos.dat");
	        RandomAccessFile alumnos = new RandomAccessFile(fileAlumnos, "rw");

	        File fileNotas = new File("Notas.dat");
	        RandomAccessFile notas = new RandomAccessFile(fileNotas, "r");

	        // Variables para manejar las notas de cada alumno
	        ArrayList<Integer> alumnosList = new ArrayList<>();
	        ArrayList<ArrayList<Float>> notasList = new ArrayList<>();

	        // Leer las notas del fichero Notas.dat y almacenarlas en listas
	        while (notas.getFilePointer() < notas.length()) {
	            int numAlumNota = notas.readInt();
	            char[] asignatura = new char[20];
	            for (int i = 0; i < asignatura.length; i++) {
	                asignatura[i] = notas.readChar();
	            }
	            float nota = notas.readFloat();

	            // Si el alumno ya está en la lista, le añadimos la nota
	            if (!alumnosList.contains(numAlumNota)) {
	                alumnosList.add(numAlumNota);
	                notasList.add(new ArrayList<>());
	            }
	            int index = alumnosList.indexOf(numAlumNota);
	            notasList.get(index).add(nota);
	        }
	        notas.close();

	        // Variables para el cálculo de la media general y el mejor alumno
	        float sumaMedias = 0;
	        int totalAlumnos = 0;
	        String mejorAlumno = "";
	        float mejorNotaMedia = 0;

	        // Recorremos el fichero Alumnos.dat para actualizar los datos
	        while (alumnos.getFilePointer() < alumnos.length()) {
	            long posicion = alumnos.getFilePointer(); // Guardamos la posición actual

	            int numAlum = alumnos.readInt();
	            char[] nombre = new char[20];
	            for (int i = 0; i < nombre.length; i++) {
	                nombre[i] = alumnos.readChar();
	            }
	            String nombreS = new String(nombre).trim();

	            char[] localidad = new char[20];
	            for (int i = 0; i < localidad.length; i++) {
	                localidad[i] = alumnos.readChar();
	            }
	            String localidadS = new String(localidad).trim();

	            // Verificamos si el alumno tiene notas registradas
	            int numAsig = 0;
	            float media = 0;
	            if (alumnosList.contains(numAlum)) {
	                int index = alumnosList.indexOf(numAlum);
	                ArrayList<Float> notasAlumno = notasList.get(index);
	                numAsig = notasAlumno.size();

	                // Calculamos la media de las notas del alumno
	                for (float nota : notasAlumno) {
	                    media += nota;
	                }
	                media /= numAsig;

	                // Actualizamos la suma de medias y total de alumnos para la media general
	                sumaMedias += media;
	                totalAlumnos++;

	                // Verificamos si es la mayor media
	                if (media > mejorNotaMedia) {
	                    mejorNotaMedia = media;
	                    mejorAlumno = nombreS;
	                }
	            }

	            // Volvemos a la posición para reescribir los datos de las asignaturas y media
	            alumnos.seek(posicion + 4 + 40 + 40); // Nos saltamos numAlum, nombre, localidad
	            alumnos.writeInt(numAsig); // Actualizamos el número de asignaturas
	            alumnos.writeFloat(media); // Actualizamos la media
	        }
	        alumnos.close();

	        // Imprimimos los resultados
	        System.out.println("El alumno con la mejor nota media es: " + mejorAlumno + " con una media de " + mejorNotaMedia);
	        System.out.println("La nota media de todos los alumnos es: " + (totalAlumnos > 0 ? sumaMedias / totalAlumnos : 0));
	    }

		// Método para leer el archivo Notas.dat
		private static void listarNotas() throws IOException {
			File file=new File("Notas.dat");
			RandomAccessFile archivo=new RandomAccessFile(file, "r");
			
			int regis;
			int numAlum;
			char[] asignatura=new char[20];
			char aux;
			float nota;
			int cont=1;
			
			int posicion=0;
			int tamaño=4+40+4;
			
			while(archivo.length() != archivo.getFilePointer()) {
				archivo.seek(posicion);
				
				regis=cont;
				cont++;
				
				numAlum=archivo.readInt();
				
				for (int i = 0; i < asignatura.length; i++) {
					aux=archivo.readChar();
					asignatura[i]=aux;
				}
				String asignaturaS=new String(asignatura);
				
				nota=archivo.readFloat();
				
				System.out.println("REGIS: "+regis+"    NUMALUM: "+numAlum+"    ASIGNATURA: "+asignaturaS+"    NOTA: "+nota);
				
				posicion+=tamaño;
			}
		}

		// Método para leer el fichero Alumnos.dat
		private static void listarAlumnos() throws IOException {
			File file=new File("Alumnos.dat");
			RandomAccessFile archivo=new RandomAccessFile(file, "r");
			
			int numAlum;
			char[] nombre=new char[20];
			char aux;
			char[] localidad=new char[20];
			int numAsig;
			float media;
			
			int posicion=0;
			int tamaño=4+40+40+4+4;
			
			while(archivo.length() != archivo.getFilePointer()) {
				archivo.seek(posicion);
				
				numAlum=archivo.readInt();
				
				for (int i = 0; i < nombre.length; i++) {
					aux=archivo.readChar();
					nombre[i]=aux;
				}
				String nombreS=new String(nombre);
				
				for (int i = 0; i < localidad.length; i++) {
					aux=archivo.readChar();
					localidad[i]=aux;
				}
				String localidadS=new String(localidad);
				
				numAsig=archivo.readInt();
				
				media=archivo.readFloat();
				
				if(numAlum != 0) {
					System.out.println("NUMALUM: "+numAlum+"    NOMBRE: "+nombreS+"    LOCALIDAD: "+localidadS+"    NUMASIG: "+numAsig+"    NOTA MEDIA: "+media);
				}
				
				posicion+=tamaño;
			}
			
		}

		// Menú para imprimir
		private static void menu() {
			System.out.println("-------------------------------------");
			System.out.println("1. Listar alumnos");
			System.out.println("2. Listar notas");
			System.out.println("3. Actualizar el fichero alumnos");
			System.out.println("4. Generar el fichero alumnos.xml");
			System.out.println("5. Salir");
			System.out.println("-------------------------------------");
		}

}
