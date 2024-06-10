package Texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejemplo_Lectura {
	public static void main(String[] args) throws FileNotFoundException { //ponemos esto en caso de que nos de error en el fichero
		File f=new File("numeros.txt");
		Scanner entrada=new Scanner(f);  //tenemos que poner el nombre del fichero aqui
		int suma=0;
		int n=0;
		while(entrada.hasNext()) {
			n=entrada.nextInt();
			System.out.println(n);  //imprimirá todos los números del fichero
			suma=suma+n;			
		}
		System.out.println(suma);
	}
}
