package XMLalumnos;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListaAlumnos")
public class ListaAlumnos {
	private ArrayList<Alumno> alumnos;

	public ListaAlumnos(ArrayList<Alumno> alumnos) {
		super();
		this.alumnos = alumnos;
	}
	public ListaAlumnos() {

	}
	
	@XmlElement(name = "Alum")
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
