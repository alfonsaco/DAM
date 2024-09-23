package Ejemplo1;

import java.io.*;

public class AprenderClase {
	public static void main(String[] args) throws IOException {
		File ruta=new File(".//datosNegocio");

			RandomAccessFile archivosDato=new RandomAccessFile(ruta, "rw");
	
		String[] nombres= {"PELAYO","XOXI","CHARLOS","CARLOS","SOR TERESA"};
		int[] departamento= {123,432,42,441,876};
		StringBuffer buffer=null;
		
		for (int i = 0; i < departamento.length; i++) {
			buffer=new StringBuffer(nombres[i]);
			buffer.setLength(10);
			archivosDato.writeChars(buffer.toString());
			
			archivosDato.writeInt(departamento[i]);
		}
	}
}
