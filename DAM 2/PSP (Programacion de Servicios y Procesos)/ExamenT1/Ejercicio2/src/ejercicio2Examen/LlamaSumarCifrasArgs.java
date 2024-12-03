package ejercicio2Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class LlamaSumarCifrasArgs {
	public static void main(String[] args) throws IOException {
		ProcessBuilder processBuilder=new ProcessBuilder("java","ejercicio2Examen.SumaCifrasArgs","8","9");
		File carpeta=new File(".\\bin");
		processBuilder.directory(carpeta);
		Process process=processBuilder.start();
		
		try {
			InputStream input=process.getInputStream();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(input));
			String linea;
			while((linea=bufferedReader.readLine()) != null) {
				System.out.println(linea);
			}
			bufferedReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			InputStream input=process.getErrorStream();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(input));
			String linea=null;
			while((linea=bufferedReader.readLine()) != null) {
				System.out.println("Error > "+linea);
			}
			bufferedReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int salida;
		try {
			salida=process.waitFor();
			System.out.println("Salida: "+salida);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
