package cursosalumnosVer2;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"nombre", "lista"})
public class Curso {

	private String nombre;
	private ArrayList<Alumno> lista;
	
	
	public Curso() {}
	public Curso(String nombre, ArrayList<Alumno> lista) {
		super();
		this.nombre = nombre;
		this.lista = lista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	@XmlElementWrapper(name = "alumnos")  
	@XmlElement(name = "alumno")
	public ArrayList<Alumno> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Alumno> lista) {
		this.lista = lista;
	}
	
	
	
}