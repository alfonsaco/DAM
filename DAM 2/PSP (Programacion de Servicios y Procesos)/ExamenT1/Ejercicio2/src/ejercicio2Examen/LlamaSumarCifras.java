package ejercicio2Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamaSumarCifras {
	public static void main(String[] args) throws IOException {
		ProcessBuilder processBuilder=new ProcessBuilder("java","ejercicio2Examen.SumaCifras");
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Dame un número: ");
		int n=sc.nextInt();
		System.out.print("Dame un número: ");
		int n2=sc.nextInt();
		
		// Saltos de línea para evitar errores
		String valor1=String.valueOf(n)+"\n";
		String valor2=String.valueOf(n2)+"\n";
		
		File carpeta=new File(".\\bin");
		processBuilder.directory(carpeta);
		Process process=processBuilder.start();
		OutputStream output=process.getOutputStream();
		output.write(valor1.getBytes());
		output.write(valor2.getBytes());
		output.flush();
		output.close();
		
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
