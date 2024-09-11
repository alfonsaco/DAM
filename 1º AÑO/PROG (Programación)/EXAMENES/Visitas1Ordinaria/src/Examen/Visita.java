package Examen;

public class Visita {
	private String codigo;
	private int horaVisita;
	private String idioma;
	private double precio;
	
	// Constructores
	public Visita(String codigo, int horaVisita, String idioma, double precio) {
		this.codigo = codigo;
		this.horaVisita = horaVisita;
		this.idioma = idioma;
		this.precio = precio;
	}
	public Visita() {
		this.codigo = "";
		this.horaVisita = 0;
		this.idioma = "";
		this.precio = 0;
	}
	
	// getters y Setters
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getHoraVisita() {
		return horaVisita;
	}
	public void setHoraVisita(int horaVisita) {
		this.horaVisita = horaVisita;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	// toString
	@Override
	public String toString() {
		return "Visita [codigo=" + codigo + ", horaVisita=" + horaVisita + ", idioma=" + idioma + ", precio=" + precio
				+ "]";
	}
	
}
