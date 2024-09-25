package Examen;

public class Clase {
	private int dia;
	private String mes;
	private int año;
	private String codigoClase;
	private int hora;
	private int codigoAlumno;
	
	// Constructores
	public Clase(int dia, String mes, int año, String codigoClase, int hora, int codigoAlumno) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		this.codigoClase = codigoClase;
		this.hora = hora;
		this.codigoAlumno = codigoAlumno;
	}
	public Clase() {
		this.dia = 0;
		this.mes = "";
		this.año = 0;
		this.codigoClase = "";
		this.hora = 0;
		this.codigoAlumno = 0;
	}
	
	// Getters y Setters
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getCodigoClase() {
		return codigoClase;
	}
	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	
	// toString
	@Override
	public String toString() {
		return "Clase [dia=" + dia + ", mes=" + mes + ", año=" + año + ", codigoClase=" + codigoClase + ", hora=" + hora
				+ ", codigoAlumno=" + codigoAlumno + "]";
	}
}
