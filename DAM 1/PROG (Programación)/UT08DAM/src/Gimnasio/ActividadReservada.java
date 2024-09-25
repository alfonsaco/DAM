package Gimnasio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ActividadReservada {
	private String nombreActividad;
	private double hora;
	private String codigoMonitor;
	private int maxNumParticipantes;
	private int numParticipantes;
	
	public ActividadReservada(String nombreActividad, double hora, String codigoMonitor, int maxNumParticipantes,
			int numParticipantes) {
		this.nombreActividad = nombreActividad;
		this.hora = hora;
		this.codigoMonitor = codigoMonitor;
		this.maxNumParticipantes = maxNumParticipantes;
		this.numParticipantes = numParticipantes;
	}
	public ActividadReservada() {
		this.nombreActividad = "";
		this.hora = 0;
		this.codigoMonitor = "";
		this.maxNumParticipantes = 0;
		this.numParticipantes = 0;
	}
	
	
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public double getHora() {
		return hora;
	}
	public void setHora(double hora) {
		this.hora = hora;
	}
	public String getCodigoMonitor() {
		return codigoMonitor;
	}
	public void setCodigoMonitor(String codigoMonitor) {
		this.codigoMonitor = codigoMonitor;
	}
	public int getMaxNumParticipantes() {
		return maxNumParticipantes;
	}
	public void setMaxNumParticipantes(int maxNumParticipantes) {
		this.maxNumParticipantes = maxNumParticipantes;
	}
	public int getNumParticipantes() {
		return numParticipantes;
	}
	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}
	
	@Override
	public String toString() {
		return "ActividadReservada [nombreActividad=" + nombreActividad + ", hora=" + hora + ", codigoMonitor="
				+ codigoMonitor + ", maxNumParticipantes=" + maxNumParticipantes + ", numParticipantes="
				+ numParticipantes + "]";
	}
	
	// Método calcular participantes
	public void calcularParticipantes() {
		try {
        	String cadena;
        	int nPart=0;
            String[] linea;
        	Scanner entrada=new Scanner(new File("participantes.txt"));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
}
