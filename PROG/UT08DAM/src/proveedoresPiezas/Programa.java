package proveedoresPiezas;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Programa {
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Pieza> piezas;
	
	// Constructor
	public Programa() {
		this.proveedores =new ArrayList<Proveedor>();
		this.piezas =new ArrayList<Pieza>();
	}

	// Getters y Setters
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(ArrayList<Pieza> piezas) {
		this.piezas = piezas;
	}

	// toString
	@Override
	public String toString() {
		return "Programa [proveedores=" + proveedores + ", piezas=" + piezas + "]";
	}
	
	
	// Método generar fichero
	public void generarFichero(String filename) {
			PrintWriter salida;
			double suma=0;
			try {
				salida = new PrintWriter(new File(filename));
				for(Proveedor p: this.getProveedores()) {
					salida.println("El proveedor "+p.getNombreProveedor()+" suministra:");
					for (Pieza pi : this.getPiezas()) {
						if(p.getCodProveedor()==pi.getProveedor()) {
							salida.println("\t"+pi.getNombrePieza());
						}
					}
					salida.println("\n");
				}
				salida.flush();
				salida.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	// Prueba
	public static void main(String[] args) throws IOException {
		Programa p=new Programa();
		Utilidades u=new Utilidades();
		p.setPiezas(u.leerPiezas("piezas.csv"));
		p.setProveedores(u.leerProveedor("proveedor.csv"));
		
		try {
			p.generarFichero("proveedorPieza.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
