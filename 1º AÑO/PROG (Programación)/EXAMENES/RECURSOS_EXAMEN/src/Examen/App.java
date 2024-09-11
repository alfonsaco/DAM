package Examen;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	private ArrayList<Cliente> clientes;
	private Gerente gerente;
	
	// Constructores
	public App(ArrayList<Cliente> clientes, Gerente gerente) {
		this.clientes = clientes;
		this.gerente = gerente;
	}
	public App() {
		this.clientes =new ArrayList<Cliente>();
		this.gerente = new Gerente();
		gerente.setApellidos("");
		gerente.setNombre("");
	}
	
	// Getters y Setters
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
	// Prueba unitaria
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		App app=new App();
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			
			switch(opcion) {
			case 1:
				System.out.print("Nombre: ");
				String nom=sc.next();
				System.out.print("Apellido: ");
				String ape=sc.next();
				System.out.print("Dirección: ");
				String dir=sc.next();
				System.out.print("Correo: ");
				String cor=sc.next();
				System.out.print("Método de pago: ");
				String met=sc.next();
				System.out.print("Cuota: ");
				double cuo=sc.nextDouble();
				Cliente cli=new Cliente(nom,ape,dir,cor,0,"",met,cuo);
				app.gerente.altaCliente(cli);
				app.clientes.add(cli);
				System.out.println("Usuario insertado correctamente");
				break;
			case 2:
				for (Cliente c : app.getClientes()) {
					app.gerente.generarFactura(c);
					System.out.println("Factura para "+c.getNombre()+" "+c.getApellidos()+" generada correctamente");
				}
				break;
			case 3:
				System.out.println("Se cerró el programa");
				break;
			}
		} while (opcion!=3);
	}
	private static void menu() {
		System.out.println("1. Dar de alta un nuevo cliente");
		System.out.println("2. Generar facturas");
		System.out.println("3. Salir");
	}
	
}
