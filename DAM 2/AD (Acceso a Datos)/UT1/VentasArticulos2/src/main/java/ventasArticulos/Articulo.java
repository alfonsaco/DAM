package ventasArticulos;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"artic","ventas"})
public class Articulo {
	private Artic artic;
	private ArrayList<Venta> ventas;
	
	public Articulo(Artic artic, ArrayList<Venta> ventas) {
		super();
		this.artic = artic;
		this.ventas = ventas;
	}
	public Articulo() {

	}
	@XmlElement(name = "artic")
	public Artic getArtic() {
		return artic;
	}
	public void setArtic(Artic artic) {
		this.artic = artic;
	}
	@XmlElementWrapper(name = "ventas")
	@XmlElement(name = "venta")
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	
	
}
