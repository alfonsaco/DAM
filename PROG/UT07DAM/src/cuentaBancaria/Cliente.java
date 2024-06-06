package cuentaBancaria;

import java.util.ArrayList;

public class Cliente {
	private String codigoCliente;
	private String dni;
	private String nombre;
	private String apellidos;
	private ArrayList<Cuenta> cuentas;
	
	// Constructores
	public Cliente(String codigoCliente, String dni, String nombre, String apellidos, ArrayList<Cuenta> cuentas) {
		this.codigoCliente = codigoCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cuentas = cuentas;
	}
	public Cliente() {
		this.codigoCliente = "";
		this.dni = "";
		this.nombre = "";
		this.apellidos = "";
		this.cuentas =new ArrayList<Cuenta>();
	}
	public Cliente(String codigoCliente, String dni, String nombre, String apellidos) {
		this.codigoCliente = codigoCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cuentas =new ArrayList<Cuenta>();
	}
	
	// Getters y Setters
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	// toString
	@Override
	public String toString() {
		return this.getNombre()+" "+this.getApellidos()+"\r\tCodigo cliente: "+this.codigoCliente+"\r\tDNI: "+this.getDni();
	}
	
	// Método mostrar cuentas
	public void mostrarCuentas() {
		for (Cuenta c : cuentas) {
			System.out.println(c.getCuenta()+" "+c.getSaldo()+"€");
		}
	}
	
	// Total cuentas
	public double totalCuentas() {
		double suma=0;
		for (Cuenta c : cuentas) {
			suma+=c.getSaldo();
		}
		return suma;
	}
	
	// Main
	public static void main(String[] args) {
		Cuenta c1=new Cuenta("ES432432","Nomina","b535","R54",1990);
		Cuenta c2=new Cuenta("ES5436546","Nomina","R564","F654",12329);
		Cliente  cli=new Cliente("J543","4324","Pedrito","Perez");
		cli.getCuentas().add(c1);
		cli.getCuentas().add(c2);
		
		System.out.println(cli);
		System.out.println("\rCuentas bancarias: ");
		cli.mostrarCuentas();
		System.out.println("\nTOTAL: "+cli.totalCuentas()+"€");
	}
}
