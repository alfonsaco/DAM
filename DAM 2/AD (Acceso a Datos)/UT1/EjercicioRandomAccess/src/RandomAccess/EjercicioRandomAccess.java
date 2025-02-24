package RandomAccess;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EjercicioRandomAccess {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		File fichero=null;
		String nombreArchivo="ficheroEmpresa.dat";
		
		// Mostrar el menú
		do {
			menu();
			opcion=sc.nextInt();
			
			switch(opcion) {
			case 1:
				fichero=crearFichero(nombreArchivo);
				break;
			case 2:
				System.out.print("¿Que registro quieres consultar? ");
				int id=sc.nextInt();
				if(consultarRegistro(nombreArchivo, id)) {
					System.out.println("DEPARTAMENTO EXISTE");
				} else {
					System.out.println("DEPARTAMENTO NO EXISTE");
				}
				break;
			case 3:
				System.out.print("¿Que id tiene el registro que quieres insertar? ");
				int codigo=sc.nextInt();
				if(consultarRegistro(nombreArchivo, codigo)) {
					System.out.println("DEPARTAMENTO EXISTE");
				} else {
					System.out.println("DEPARTAMENTO NO EXISTE\n");
					System.out.print("NOMBRE: ");
					String nombre=sc.next();
					System.out.print("LOCALIDAD: ");
					String localidad=sc.next();
					System.out.print("NÚMERO EMPLEADOS: ");
					int numEmple=sc.nextInt();
					System.out.print("SALARIO: ");
					float salario=sc.nextFloat();
					insertarRegistro(nombreArchivo, codigo, nombre, localidad, numEmple, salario);
				}
				break;
			case 4:
				System.out.print("¿Que registro quieres visualizar? ");
				int codigo1=sc.nextInt();
				visualizarRegistro(nombreArchivo, codigo1);
				break;
			case 5:
				System.out.print("¿Que registro quieres modificar? ");
				int idModificar=sc.nextInt();
				if(consultarRegistro(nombreArchivo, idModificar)) {
					modificarRegistro(idModificar, nombreArchivo);
					System.out.println("REGISTRO MODIFICADO");
				} else {
					System.out.println("REGISTRO NO SE PUEDE MODIFICAR");
				}
				break;
			case 6:
				System.out.print("¿Que registro quieres borrar? ");
				int idBorrar=sc.nextInt();
				if(consultarRegistro(nombreArchivo, idBorrar)) {
					borrarRegistro(idBorrar, nombreArchivo);
					System.out.println("REGISTRO BORRADO");
				} else {
					System.out.println("REGISTRO NO EXISTE");
				}
				break;
			case 7:
				leerRegistros(nombreArchivo);
				break;
			case 8:
				System.out.println("Programa finalizado");
				break;
			}
		} while(opcion!=8);
	}

	// Método para borrar un registro
	private static void borrarRegistro(int idBorrar, String nombreArchivo) throws IOException {
		File file=new File(nombreArchivo);
		RandomAccessFile archivo=new RandomAccessFile(file, "rw");
		
		int id;
		char[] nombre=new char[15];
		char aux;
		char[] localidad=new char[15];
		float salario;
		int numEmple;
		
		StringBuffer buffer=null;
		int posicion=0;
		int tamaño=4+30+30+4+4;
		
		while(archivo.length() != archivo.getFilePointer()) {
			archivo.seek(posicion);
			
			id=archivo.readInt();
			
			for (int i = 0; i < nombre.length; i++) {
				aux=archivo.readChar();
				nombre[i]=aux;
			}
			
			for (int i = 0; i < localidad.length; i++) {
				aux=archivo.readChar();
				localidad[i]=aux;
			}
			
			numEmple=archivo.readInt();
			
			salario=archivo.readFloat();
			
			if(id == idBorrar) {
				archivo.seek(posicion);
				
				archivo.writeInt(0);
				
				buffer=new StringBuffer("");
				buffer.setLength(15);
				archivo.writeChars(buffer.toString());
				
				archivo.writeChars(buffer.toString());
				
				archivo.writeInt(0);
				archivo.writeFloat(0);
				break;
			}
			
			posicion+=tamaño;
		}
	}

	// Método para modificar un registro específico
	private static void modificarRegistro(int idModificar, String nombreArchivo) throws IOException {
		Scanner sc=new Scanner(System.in);
		File file=new File(nombreArchivo);
		RandomAccessFile archivo=new RandomAccessFile(file, "rw");
		
		System.out.print("NUEVA LOCALIDAD: ");
		String nuevaLocalidad=sc.next();
		System.out.print("NUEVO SALARIO: ");
		float nuevoSalario=sc.nextFloat();
		
		int id;
		char[] nombre=new char[15];
		char aux;
		char[] localidad=new char[15];
		float salario;
		int numEmple;
		
		StringBuffer buffer=null;
		int posicion=0;
		int tamaño=4+30+30+4+4;
		
		while(archivo.length() != archivo.getFilePointer()) {
			archivo.seek(posicion);
			
			id=archivo.readInt();
			
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
			
			numEmple=archivo.readInt();
			
			salario=archivo.readFloat();
			
			if(idModificar == id) {
				archivo.seek(posicion);
				archivo.writeInt(id);
				
				buffer=new StringBuffer(nombreS);
				buffer.setLength(15);
				archivo.writeChars(buffer.toString());
				// Insertar nueva localidad
				buffer=new StringBuffer(nuevaLocalidad);
				buffer.setLength(15);
				archivo.writeChars(buffer.toString());
				
				archivo.writeInt(numEmple);
				// Insertar nuevo salario
				archivo.writeFloat(nuevoSalario);
			}
			
			posicion+=tamaño;
		}
	}

	private static void insertarRegistro(String nombreArchivo, int codigo, String nombre2, String localidad2, int numEmple2, float salario2) throws IOException {
		File file=new File(nombreArchivo);
		RandomAccessFile archivo=new RandomAccessFile(file, "rw");
		
		long tamaño=archivo.length();
		StringBuffer buffer=null;
		
		archivo.seek(tamaño);
		// imrpimir id
		archivo.writeInt(codigo);
		// escribir nombre
		buffer=new StringBuffer(nombre2);
		buffer.setLength(15);
		archivo.writeChars(buffer.toString());
		// escribir localidad
		buffer=new StringBuffer(localidad2);
		buffer.setLength(15);
		archivo.writeChars(buffer.toString());
		// escribir número empleados
		archivo.writeInt(numEmple2);
		// escribir salario
		archivo.writeFloat(salario2);
		
		System.out.println("\nREGISTRO INSERTADO CORRECTAMENTE\n");
	}

	// Verificar si existe o no existe un registro especifico
	private static boolean consultarRegistro(String nombreArchivo, int idUsuario) throws IOException {
		File file=new File(nombreArchivo);
		RandomAccessFile archivo=new RandomAccessFile(file, "r");
		
		int id;
		char[] nombre=new char[15];
		char aux;
		char[] localidad=new char[15];
		int numEmple;
		float salario;
		
		int tamaño=30+30+4+4+4;
		int posicion=0;
		
		while(archivo.getFilePointer() != archivo.length()) {
			archivo.seek(posicion);
			// Leer id
			id=archivo.readInt();
			// Leer nombre
			for (int i = 0; i < nombre.length; i++) {
				aux=archivo.readChar();
				nombre[i]=aux;
			}
			String nombreCompleto=new String(nombre);
			// Leer localidad
			for (int i = 0; i < localidad.length; i++) {
				aux=archivo.readChar();
				localidad[i]=aux;
			}
			String localidadCompleta=new String(localidad);
			// Leer número empleados
			numEmple=archivo.readInt();
			// Leer salario
			salario=archivo.readFloat();
			
			if(id == idUsuario) {
				return true;
			}
			
			posicion+=tamaño;
		}
		return false;
	}

	// Consultar registros en el fichero
	private static void visualizarRegistro(String nombreArchivo, int idUsuario) throws IOException {
		File file=new File(nombreArchivo);
		RandomAccessFile archivo=new RandomAccessFile(file, "r");
		
		int id;
		char[] nombre=new char[15];
		char aux;
		char[] localidad=new char[15];
		int numEmple;
		float salario;
		
		int tamaño=30+30+4+4+4;
		int posicion=0;
		
		while(archivo.getFilePointer() != archivo.length()) {
			archivo.seek(posicion);
			// Leer id
			id=archivo.readInt();
			// Leer nombre
			for (int i = 0; i < nombre.length; i++) {
				aux=archivo.readChar();
				nombre[i]=aux;
			}
			String nombreCompleto=new String(nombre);
			// Leer localidad
			for (int i = 0; i < localidad.length; i++) {
				aux=archivo.readChar();
				localidad[i]=aux;
			}
			String localidadCompleta=new String(localidad);
			// Leer número empleados
			numEmple=archivo.readInt();
			// Leer salario
			salario=archivo.readFloat();
			
			if(id == idUsuario) {
				System.out.printf("\nID: %d   NOMBRE: %s   LOCALIDAD: %s   NÚMERO EMPLEADOS: %d   MEDIA SALARIO: %.2f€ \n\n", id, nombreCompleto, localidadCompleta, numEmple, salario);
			}
			
			posicion+=tamaño;
		}
	}

	// Leer todos los registros del fichero
	private static void leerRegistros(String nombreArchivo) throws IOException {
		File file=new File(nombreArchivo);
		RandomAccessFile archivo=new RandomAccessFile(file, "r");
		
		char[] nombre=new char[15];
		char aux;
		char[] localidad=new char[15];
		int numEmple, id;
		float salario;
		int posicion=0;
		int tamaño=30+30+4+4+4;
		
		while(archivo.getFilePointer() != archivo.length()) {
			archivo.seek(posicion);
			// Leer id
			id=archivo.readInt();
			// Leer localidad
			for (int i = 0; i < nombre.length; i++) {
				aux=archivo.readChar();
				nombre[i]=aux;
			}
			String nombreCompleto=new String(nombre);
			// Leer ciudad
			for (int i = 0; i < localidad.length; i++) {
				aux=archivo.readChar();
				localidad[i]=aux;
			}
			String localidadCompleta=new String(localidad);
			// Leer numEmple
			numEmple=archivo.readInt();
			// Leer salario
			salario=archivo.readFloat();
			
			System.out.printf("ID: %d   NOMBRE: %s   LOCALIDAD: %s   NÚMERO EMPLEADOS: %d   MEDIA SALARIO: %.2f€ \n", id, nombreCompleto, localidadCompleta, numEmple, salario);
			
			posicion+=tamaño;
		}
	}

	// Crear el fichero
	private static File crearFichero(String nombreArchivo) throws IOException {
		File file=new File(nombreArchivo);
		
		if(!file.exists()) {
			RandomAccessFile fichero=new RandomAccessFile(file, "rw");
			
			String[] nombres={"VENTAS","RRHH","PRODUCCIÓN","FABRICACIÓN","SOCIAL","ADMINISTRACIÓN"};
			String[] localidades={"CIUDAD REAL","VALENCIA","PALENCIA","WARCELONA","CÓRBODA","SEVILLA"};
			int[] numEmple={1000,200,30,560,567,324};
			float[] salario={300,560,900,1009,1990,1002};
			StringBuffer buffer=null;

			for (int i = 0; i < salario.length; i++) {
				// Imprimir id
				fichero.writeInt(i+1);
				// Imprimir nombres
				buffer=new StringBuffer(nombres[i]);
				buffer.setLength(15);
				fichero.writeChars(buffer.toString());
				// Imprimir localidades
				buffer=new StringBuffer(localidades[i]);
				buffer.setLength(15);
				fichero.writeChars(buffer.toString());
				// Imprimir número de empleados
				fichero.writeInt(numEmple[i]);
				// Imprimir salario
				fichero.writeFloat(salario[i]);
			}
			
			System.out.println("Fichero creado correctamente");
			return file;
		} else {
			System.out.println("El archivo ya existe");
		}
		return null;
	}

	// Menú a imprimir con todas las opciones
	private static void menu() {
		System.out.println("-------- ELIGE UNA OPCIÓN --------");
		System.out.println("1. Crear fichero");
		System.out.println("2. Consultar registro");
		System.out.println("3. Insertar registro");
		System.out.println("4. Visualizar registro");
		System.out.println("5. Modificar registro");
		System.out.println("6. Borrar registro");
		System.out.println("7. Leer todos los registros");
		System.out.println("8. Salir");
		System.out.println("----------------------------------");
	}
}