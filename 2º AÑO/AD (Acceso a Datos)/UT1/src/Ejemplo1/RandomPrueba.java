package Ejemplo1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomPrueba {
	public static void main(String[] args) throws IOException {

		RandomAccessFile archivo=new RandomAccessFile("fichero.dat", "rw");
		int[] numeros= {3,5,6,2,5,6,7,3,2,5,6};
		
		for (int i = 0; i < numeros.length; i++) {
			archivo.writeInt(numeros[i]);
		}
		
	}
}
