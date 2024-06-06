package videoClub;

public class Cliente {
	private String nombre;
	private Alquiler[] alquileres;
	
	// Constructor
	public Cliente(String nombre, Alquiler[] alquileres) {
		this.nombre = nombre;
		this.alquileres =new Alquiler[5];
	}
	public Cliente() {
		this.nombre = "";
		this.alquileres =new Alquiler[5];
	}
	
	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Alquiler[] getAlquileres() {
		return alquileres;
	}
	public void setAlquileres(Alquiler[] alquileres) {
		this.alquileres = alquileres;
	}
	
	public void nuevoAlquiler() {
		
	}
	
	public void informe() {
		System.out.println("Informe para "+this.getNombre());
		System.out.println();
	}
}
