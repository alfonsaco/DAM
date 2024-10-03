package ventasProductos;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import XMLproductosVentas.Venta;

public class Principal {
	public static int LON_VENTAS=4+4+20;
	public static int LON_PRODUCTOS=4+30+4+8;
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				leerProductos();
				break;
			case 2:
				leerDatosVentas();
				break;
			case 3:
				actualizarProductos();
				break;
			case 4:
				generarXMLproductos();
				break;
			case 5:
				generarXMLproductosVentas();
				break;
			case 6:
				System.out.println("Se finalizó el programa");
				break;
			}
			
		} while (opcion!=6);
	}


	private static void generarXMLproductosVentas() throws IOException {
		File filePro=new File(".\\Productos.dat");
		RandomAccessFile archivoPro=new RandomAccessFile(filePro, "r");
		
		ArrayList<XMLproductosVentas.Producto> misproductos=new ArrayList<XMLproductosVentas.Producto>();
		
		int posicion=0;
		
		int codigo;
		char[] nombre=new char[15];
		char aux;
		int existencias;
		double pvp;
		
		while(archivoPro.getFilePointer() < archivoPro.length()) {
			archivoPro.seek(posicion);
			
			codigo=archivoPro.readInt();
			
			if(codigo != 0) {
				for (int i = 0; i < nombre.length; i++) {
					aux=archivoPro.readChar();
					nombre[i]=aux;
				}
				String nombreFinal=new String(nombre);
				
				existencias=archivoPro.readInt();
				
				pvp=archivoPro.readDouble();
				
				ArrayList<XMLproductosVentas.Venta> ventas=listarVentas(codigo, pvp);
				XMLproductosVentas.Producto pro=new XMLproductosVentas.Producto(codigo, nombreFinal, existencias, pvp, ventas);
				misproductos.add(pro);
			}
			
			posicion+=LON_PRODUCTOS;
		}
		
		XMLproductosVentas.Productos pros=new XMLproductosVentas.Productos();
		pros.setProductos(misproductos);
		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(XMLproductosVentas.Productos.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(pros, System.out);
			m.marshal(pros, new File(".\\ProductosVentas.xml"));
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}


	private static ArrayList<Venta> listarVentas(int codigo, double pvp) throws IOException {
		File fileVentas=new File("DatosdeVentas.dat");
		RandomAccessFile archivoVentas=new RandomAccessFile(fileVentas,"r");
		
		ArrayList<XMLproductosVentas.Venta> ventas=new ArrayList<XMLproductosVentas.Venta>(); 
		
		int codigoPro;
		int uniVen;
		char[] fehca=new char[10];
		char aux;

		int posicionVen=0;
		int tamañoVen=4+4+20;
	
		while(archivoVentas.length() != archivoVentas.getFilePointer()) {
			archivoVentas.seek(posicionVen);
			
			codigoPro=archivoVentas.readInt();
			
			uniVen=archivoVentas.readInt();
			
			for (int i = 0; i < fehca.length; i++) {
				aux=archivoVentas.readChar();
				fehca[i]=aux;
			}
			String fechaFinal=new String(fehca);
			
			double importe=0;
			
			if(codigoPro == codigo) {
				importe=pvp*uniVen;
				
				XMLproductosVentas.Venta v=new XMLproductosVentas.Venta(uniVen,fechaFinal,importe);
				ventas.add(v);
			}
			
			posicionVen+=LON_VENTAS;
		}

		
		return ventas;
	}


	private static void generarXMLproductos() throws IOException {
		File file=new File(".\\Productos.dat");
		RandomAccessFile archivo=new RandomAccessFile(file, "r");
		
		ArrayList<XMLproductos.Producto> misproductos=new ArrayList<XMLproductos.Producto>();
		
		int posicion=0;
		
		int codigo;
		char[] nombre=new char[15];
		char aux;
		int existencias;
		double pvp;
		
		while(archivo.getFilePointer() < archivo.length()) {
			archivo.seek(posicion);
			
			codigo=archivo.readInt();
			
			if(codigo != 0) {
				for (int i = 0; i < nombre.length; i++) {
					aux=archivo.readChar();
					nombre[i]=aux;
				}
				String nombreFinal=new String(nombre);
				
				existencias=archivo.readInt();
				
				pvp=archivo.readDouble();
				
				int unidades=unidadesVendidas(codigo);
				
				double importe=unidades*pvp;
				
				int stock=existencias-unidades;
				String estado;
				if(stock < 2) {
					estado="A REPONER";
				} else {
					estado="";
				}
				
				XMLproductos.Producto pro=new XMLproductos.Producto(codigo, nombreFinal, existencias, pvp, unidades, importe, estado);
				misproductos.add(pro);
			}
			
			posicion+=LON_PRODUCTOS;
		}
		
		XMLproductos.Productos pros=new XMLproductos.Productos();
		pros.setProductos(misproductos);
		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(XMLproductos.Productos.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(pros, System.out);
			m.marshal(pros, new File(".\\Productos.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}


	private static int unidadesVendidas(int codigo) throws IOException {
		File fileVentas=new File("DatosdeVentas.dat");
		RandomAccessFile archivoVentas=new RandomAccessFile(fileVentas,"r");
		
		int codigoPro;
		int uniVen;
		char[] fehca=new char[10];
		char aux;

		int uni=0;
		int posicionVen=0;
		int tamañoVen=4+4+20;
		
		while(archivoVentas.length() != archivoVentas.getFilePointer()) {
			archivoVentas.seek(posicionVen);
			
			codigoPro=archivoVentas.readInt();
			
			uniVen=archivoVentas.readInt();
			
			for (int i = 0; i < fehca.length; i++) {
				aux=archivoVentas.readChar();
				fehca[i]=aux;
			}
			String fechaFinal=new String(fehca);
			
			if(codigoPro == codigo) {
				uni+=uniVen;
			}
			
			posicionVen+=tamañoVen;
		}
	
		return uni;
	}


	// Actualizar productos
	// Actualizar productos
	private static void actualizarProductos() throws IOException {
	    File fileVentas = new File(".\\DatosdeVentas.dat");
	    RandomAccessFile archivoVentas = new RandomAccessFile(fileVentas, "r");

	    File file = new File(".\\Productos.dat");
	    RandomAccessFile archivo = new RandomAccessFile(file, "rw");

	    int posicionVentas = 0;
	    int posicionProductos = 0;

	    // Variables ventas
	    int codigoPro;
	    int uniVen;

	    // Variables productos
	    int codigo;
	    int existencias;
	    int pvp;

	    while (archivoVentas.getFilePointer() < archivoVentas.length()) {
	        archivoVentas.seek(posicionVentas);

	        try {
	            // Leer código de producto y unidades vendidas
	            codigoPro = archivoVentas.readInt();
	            uniVen = archivoVentas.readInt();

	            // Calcular la posición del producto en el archivo de productos
	            posicionProductos = (codigoPro - 1) * LON_PRODUCTOS;

	            // Verificar si la posición calculada está dentro del tamaño del archivo
	            if (posicionProductos >= archivo.length()) {
	                System.out.println("Error: Código de producto " + codigoPro + " está fuera del archivo de productos.");
	            } else {
	                archivo.seek(posicionProductos);
	                codigo = archivo.readInt(); // Leer el código del producto

	                if (codigo == codigoPro) {
	                    archivo.seek(posicionProductos + 34); // Ir a la posición de existencias
	                    existencias = archivo.readInt(); // Leer existencias actuales

	                    // Verificar si las existencias son suficientes
	                    if (existencias >= uniVen) {
	                        existencias -= uniVen; // Restar las unidades vendidas
	                        archivo.seek(posicionProductos + 34); // Volver a la posición de existencias
	                        archivo.writeInt(existencias); // Escribir existencias actualizadas
	                        
	                        
	                        System.out.println("Actualizado producto " + codigoPro + ": nuevas existencias = " + existencias);
	                    } else {
	                        System.out.println("Advertencia: No hay suficientes existencias para el producto " + codigoPro + ". Ventas no actualizadas.");
	                    }
	                } else {
	                    System.out.println("Error: Código de producto en archivo no coincide con el código de ventas.");
	                }
	            }

	        } catch (EOFException e) {
	            // Salir del bucle si llegamos al final del archivo
	            break;
	        }

	        posicionVentas += LON_VENTAS; // Avanzar a la siguiente venta
	    }

	    archivoVentas.close();
	    archivo.close();
	}




	// Método para leer los datos Ventas
	private static void leerDatosVentas() throws IOException {
		File file=new File("Productos.dat");
		RandomAccessFile archivo=new RandomAccessFile(file,"r");
		
		int codigo;
		char[] nombre=new char[15];
		char aux;
		int existencias;
		double pvp;
		ArrayList<Integer> codigos=new ArrayList<>();
		
		int posicion=0;
		int tamaño=4+30+4+8;
		
		while(archivo.length() != archivo.getFilePointer()) {
			archivo.seek(posicion);
			
			codigo=archivo.readInt();
			
			for (int i = 0; i < nombre.length; i++) {
				aux=archivo.readChar();
				nombre[i]=aux;
			}
			String nombreS=new String(nombre);
			
			existencias=archivo.readInt();
			
			pvp=archivo.readDouble();

			if(!codigos.contains(codigo)) {
				codigos.add(codigo);
			}
			
			posicion+=tamaño;
		}
		
		File fileVentas=new File("DatosdeVentas.dat");
		RandomAccessFile archivoVentas=new RandomAccessFile(fileVentas,"r");
		
		int codigoPro;
		int uniVen;
		char[] fehca=new char[10];

		int posicionVen=0;
		int tamañoVen=4+4+20;
		
		System.out.printf("%10s %-20s %15s\n","CODIGO","UNI VEN","FECHA");
		System.out.printf("%10s %-20s %15s\n","----------","--------------------","---------------");

		
		while(archivoVentas.length() != archivoVentas.getFilePointer()) {
			archivoVentas.seek(posicionVen);
			
			codigoPro=archivoVentas.readInt();
			
			uniVen=archivoVentas.readInt();
			
			for (int i = 0; i < fehca.length; i++) {
				aux=archivoVentas.readChar();
				fehca[i]=aux;
			}
			String fechaFinal=new String(fehca);
			
			if(codigos.contains(codigoPro)) {
				System.out.printf("%10s %-20s %15s\n",codigoPro,uniVen,fechaFinal);
			}
			
			posicionVen+=tamañoVen;
		}
	}


	// Método para leer los productos
	private static void leerProductos() throws IOException {
		File file=new File("Productos.dat");
		RandomAccessFile archivo=new RandomAccessFile(file,"r");
		
		int codigo;
		char[] nombre=new char[15];
		char aux;
		int existencias;
		double pvp;
		
		int posicion=0;
		int tamaño=4+30+4+8;
		
		System.out.printf("%10s %-20s %15s %10s\n","CODIGO","NOMBRE","EXISTENCIAS","PVP");
		System.out.printf("%10s %-20s %15s %10s\n","----------","--------------------","---------------","----------");

		
		while(archivo.length() != archivo.getFilePointer()) {
			archivo.seek(posicion);
			
			codigo=archivo.readInt();
			
			for (int i = 0; i < nombre.length; i++) {
				aux=archivo.readChar();
				nombre[i]=aux;
			}
			String nombreS=new String(nombre);
			
			existencias=archivo.readInt();
			
			pvp=archivo.readDouble();
			
			if(codigo>0 && codigo<100) {
				System.out.printf("%10s %-20s %15s %10s\n",codigo,nombreS,existencias,pvp);
			}
			
			posicion+=tamaño;
		}
	}


	// Menú para imprimir
	private static void menu() {
		System.out.println("-------------------------------");
		System.out.println("1. Leer productos");
		System.out.println("2. Leer datos ventas");
		System.out.println("3. Actualizar productos");
		System.out.println("4. Generar XML de productos");
		System.out.println("5. Generar XML de ventas productos");
		System.out.println("6. Salir");
		System.out.println("-------------------------------");
	}
}
