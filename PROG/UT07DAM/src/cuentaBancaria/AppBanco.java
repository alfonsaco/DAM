package cuentaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class AppBanco {
	private ArrayList<Cliente> clientes;

	// Constructores
	public AppBanco() {
		this.clientes =new ArrayList<Cliente>();
	}

	// Getters y Setters
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	// Main
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AppBanco app=new AppBanco();
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.print("Codigo cliente: ");
				String cod=sc.next();
				System.out.print("DNI: ");
				String dni=sc.next();
				System.out.print("Nombre: ");
				String nom=sc.next();
				System.out.print("Apellidos: ");
				String ape=sc.next();
				app.nuevoCliente(cod,dni,nom,ape);
				break;
			case 2:
				app.mostrarClientes();
				break;
			case 3:
				String codigo="1234";
				break;
			}

		} while (opcion!=4);
	}

	private void mostrarClientes() {
		for (Cliente c : this.getClientes()) {
			System.out.println(c);
		}
	}

	// Añadir clientes
	private void nuevoCliente(String cod, String dni, String nom, String ape) {
		this.getClientes().add(new Cliente(cod,dni,nom,ape));
	}

	//Menú
	private static void menu() {
		System.out.println("1. Alta cliente");
		System.out.println("2. Mostrar clientes");
		System.out.println("3. Acceso cliente");
		System.out.println("4. Salir");
	}
	
	
	
}
