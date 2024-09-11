package actividadLibro;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private int numPags;
	
	// Constructor
	public Libro(String isbn, String titulo, String autor, int numPags) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numPags = numPags;
	}
	public Libro() {
		this.isbn = "";
		this.titulo = "";
		this.autor = "";
		this.numPags = 0;
	}
	
	// Getters y Setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumPags() {
		return numPags;
	}
	public void setNumPags(int numPags) {
		this.numPags = numPags;
	}
	
	// toString
	@Override
	public String toString() {
		return "El libro "+titulo+" con ISBN \""+isbn+"\" creado por el autor "+autor+" tiene "+numPags+" páginas";
	}
}
