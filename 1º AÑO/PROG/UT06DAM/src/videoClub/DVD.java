package videoClub;

public class DVD {
	private String titulo;
	private int tipo;
	// Constantes
	public static final int INFANTIL=2;
	public static final int NORMAL=0;
	public static final int NOVEDAD=1;
	
	// Constructor
	public DVD(String titulo, int tipo) {
		this.titulo = titulo;
		this.tipo = tipo;
	}
	public DVD() {
		this.titulo = "";
		this.tipo = DVD.NORMAL;
	}
	
	// Getters y Setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	@Override
	public String toString() {
		return "DVD [titulo=" + titulo + ", tipo=" + tipo + "]";
	}
	
	public static void main(String[] args) {
		DVD div=new DVD("Shrek", DVD.NORMAL);
		System.out.println(div);
	}
	
}
