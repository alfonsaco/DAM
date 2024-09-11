package Examen;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.File;

public class Gerente extends Persona implements Impuestos, Serializable {
	private String telefono;

	// Constructores
	public Gerente(String nombre, String apellidos, String direccion, String correo, String telefono) {
		super(nombre, apellidos, direccion, correo);
		this.telefono = telefono;
	}
	public Gerente() {
		super();
		this.telefono = "";
	}
	
	// Getters y Setters
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	// toString
	@Override
	public String toString() {
		return "Gerente [telefono=" + telefono + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", correo=" + correo + "]";
	}
	
	// Método para formar cadena
	public String generarPass() {
		char[] letras=("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXZY").toCharArray();
		String cadena="";
		
		for (int i=0; i<8; i++) {
			cadena+=letras[(int)(Math.random()*52)];
		} 
		
		return cadena;
	}
	
	// Método para dar de alta a cliente
	public void altaCliente(Cliente c) {
		c.setClave(generarPass());
		int mayor=0;
		
		for (Clase cli : c.getClases()) {
			if(cli.getCodigoAlumno() > mayor) {
				mayor=cli.getCodigoAlumno();
			}
		}
		mayor++;
		c.setCodigoCliente(mayor);
	}

	// Devolver IVA
	@Override
	public double IVA(double cantidad) {
		return cantidad*0.24;
	}
	
	// Imprimir txt
	public void generarFactura(Cliente c) {
		File directorio=new File("Facturas");
		if(!directorio.exists()) {
			directorio.mkdir();
		}
		
			PrintWriter salida;
			try {
				salida = new PrintWriter(new File(directorio,"Factura"+c.getNombre()+c.getApellidos()+".txt"));
				salida.println("******** GIMNASIO RIBERA ********");
				salida.println("Factura de Mayo");
				salida.println("Cliente: "+c.getNombre()+" "+c.getApellidos());
				salida.println("Cuota: "+c.getCuota());
				int countCla=0;
					for(Clase cla: c.getClases()) {
						if(cla.getCodigoAlumno() == c.getCodigoCliente()) {
							countCla++;
						}
					}
				salida.println("Nº de Clases: "+countCla);
				salida.println("\tDía   Hora   Clase");
				salida.println("**************************");
					for (Clase cla : c.getClases()) {
						if(cla.getCodigoAlumno() == c.getCodigoCliente()) {
							salida.println("\t"+cla.getDia()+"    "+cla.getHora()+"     "+cla.getCodigoClase());
						}
					}
				salida.println("**************************");
				double importe=c.getCuota()+2*countCla+IVA(c.getCuota()+2*countCla);
				salida.println("\t\tIMPORTE: "+importe+"€");
				salida.flush();
				salida.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	// Prueba unitaria
	public static void main(String[] args) {
		Gerente g=new Gerente();
		Cliente cli=new Cliente();
		cli.cargarClasesMes();
		
		g.altaCliente(cli);
		System.out.println(g.generarPass());
		System.out.println(cli);
		
		Gerente g1=new Gerente("","","","","");
		Cliente c1=new Cliente("María","Perez","C/Cosas","m@gmail.com",550,"","Tarjeta",200);
		g.altaCliente(c1);
		Cliente c2=new Cliente("Leticia","Perez","C/Cosas","leticas@a.com",511,"","Tarjeta",200);
		c2.cargarClasesMes();
		g.generarFactura(c2);

	}
}
