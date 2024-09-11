package actividadLibro;

public class Main {
	public static void main(String[] args) {
		Libro libro1=new Libro("432432-4234342-42342424-432", "Diario de Greg", "Jeff Heffley", 105);
		Libro libro2=new Libro("4323-4324-565-465", "Crónicas de Narnia", "C.S Lewis", 500);
		
		// Ver cual tiene más páginas
		if(libro1.getNumPags()>libro2.getNumPags()) {
			System.out.println(libro1.getTitulo()+" tiene más páginas que "+libro2.getTitulo());
		}else {
			System.out.println(libro2.getTitulo()+" tiene más páginas que "+libro1.getTitulo());
		}
	}
}
