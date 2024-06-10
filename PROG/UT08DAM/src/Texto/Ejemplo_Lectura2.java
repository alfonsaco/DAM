package Texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejemplo_Lectura2 {
	public static void main(String[] args) throws FileNotFoundException {
		File f=new File("jugadores.csv");
		Scanner entrada=new Scanner(f);  //tenemos que poner el nombre del fichero aqui
		String cadena="";
		String[] linea;
		int total=0;
		while(entrada.hasNext()) {
			cadena=entrada.nextLine();//leo la linea
			System.out.println(cadena);//imprimimos la linea por pantalla
			linea=cadena.split(";");  //dará como resultado un array de strings. Por eso hemos creado un string llamado linea. Separamos la linea por ;
		}	
		System.out.println(total);
	}
}
