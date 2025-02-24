package Clases;
// Generated 11 dic 2024, 18:37:19 by Hibernate Tools 5.4.33.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Cursos generated by hbm2java
 */
public class Cursos implements java.io.Serializable {

	private int codCurso;
	private Centros centros;
	private String denominacion;
	private Integer costeMatricula;
	private Integer numAlumnos;
	private Set alumnoses = new HashSet(0);
	private Set asignaturases = new HashSet(0);

	public Cursos() {
	}

	public Cursos(int codCurso) {
		this.codCurso = codCurso;
	}

	public Cursos(int codCurso, Centros centros, String denominacion, Integer costeMatricula, Integer numAlumnos,
			Set alumnoses, Set asignaturases) {
		this.codCurso = codCurso;
		this.centros = centros;
		this.denominacion = denominacion;
		this.costeMatricula = costeMatricula;
		this.numAlumnos = numAlumnos;
		this.alumnoses = alumnoses;
		this.asignaturases = asignaturases;
	}

	public int getCodCurso() {
		return this.codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public Centros getCentros() {
		return this.centros;
	}

	public void setCentros(Centros centros) {
		this.centros = centros;
	}

	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public Integer getCosteMatricula() {
		return this.costeMatricula;
	}

	public void setCosteMatricula(Integer costeMatricula) {
		this.costeMatricula = costeMatricula;
	}

	public Integer getNumAlumnos() {
		return this.numAlumnos;
	}

	public void setNumAlumnos(Integer numAlumnos) {
		this.numAlumnos = numAlumnos;
	}

	public Set getAlumnoses() {
		return this.alumnoses;
	}

	public void setAlumnoses(Set alumnoses) {
		this.alumnoses = alumnoses;
	}

	public Set getAsignaturases() {
		return this.asignaturases;
	}

	public void setAsignaturases(Set asignaturases) {
		this.asignaturases = asignaturases;
	}

}
