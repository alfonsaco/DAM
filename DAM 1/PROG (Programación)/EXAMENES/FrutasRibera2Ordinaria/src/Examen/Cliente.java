package Examen;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Cliente extends Persona {
	private String metodoPago;
	private ArrayList<Pedido> historicoPedidos;
	
	// Constructores
	public Cliente(String dni, String nombre, String apellidos, String direccion, String metodoPago,
			ArrayList<Pedido> historicoPedidos) {
		super(dni, nombre, apellidos, direccion);
		this.metodoPago = metodoPago;
		this.historicoPedidos = historicoPedidos;
	}
	public Cliente() {
		super();
		this.metodoPago = "";
		this.historicoPedidos =new ArrayList<Pedido>();
	}
	public Cliente(String dni, String nombre, String apellidos, String direccion, String metodoPago) {
		super(dni, nombre, apellidos, direccion);
		this.metodoPago = metodoPago;
		this.historicoPedidos =new ArrayList<Pedido>();
	}
	
	// Getters y Setters
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public ArrayList<Pedido> getHistoricoPedidos() {
		return historicoPedidos;
	}
	public void setHistoricoPedidos(ArrayList<Pedido> historicoPedidos) {
		this.historicoPedidos = historicoPedidos;
	}
	
	// toString
	@Override
	public String toString() {
		return "Cliente [metodoPago=" + metodoPago + ", historicoPedidos=" + historicoPedidos + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + "]";
	}
	
	// Método para leer el fichero y asignar un método de pago
	public void asignarMetodoPago() {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File("metodoPagoCliente.csv"));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		if(linea[0].equals(this.getDni())) {
        			this.setMetodoPago(linea[1]);
        		}
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	public void cargarHistorico() {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File("Pedidos2022.csv"));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		this.getHistoricoPedidos().add(new Pedido(Integer.parseInt(linea[0]),linea[1],Double.parseDouble(linea[2])));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	// Pruebas unitarias
	public static void main(String[] args) {
		Cliente c=new Cliente();
		c.setDni("11111111H");
		
		c.asignarMetodoPago();
		System.out.println(c.getMetodoPago());
		
		c.cargarHistorico();
		for (Pedido p : c.getHistoricoPedidos()) {
			System.out.println(p);
		}
	}
	
}
