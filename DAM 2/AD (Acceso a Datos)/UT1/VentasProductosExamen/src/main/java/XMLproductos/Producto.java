package XMLproductos;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"codigo","nombre","existencias","precio","unidadesvendidas","importe","estado"})
public class Producto {
	private int codigo;
	private String nombre;
	private int existencias;
	private double precio;
	private int unidadesvendidas;
	private double importe;
	private String estado;
	
	
	public Producto(int codigo, String nombre, int existencias, double precio, int unidadesvendidas, double importe,
			String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.existencias = existencias;
		this.precio = precio;
		this.unidadesvendidas = unidadesvendidas;
		this.importe = importe;
		this.estado = estado;
	}
	public Producto() {

	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getUnidadesvendidas() {
		return unidadesvendidas;
	}
	public void setUnidadesvendidas(int unidadesvendidas) {
		this.unidadesvendidas = unidadesvendidas;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
