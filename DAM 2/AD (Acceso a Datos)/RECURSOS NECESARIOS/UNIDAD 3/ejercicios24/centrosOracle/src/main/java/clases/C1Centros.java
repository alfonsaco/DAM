package clases;
// Generated 13 nov 2024, 17:36:47 by Hibernate Tools 6.5.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * C1Centros generated by hbm2java
 */
public class C1Centros implements java.io.Serializable {

	private short codCentro;
	private String nomCentro;
	private Short director;
	private String direccion;
	private String localidad;
	private String provincia;
	private Set c1Profesoreses = new HashSet(0);

	public C1Centros() {
	}

	public C1Centros(short codCentro) {
		this.codCentro = codCentro;
	}

	public C1Centros(short codCentro, String nomCentro, Short director, String direccion, String localidad,
			String provincia, Set c1Profesoreses) {
		this.codCentro = codCentro;
		this.nomCentro = nomCentro;
		this.director = director;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.c1Profesoreses = c1Profesoreses;
	}

	public short getCodCentro() {
		return this.codCentro;
	}

	public void setCodCentro(short codCentro) {
		this.codCentro = codCentro;
	}

	public String getNomCentro() {
		return this.nomCentro;
	}

	public void setNomCentro(String nomCentro) {
		this.nomCentro = nomCentro;
	}

	public Short getDirector() {
		return this.director;
	}

	public void setDirector(Short director) {
		this.director = director;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Set getC1Profesoreses() {
		return this.c1Profesoreses;
	}

	public void setC1Profesoreses(Set c1Profesoreses) {
		this.c1Profesoreses = c1Profesoreses;
	}

}