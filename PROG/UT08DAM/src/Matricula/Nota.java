package Matricula;

public class Nota {
	private int codigo_prof;
	private String nombre;
	private int codigo_alumno;
	private int nota;
	
	// Constructor
	public Nota(int codigo_prof, String nombre, int codigo_alumno, int nota) {
		super();
		this.codigo_prof = codigo_prof;
		this.nombre = nombre;
		this.codigo_alumno = codigo_alumno;
		this.nota = nota;
	}
	
	// Getters y Setters
	public int getCodigo_prof() {
		return codigo_prof;
	}
	public void setCodigo_prof(int codigo_prof) {
		this.codigo_prof = codigo_prof;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo_alumno() {
		return codigo_alumno;
	}
	public void setCodigo_alumno(int codigo_alumno) {
		this.codigo_alumno = codigo_alumno;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return   nombre +":" + nota ;
	}
	

}
