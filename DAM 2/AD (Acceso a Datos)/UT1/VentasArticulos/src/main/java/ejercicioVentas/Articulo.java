package ejercicioVentas;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"codigo","denominacion","stock","precio"})
public class Articulo {
	private String codigo;
	private String denominacion;
	private int stock;
	private float precio;
	
	public Articulo(String codigo, String denominacion, int stock, float precio) {
		super();
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.stock = stock;
		this.precio = precio;
	}
	public Articulo() {

	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
} 
