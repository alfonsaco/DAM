package ejercicioVentas;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ventasarticulos")
public class ventasArticulos {
	private ArrayList<Venta> ventas;
	private Articulo articulo;
	
	// Constructor
	public ventasArticulos(ArrayList<Venta> ventas, Articulo articulo) {
		super();
		this.ventas = ventas;
		this.articulo = articulo;
	}
	public ventasArticulos() {

	}
	
	@XmlElementWrapper(name = "ventas")
	@XmlElement(name = "venta")
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
}
