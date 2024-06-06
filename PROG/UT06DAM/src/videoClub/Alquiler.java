package videoClub;

public class Alquiler {
	private int tiempo;
	private DVD dvd;
	
	// Constructor
	public Alquiler(int tiempo, DVD dvd) {
		this.tiempo = tiempo;
		this.dvd = dvd;
	}
	public Alquiler() {
		this.tiempo = 0;
		this.dvd=new DVD();
	}
	
	// Getters y Setters
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public DVD getDvd() {
		return dvd;
	}
	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}
	
	
	
	
}
