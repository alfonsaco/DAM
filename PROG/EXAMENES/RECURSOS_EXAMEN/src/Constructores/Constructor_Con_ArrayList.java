package notasAlumnos;
package EXAMEN;

import java.util.ArrayList;

public class Monitor extends Persona {
	private int codigoMonitor;
	private int clave;
	private ArrayList<Clase> clases;
	private double extraClases;
	private double extraAlumnos;
	// Constante
	public static final int BASE=1200;
	
	// Constructor
	-- con todo
	public Monitor(String dni, String nombre, String apellidos, String direccion, String correo, int codigoMonitor,
			int clave, ArrayList<Clase> clases, double extraClases, double extraAlumnos) {
		super(dni, nombre, apellidos, direccion, correo);
		this.codigoMonitor = codigoMonitor;
		this.clave = clave;
		this.clases = clases;
		this.extraClases = extraClases;
		this.extraAlumnos = extraAlumnos;
	}
	// por defecto, inicializando el arraylist
	public Monitor() {
		super();
		this.codigoMonitor = 0;
		this.clave = 0;
		this.clases =new ArrayList<Clase>();
		this.extraClases = 0;
		this.extraAlumnos = 0;
	}
	
	// Con el arraylist inciailizado, pero sin que esté en los parametros
	public Monitor(String dni, String nombre, String apellidos, String direccion, String correo, int codigoMonitor,
			int clave, double extraClases, double extraAlumnos) {
		super(dni, nombre, apellidos, direccion, correo);
		this.codigoMonitor = codigoMonitor;
		this.clave = clave;
		this.clases=new ArrayList<Clase>();
		this.extraClases = extraClases;
		this.extraAlumnos = extraAlumnos;
	}
	public int getCodigoMonitor() {
		return codigoMonitor;
	}
	public void setCodigoMonitor(int codigoMonitor) {
		this.codigoMonitor = codigoMonitor;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public ArrayList<Clase> getClases() {
		return clases;
	}
	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}
	public double getExtraClases() {
		return extraClases;
	}
	public void setExtraClases(double extraClases) {
		this.extraClases = extraClases;
	}
	public double getExtraAlumnos() {
		return extraAlumnos;
	}
	public void setExtraAlumnos(double extraAlumnos) {
		this.extraAlumnos = extraAlumnos;
	}
	public static int getBase() {
		return BASE;
	}
	
	// toString
	@Override
	public String toString() {
		return "Monitor [codigoMonitor=" + codigoMonitor + ", clave=" + clave + ", clases=" + clases + ", extraClases="
				+ extraClases + ", extraAlumnos=" + extraAlumnos + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", direccion=" + direccion + ", correo=" + correo + "]";
	}
		
}

*/