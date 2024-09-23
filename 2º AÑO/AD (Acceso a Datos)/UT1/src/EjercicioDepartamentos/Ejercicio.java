package EjercicioDepartamentos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int n=0;
		System.out.println("Escoge una opción");
		File archivo=null;
		
		do {
			menu();
			n=sc.nextInt();
			switch (n) {
				case 1:
					archivo=crearFichero();
					int n2=0;
					break;
				case 2:
					try {
					    System.out.print("¿Qué registro quieres buscar?: ");
					    String entrada = sc.next();  // Lee la entrada como String

					    // Intenta convertir la cadena a un entero
					    int consulta = Integer.parseInt(entrada);

					    if (consultarRegistro(consulta)) {
					        System.out.println("DEPARTAMENTO SÍ EXISTE");
					    } else {
					        System.out.println("DEPARTAMENTO NO EXISTE");
					    }
					} catch (NumberFormatException e) {
					    // Esto atrapa números demasiado grandes o cualquier entrada no numérica
					    System.err.println("El número ingresado es demasiado grande o no es válido.");
					} catch (InputMismatchException e) {
					    // En caso de cualquier otra excepción de entrada, como el uso de caracteres no válidos
					    System.err.println("Entrada no válida.");
					}

				case 3:
					insertarRegistro();
					break;
				case 4:
					System.out.print("Dame un registro: ");
					int registro=sc.nextInt();
					if(consultarRegistro(registro)) {
						 visualizarRegistro(registro);
					} else {
						System.out.println("NO EXISTE");
					}
					break;
				case 5:
					System.out.print("Dame un registro: ");
					int registro1=sc.nextInt();
					if(consultarRegistro(registro1)) {
						modificarRegistro(registro1);
					} else {
						System.out.println("REGISTRO NO SE PUEDE MODIFICAR");
					}
					break;
				case 6:
					break;
				case 7:
					leerFichero();
					break;
				case 8:
					System.out.println("\nSe finalizó el programa");
					break;
				}
		} while (n != 8);
	}
	
	private static void modificarRegistro(int registro1) throws IOException {
	    File archivo = new File("datosEmpresa.dat");
	    RandomAccessFile file = new RandomAccessFile(archivo, "rw");

	    Scanner sc = new Scanner(System.in);

	    System.out.print("Dame la nueva localidad: ");
	    String nuevaLocalidad = sc.next();
	    System.out.print("Dame la nueva media de salario: ");
	    double nuevaMedia = sc.nextDouble();

	    int id, num;
	    char[] nombre = new char[20];
	    char aux;
	    char[] localidad = new char[10];
	    char aux2;
	    double media;

	    StringBuffer buffer = null;

	    while (file.getFilePointer() < file.length()) {
	        long punteroActual = file.getFilePointer();
	        id = file.readInt(); 
	        
	        for (int i = 0; i < nombre.length; i++) {
	            nombre[i] = file.readChar();
	        }

	        for (int i = 0; i < localidad.length; i++) {
	            localidad[i] = file.readChar();
	        }

	        num = file.readInt();
	        media = file.readDouble(); 

	        if (id == registro1) {
	        	// 4 del id, 40 del nombre
	            file.seek(punteroActual + 4 + 40);

	            buffer = new StringBuffer(nuevaLocalidad);
	            buffer.setLength(10); 
	            file.writeChars(buffer.toString());

	            // salto de 4 bytes
	            file.skipBytes(4);

	            file.writeDouble(nuevaMedia);

	            System.out.println("REGISTRO MODIFICADO");
	            break;
	        }
	    }

	    file.close();
	}

	private static void visualizarRegistro(int registro) throws IOException {
		File archivo=new File("datosEmpresa.dat");
		RandomAccessFile file=new RandomAccessFile(archivo, "r");
		
		int id, num;
		char[] nombre=new char[20];
		char aux;
		char[] localidad=new char[10];
		char aux2;
		double media;

		while(file.getFilePointer() != file.length()) {
			id=file.readInt();
			
			for (int i=0; i<nombre.length; i++) {
				aux=file.readChar();
				nombre[i]=aux;
			}
			String nombreS=new String(nombre);
			
			for (int e = 0; e < localidad.length; e++) {
				aux2=file.readChar();
				localidad[e]=aux2;
			}
			String localidadS=new String(localidad);
			
			num=file.readInt();
			
			media=file.readDouble();
			
			if(id == registro) {
				System.out.println("ID: "+id+"  NOMBRE:  "+nombreS+"  LOCALIDAD: "+localidadS+"  NÚMERO EMPLEADOS: "+num+"  MEDIA SALARIO: "+media);
			}
		}
		
		file.close();
	}

	private static void insertarRegistro() throws IOException {
		Scanner sc=new Scanner(System.in);
		int id=1000;
		// Con eto podemos poner el ID en la vraible
		do {
			System.out.print("Dame el ID: ");
			id=sc.nextInt();
			
			if(consultarRegistro(id)) {
				System.out.println("ID REPETIDO");
			}
		} while (consultarRegistro(id) || id>=100 || id<0);
		
		System.out.print("Dame el nombre: ");
		String nombre=sc.next();
		
		System.out.print("Dame la localidad: ");
		String localidad=sc.next();
		
		System.out.print("Dame el número de empleados: ");
		int num=sc.nextInt();
		
		System.out.print("Dame la media de salario: ");
		double media=sc.nextDouble();
		
		File archivo=new File("datosEmpresa.dat");
		RandomAccessFile file=new RandomAccessFile(archivo, "rw");
		
		
		StringBuffer buffer=null;
		long posicion=file.length();
		file.seek(posicion);
		
		file.writeInt(id);
		
		buffer=new StringBuffer(nombre);
		buffer.setLength(20);
		file.writeChars(buffer.toString());
		// Localidades
		buffer=new StringBuffer(localidad);
		buffer.setLength(10);
		file.writeChars(buffer.toString());
		// Número de empleados
		file.writeInt(num);
		// Media del salario
		file.writeDouble(media);
		
	}

	private static boolean consultarRegistro(int consulta) throws IOException {
		File archivo=new File("datosEmpresa.dat");
		
		if(!archivo.exists()) {
			System.out.println("El fichero no existe");
			return false;
		}
		
		RandomAccessFile file=new RandomAccessFile(archivo, "r");
		
		int codDep, posicion=0;
		int tamaño=40+20+4+4+8;
		
		while(file.getFilePointer() != file.length()) {
			file.seek(posicion);
			
			try {
				codDep=file.readInt();
			} catch (Exception e) {
				break;
			}
			
			if(consulta == codDep) {
				return true;
			}
			
			posicion+=tamaño;
			
		}
		
		
		return false;
	}

	private static void leerFichero() throws IOException {
		File archivo=new File("datosEmpresa.dat");
		RandomAccessFile file=new RandomAccessFile(archivo, "r");
		
		int id, numEmple;
		double media;
		char[] nombre=new char[20];
		char aux;
		char[] localidad=new char[10];
		char aux2;
		
		int posicion=0;
		
		while(file.getFilePointer() != file.length()) {
			file.seek(posicion);
			id=file.readInt();
			// Nombre
			for (int e=0; e<nombre.length; e++) {
				aux=file.readChar();
				nombre[e]=aux;
			}
			String nombreS=new String(nombre);
			// Localidad
			for (int j = 0; j < localidad.length; j++) {
				aux2=file.readChar();
				localidad[j]=aux2;
			}
			String localidadS=new String(localidad);
			// Número empleados
			numEmple=file.readInt();
			// Media
			media=file.readDouble();
			// Posición
			posicion=posicion+40+20+4+4+8;
			
			System.out.println("ID: "+id+"  NOMBRE: "+nombreS+"  LOCALIDAD: "+localidadS+"  NÚMERO EMPLEADOS: "+numEmple+"  MEDIA: "+media);
		}
		System.out.println();
		file.close();
	}

	// Método para crear un fichero
	private static File crearFichero() {
		File archivo=new File("datosEmpresa.dat");
	
		if(!archivo.exists()) {
			try {
				RandomAccessFile file=new RandomAccessFile(archivo, "rw");
				System.out.println("Fichero creado correctamente");
				
				String[] nombres= {"VENTAS","RECURSOS HUMANOS","PRODUCCIÓN","FABRICACIÓN","LEGAL"};
				String[] localidades= {"VALENCIA","TOLEDO","MADRID","ALICANTE","BARCELONA"};
				int[] numEmpe= {2000,340,5654,999,87};
				double[] mediaSal= {654.6,687.6, 999.6,1023.4,1230.5};
				StringBuffer buffer=null;
				
				for (int i=0; i<nombres.length; i++) {
					// Código departamento
					file.writeInt(i+1);
					// Nombres departamento
					buffer=new StringBuffer(nombres[i]);
					buffer.setLength(20);
					file.writeChars(buffer.toString());
					// Localidades
					buffer=new StringBuffer(localidades[i]);
					buffer.setLength(10);
					file.writeChars(buffer.toString());
					// Número de empleados
					file.writeInt(numEmpe[i]);
					// Media del salario
					file.writeDouble(mediaSal[i]);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero ya existe");
		}
		
		return archivo;
	}

	// Menú
	private static void menu() {
		System.out.println("-----------------------------");
		System.out.println(" 1. Crear fichero");
		System.out.println(" 2. Consultar registro");
		System.out.println(" 3. Insertar registro");
		System.out.println(" 4. Visualizar registro");
		System.out.println(" 5. Modificar registro");
		System.out.println(" 6. Borrar registro");
		System.out.println(" 7. Leer ficheros");
		System.out.println(" 8. Salir");
		System.out.println("-----------------------------");
	}
}
