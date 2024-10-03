package XMLviajes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListaViajes")
public class ListaViajes {
	private ArrayList<Viaje> viajes;

	public ListaViajes(ArrayList<Viaje> viajes) {
		super();
		this.viajes = viajes;
	}
	public ListaViajes() {

	}
	
	@XmlElement(name = "Viaje")
	public ArrayList<Viaje> getViajes() {
		return viajes;
	}
	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
}
