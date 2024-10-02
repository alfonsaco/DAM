package ventasArticulos;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ventasarticulos")
public class ventasArticulos {
	private ArrayList<Articulo> articulos;

	public ventasArticulos(ArrayList<Articulo> articulos) {
		super();
		this.articulos = articulos;
	}
	public ventasArticulos() {

	}
	
	@XmlElement(name = "articulo")
	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	
	
}
