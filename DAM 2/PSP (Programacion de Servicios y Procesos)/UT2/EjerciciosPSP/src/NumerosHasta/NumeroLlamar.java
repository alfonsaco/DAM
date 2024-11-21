package NumerosHasta;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class NumeroLlamar {
	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "NumerosHasta.Numeros");
		File directorio = new File(".\\bin");
		pb.directory(directorio);
		Process p = pb.start();
		OutputStream ot=p.getOutputStream();
		// Este 2 es el número que se ejecutará para el programa de llamar numeros
		ot.write("2\n".getBytes());
		ot.flush();
		ot.close();
		
		try {
			
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;	
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// CONTROL DE LOS MENSAJES DE ERROR
		try {
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			
			while ((liner = brer.readLine()) != null) {
				System.out.println("ERROR > " + liner);
			}
			
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		
		// COMPROBACIÓN DE ERROR - 0 bien -1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
