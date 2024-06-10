package Texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CentroDAM {
	private ArrayList <String>listaCorreo;
	
	public CentroDAM() {
		this.listaCorreo = new ArrayList<String>();
	}
	
	public ArrayList<String> getListaCorreo() {
		return listaCorreo;
	}

	public void setListaCorreo(ArrayList<String> listaCorreo) {
		this.listaCorreo = listaCorreo;
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter salida=new PrintWriter(new File("correosDAM.txt"));
		Scanner entrada=new Scanner(new File("dam.csv"));
		CentroDAM app=new CentroDAM();
		String cadena;
		String[] linea;
		String nombreCompleto;
	
		
		while(entrada.hasNext()) {
			cadena=entrada.nextLine();
			//System.out.println(cadena);
			linea=cadena.split(";");
			nombreCompleto=linea[0].trim().toLowerCase();
			//System.out.println(nombreCompleto);
			
			//quitar tildes
			nombreCompleto=app.quitarTildes(nombreCompleto);
			//System.out.println(nombreCompleto);
			
			//nombre.ape1ape2
			nombreCompleto=app.formatoCorreo(nombreCompleto);
			
			
			//añadimos el correo a un AL de strings
			app.getListaCorreo().add(nombreCompleto+"@riberadeltajo.es");
		}
		
		
		for(String s: app.getListaCorreo())
			salida.println(s);
		
		salida.flush();
		salida.close(); //si no pones estas 3 instrucciones, se crearáun fichero vacio
		entrada.close();
		
	}
	
	
	private String formatoCorreo(String nombreCompleto) {
		String nombre=nombreCompleto.split(",")[1].trim(); //al usar split, te devuelve un array. Con el [1] nos quedamos con la posicion 1, la cual es el nombre
		nombre=nombre.replace(" ", "");
		String apellidos=nombreCompleto.split(",")[0].trim().replace(" ","");
		return nombre+"."+apellidos; 
	}


	private String quitarTildes(String nombreCompleto) {
			if(nombreCompleto.contains("á"))
				nombreCompleto=nombreCompleto.replaceAll("á","a");
			if(nombreCompleto.contains("é"))
				nombreCompleto=nombreCompleto.replaceAll("é","e");
			if(nombreCompleto.contains("í"))
				nombreCompleto=nombreCompleto.replaceAll("í","i");
			if(nombreCompleto.contains("ó"))
				nombreCompleto=nombreCompleto.replaceAll("ó","o");
			if(nombreCompleto.contains("ú"))
				nombreCompleto=nombreCompleto.replaceAll("ú","u");				
			return nombreCompleto;
	}
}