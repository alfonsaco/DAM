package XMLalumnos;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"asignatura","nota"})
public class Nota {
	private String asignatura;
	private float nota;
	
	public Nota(String asignatura, float nota) {
		super();
		this.asignatura = asignatura;
		this.nota = nota;
	}
	public Nota() {

	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	
}
