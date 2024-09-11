package proveedoresPiezas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {

	// Cargar piezas
	public ArrayList<Pieza> leerPiezas(String filename) throws IOException {
		ArrayList<Pieza> p=new ArrayList<Pieza>();
		
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File(filename));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		p.add(new Pieza(Integer.parseInt(linea[0]),linea[1],Integer.parseInt(linea[2]),Integer.parseInt(linea[3])));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
		
		return p;
	}
	
	// Cargar proveedores
	public ArrayList<Proveedor> leerProveedor(String filename) {
		ArrayList<Proveedor> pr=new ArrayList<Proveedor>();
		
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File(filename));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		pr.add(new Proveedor(Integer.parseInt(linea[0]),linea[1],linea[2]));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
		
		return pr;
	}
	
	// Pruebas
	public static void main(String[] args) throws IOException {
		Utilidades uti=new Utilidades();
		System.out.println(uti.leerPiezas("piezas.csv"));
		System.out.println(uti.leerProveedor("proveedor.csv"));
	}
}
