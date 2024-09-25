package Ejemplo1;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class EjemploApuntes {
	public static void main(String[] args) {
//		String dir = "C:\\Users\\PROGRAMACION\\Desktop\\Pruebas\\carpeta";
//		File f = new File(dir);
//
//		// Crear carpetas
//		Scanner sc = new Scanner(System.in);
//		System.out.println("¿Cuantos ficheros quieres crear?");
//		int n = sc.nextInt();
//		for (int i=0; i<n; i++) {
//			File carpeta=new File(f,"carpeta"+(i+1));
//			carpeta.mkdir();
//			System.out.println("Carpeta "+(i+1)+" creada correctamente.");
//		}
//		
//		File borrar=new File(dir, "carpeta18");
//		if(borrar.exists()) {
//			borrar.delete();
//		}
//
//		
//		String[] archivosCarpeta=f.list();
//		System.out.println("En total hay "+archivosCarpeta.length+" archivos en tu carpeta");
//		for (int i = 0; i < archivosCarpeta.length; i++) {
//			File f2=new File(f, archivosCarpeta[i]);
//			System.out.printf("Nombre: %s, Es carpeta? %b,     Es archivo? %b%n", archivosCarpeta[i], f2.isDirectory(), f2.isFile());
//		}
//
//	

		
//		File f1 = new File(d, "FICHERO1.TXT");
//		File f2 = new File(d, "FICHERO2.TXT");
//
//		d.mkdir();// CREAR DIRECTORIO
//
//		try {
//			if (f1.createNewFile())
//				System.out.println("FICHERO1 creado correctamente...");
//			else
//				System.out.println("No se ha podido crear FICHERO1...");
//			if (f2.createNewFile())
//				System.out.println("FICHERO2 creado correctamente...");
//			else
//				System.out.println("No se ha podido crear FICHERO2...");
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//
//		f1.renameTo(new File(d, "FICHERO1NUEVO"));// renombro FICHERO1
//
//		try {
//			File f3 = new File("NUEVODIR/FICHERO3.TXT");
//			f3.createNewFile();// crea FICHERO3 en NUEVODIR
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}

		File d = new File("C:\\Users\\PROGRAMACION\\Desktop\\Pruebas\\carpeta\\carpeta10"); // directorio que creo
		File bloc1=new File(d, "holaMundo.txt");
		
		try {
			if(bloc1.createNewFile())
				System.out.println("Fichero creado con éxito");
			else 
				System.out.println("No se pudo crear la carpeta");
		} catch (IOException ioe) {
			
		}
	}

}
