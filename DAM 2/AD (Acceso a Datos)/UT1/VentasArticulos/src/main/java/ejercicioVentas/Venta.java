package ejercicioVentas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"numVenta","unidades","nombreCliente","fecha"})
public class Venta {
	private int numventa;
	private int unidades;
	private String nombrecliente;
	private String fecha;
	
	public Venta(int numVenta, int unidades, String nombreCliente, String fecha) {
		this.numventa = numVenta;
		this.unidades = unidades;
		this.nombrecliente = nombreCliente;
		this.fecha = fecha;
	}
	public Venta() {

	}
	
	// Getters y Setters
	public int getNumVenta() {
		return numventa;
	}
	public void setNumVenta(int numVenta) {
		this.numventa = numVenta;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public String getNombreCliente() {
		return nombrecliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombrecliente = nombreCliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
