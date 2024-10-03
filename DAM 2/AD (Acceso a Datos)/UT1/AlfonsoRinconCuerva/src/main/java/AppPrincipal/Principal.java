package AppPrincipal;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Principal {
	static int LONGITUD_VIAJES=4+60+4+4+2;
	static int LONGITUD_MOV_INICAL=4+60+4+4+2;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// Opción del usuario
		int opcion = 10;

		do {
			menu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				System.out.println("Se finalizó el programa");
				break;
			case 1:
				actualizarViajes();
				break;
			case 2:
				listarViajes();
				break;
			case 3:
				crearXMLviajes();
				break;
			case 4:
				listarMovimientos();
				break;
			}

		} while (opcion != 0);
	}

	// Método para crear el XML
	private static void crearXMLviajes() throws IOException {
		File fichero = new File(".\\Viajes.dat");
		
		ArrayList<XMLviajes.Viaje> listaViajes=new ArrayList<XMLviajes.Viaje>();
		
		// Inicializar variables
		int codViaje;
		char[] nombre = new char[30];
		char aux;
		int pvp;
		int plazas;
		char[] situacion = new char[1];

		// Posicion a 0
		int posicion = 0;
		
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			
			for (;;) {
				file.seek(posicion);

				// Leer codigo
				codViaje = file.readInt();
				// Leer nombre
				for (int i = 0; i < nombre.length; i++) {
					aux = file.readChar(); 
					nombre[i] = aux;
				}
				String nombreS=new String(nombre);
				// Leer el PVP
				pvp = file.readInt();
				// Leer las plazas
				plazas=file.readInt();
				// Leer la situación
				for (int i = 0; i < situacion.length; i++) {
					aux = file.readChar();
					situacion[i] = aux;
				}
				String situacionS=new String(situacion);

				// Comparación para verificar que no sea 0
				if(codViaje != 0) {
					XMLviajes.Viaje v=new XMLviajes.Viaje(codViaje,nombreS.trim(),pvp,plazas,situacionS);
					listaViajes.add(v);
				}

				posicion+=LONGITUD_VIAJES;

				if (file.getFilePointer() == file.length()) {
					file.close();
					break;
				}
			}
			
			// Objeto que contendrá la lista de Viajes
			XMLviajes.ListaViajes listaFinal=new XMLviajes.ListaViajes();
			listaFinal.setViajes(listaViajes);
			
			// Generamos el XML
			JAXBContext context;
			try {
				
				context = JAXBContext.newInstance(XMLviajes.ListaViajes.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(listaFinal, System.out);
				m.marshal(listaFinal, new File(".\\viajes.xml"));
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
			e.printStackTrace();
		}
		
		
	}

	// Método para listar los movimientos
	private static void listarMovimientos() throws IOException {
		File fichero = new File(".\\Movimientos.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		// Inicializar variables
		int codViaje;
		char[] nombre = new char[30];
		char aux;
		int pvp;
		int plazas;
		char[] situacion = new char[1];

		// Posición inicial 0
		int posicion = 0;

		// Escribir el encabezado
		System.out.printf("%10s %-30s %8s %8s %10s%n", "CodViaje", "Nombre", "PVP", "PLAZAS", "SITUACIÓN");
		System.out.printf("%10s %-30s %8s %8s %10s%n", "----------", "------------------------------", "--------","--------", "----------");

		for (;;) {
			file.seek(posicion);

			// Leer codigo
			codViaje = file.readInt();
			// Leer nombre
			for (int i = 0; i < nombre.length; i++) {
				aux = file.readChar();
				nombre[i] = aux;
			}
			String nombreS=new String(nombre);
			// Leer el PVP
			pvp = file.readInt();
			// Leer las plazas
			plazas=file.readInt();
			// Leer la situación
			for (int i = 0; i < situacion.length; i++) {
				aux = file.readChar();
				situacion[i] = aux;
			}
			String situacionS=new String(situacion);

			if(codViaje != 0) {
				System.out.printf("%10s %-30s %8s %8s %10s%n", codViaje, nombreS, pvp, plazas, situacionS);
			}

			// Posicionarse en el siguiente alumno
			posicion+=LONGITUD_MOV_INICAL;

			// Salir del for cuando haya recorrido todos los bytes (Y cerrar el file)
			if (file.getFilePointer() == file.length()) {
				file.close();
				break;
			}
		}
		System.out.printf("%10s %-30s %8s %8s %10s%n", "----------", "------------------------------", "--------","--------", "----------");
	}

	// Método para listar los viajes
	private static void listarViajes() throws IOException {
		File fichero = new File(".\\Viajes.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		// Inicializar variables
		int codViaje;
		char[] nombre = new char[30];
		char aux;
		int pvp;
		int plazas;
		char[] situacion = new char[1];

		// Posición 0
		int posicion = 0;
		
		// Variables para calcular las medias
		int contMedia=0;
		double sumaPVP=0;
		double sumaPlazas=0;

		System.out.printf("%10s %-30s %8s %8s %10s%n", "CodViaje", "Nombre", "PVP", "PLAZAS", "SITUACIÓN");
		System.out.printf("%10s %-30s %8s %8s %10s%n", "----------", "------------------------------", "--------","--------", "----------");

		for (;;) {
			file.seek(posicion);

			// Leer codigo
			codViaje = file.readInt();
			// Leer nombre
			for (int i = 0; i < nombre.length; i++) {
				aux = file.readChar();
				nombre[i] = aux;
			}
			String nombreS=new String(nombre);
			// Leer el PVP
			pvp = file.readInt();
			// Leer las plazas
			plazas=file.readInt();
			// Leer la situación
			for (int i = 0; i < situacion.length; i++) {
				aux = file.readChar();
				situacion[i] = aux;
			}
			String situacionS=new String(situacion);

			// Comparar que no sea 0 el código
			if(codViaje != 0) {
				System.out.printf("%10s %-30s %8s %8s %10s%n", codViaje, nombreS, pvp, plazas, situacionS);
				contMedia++;
				
				sumaPlazas+=plazas;
				sumaPVP+=pvp;
			}

			// Posicionarse en el siguiente viaje
			posicion+=LONGITUD_VIAJES;

			if (file.getFilePointer() == file.length()) {
				file.close();
				break;
			}
		}
		System.out.printf("%10s %-30s %8s %8s %10s%n", "----------", "------------------------------", "--------","--------", "----------");
		System.out.printf("%10s %-30s %8s %8s %10s%n", "MEDIAS", "", (Math.round(sumaPVP/contMedia)),(Math.round(sumaPlazas/contMedia)), "");
	}

	// Método para actualizar el archivo Viajes.dat
	private static void actualizarViajes() throws IOException {
		// Fichero del archivo Movimientos.dat
		File fichero = new File(".\\Movimientos.dat");
		RandomAccessFile fileMovimientos= new RandomAccessFile(fichero, "r");
		// Fichero del archivo Viajes.dat
		File ficheroViajes= new File(".\\Viajes.dat");
		RandomAccessFile fileViajes=new RandomAccessFile(ficheroViajes, "rw");

		// Variables viajes
		int codViaje;
		char[] nombreViajes= new char[30];
		char aux;
		int pvpViajes;
		int plazasViajes;
		char situacionViajes;

		// Variables movimientos
		int codMovimientos;
		char[] nombreMovimiento= new char[30];
		int pvpMovimientos;
		int plazasMovimientos;
		char situacionMovimientos;
		
		StringBuffer buffer=null;

		// Posiciones
		int posicionMov= 0;
		int posicionViajes= 0;

		for (;;) {
			try {
				fileMovimientos.seek(posicionMov);

				// Leer codigo
				codMovimientos = fileMovimientos.readInt();
				// Leer nombre
				for (int i = 0; i < nombreMovimiento.length; i++) {
					aux = fileMovimientos.readChar();
					nombreMovimiento[i] = aux;
				}
				String nombreMovimientoFinal=new String(nombreMovimiento);
				// Leer el PVP
				pvpMovimientos = fileMovimientos.readInt();
				// Leer las plazas
				plazasMovimientos=fileMovimientos.readInt();
				// Leer la situación
				situacionMovimientos=fileMovimientos.readChar();

				// Condicional para cuando la situación sea A
				if(situacionMovimientos == 'A') {
					for (;;) {
						fileViajes.seek(fileViajes.length());

						fileViajes.writeInt(codMovimientos);

						buffer=new StringBuffer(nombreMovimientoFinal);
						buffer.setLength(30);
						fileViajes.writeChars(buffer.toString());

						fileViajes.writeInt(pvpMovimientos);

						fileViajes.writeInt(plazasMovimientos);
						
						fileViajes.writeChar('A');

						posicionViajes+=LONGITUD_VIAJES;

						if (fileViajes.getFilePointer() == fileViajes.length()) {
							break;
						}
					}
				// Condicional para cuando la situación sea B
				} else if(situacionMovimientos == 'B') {
					posicionViajes=0;
					for (;;) {
						fileViajes.seek(posicionViajes);

						// Leer codigo
						codViaje = fileViajes.readInt();
						// Leer nombre
						for (int i = 0; i < nombreViajes.length; i++) {
							aux = fileViajes.readChar(); 
							nombreViajes[i] = aux; 
						}
						String nombreViajesFinal=new String(nombreViajes);
						// Leer el PVP
						pvpViajes = fileViajes.readInt();
						// Leer las plazas
						plazasViajes=fileViajes.readInt();
						// Leer la situación
						situacionViajes=fileViajes.readChar();

						if(codMovimientos == codViaje && codViaje != 0) {
							fileViajes.seek(posicionViajes);
							
							fileViajes.writeInt(0);

							buffer=new StringBuffer("");
							buffer.setLength(30);
							fileViajes.writeChars(buffer.toString());

							fileViajes.writeInt(0);

							fileViajes.writeInt(0);
							
							fileViajes.writeChar(' ');
						}

						posicionViajes+=LONGITUD_VIAJES;

						if (fileViajes.getFilePointer() == fileViajes.length()) {
							break;
						}
					}
				//Condicional para cuando la situación sea M
				} else if(situacionMovimientos == 'M') {
					posicionViajes=0;
					for (;;) {
						fileViajes.seek(posicionViajes);

						// Leer codigo
						codViaje = fileViajes.readInt();
						// Leer nombre
						for (int i = 0; i < nombreViajes.length; i++) {
							aux = fileViajes.readChar(); 
							nombreViajes[i] = aux; 
						}
						String nombreViajesFinal=new String(nombreViajes);
						// Leer el PVP
						pvpViajes = fileViajes.readInt();
						pvpViajes+=pvpMovimientos;
						
						// Leer las plazas
						plazasViajes=fileViajes.readInt();
						plazasViajes+=plazasMovimientos;
						
						// Leer la situación
						situacionViajes=fileViajes.readChar();

						if(codMovimientos == codViaje && codViaje != 0) {
							fileViajes.seek(posicionViajes);
							
							fileViajes.writeInt(codViaje);

							buffer=new StringBuffer(nombreViajesFinal);
							buffer.setLength(30);
							fileViajes.writeChars(buffer.toString());

							fileViajes.writeInt(pvpViajes);

							fileViajes.writeInt(plazasMovimientos);
							
							fileViajes.writeChar('M');
						}

						posicionViajes+=LONGITUD_VIAJES;

						if (fileViajes.getFilePointer() == fileViajes.length()) {
							break;
						}
					}
				}
				
				posicionMov+=LONGITUD_MOV_INICAL;


			} catch (EOFException e) {
				break;
			}
			// Salir del for cuando haya recorrido todos los bytes
			if (fileMovimientos.getFilePointer() == fileMovimientos.length()) {
				fileMovimientos.close();
				break;
			}
		}
		System.out.println("FICHERO VIAJES ACTUALIZADO");
	}

	// Menú a imprimir
	private static void menu() {
		System.out.println("---------------------------------");
		System.out.println("1. Actualizar Viajes.dat");
		System.out.println("2. Listar el fichero Viajes.dat");
		System.out.println("3. Crear XML viajes.xml");
		System.out.println("4. Listar movimientos");
		System.out.println("0. Salir");
		System.out.println("---------------------------------");
	}

}
