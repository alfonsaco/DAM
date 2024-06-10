package Texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lectura_csv {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner entrada=new Scanner(new File("fichero.csv"));
		String cadena="";
		String[] linea;
		int sumaLinea=0;
		int total=0;
		while(entrada.hasNext()) {
			cadena=entrada.nextLine();//leo la linea
			System.out.println(cadena);//imprimimos la linea por pantalla
			linea=cadena.split(";");  //dará como resultado un array de strings. Por eso hemos creado un string llamado linea. Separamos la linea por ;
			sumaLinea=0;
			for(int i=0; i<linea.length; i++) {
				sumaLinea+=Integer.parseInt(linea[i]);
			}
			System.out.println("--> "+sumaLinea+"\n");
			total+=sumaLinea;
		}	
		System.out.println(total);
	}
}
