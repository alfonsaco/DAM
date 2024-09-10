package Examen;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cliente extends Persona {
	private int codigoCliente;
	private String clave;
	private String metodoPago;
	private double cuota;
	private ArrayList<Clase> clases;
	
	// Constructores
	public Cliente(String nombre, String apellidos, String direccion, String correo, int codigoCliente, String clave,
			String metodoPago, double cuota, ArrayList<Clase> clases) {
		super(nombre, apellidos, direccion, correo);
		this.codigoCliente = codigoCliente;
		this.clave = clave;
		this.metodoPago = metodoPago;
		this.cuota = cuota;
		this.clases = clases;
	}
	public Cliente() {
		super();
		this.codigoCliente = 0;
		this.clave = "";
		this.metodoPago = "";
		this.cuota = 0;
		this.clases =new ArrayList<Clase>();
	}
	public Cliente(String nombre, String apellidos, String direccion, String correo, int codigoCliente, String clave,
			String metodoPago, double cuota) {
		super(nombre, apellidos, direccion, correo);
		this.codigoCliente = codigoCliente;
		this.clave = clave;
		this.metodoPago = metodoPago;
		this.cuota = cuota;
		this.clases =new ArrayList<Clase>();
	}
	
	// Getters y Setters
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	public ArrayList<Clase> getClases() {
		return clases;
	}
	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}
	
	// toString
	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", clave=" + clave + ", metodoPago=" + metodoPago
				+ ", cuota=" + cuota + ", clases=" + clases + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", correo=" + correo + "]";
	}
	
	// Método cargar clases
	public void cargarClasesMes() {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File("clasesMayo2023.csv"));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		this.getClases().add(new Clase(Integer.parseInt(linea[0]),linea[1],Integer.parseInt(linea[2]),linea[3],Integer.parseInt(linea[4]),Integer.parseInt(linea[5])));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Cliente c=new Cliente("Pedro","Perez","","",501,"aabb","",200);
		c.cargarClasesMes();
		
		System.out.println(c.clases);
	}
}
