package Aparcamiento;

public class Cliente extends Persona {
	private String horaLlegada;
	private int diasEstancia;
	private Vehiculo vehiculo;
	
	// Constructor
	public Cliente(String dni, String nombre, String apellidos, int edad, String direccion, String email,
			String horaLlegada, int diasEstancia, Vehiculo vehiculo) {
		super(dni, nombre, apellidos, edad, direccion, email);
		this.horaLlegada = horaLlegada;
		this.diasEstancia = diasEstancia;
		this.vehiculo = vehiculo;
	}
	public Cliente() {
		super();
		this.horaLlegada = "";
		this.diasEstancia = 0;
		this.vehiculo =null;
	}
	public Cliente(String dni, String nombre, String apellidos, int edad, String direccion, String email,
			String horaLlegada, int diasEstancia) {
		super(dni, nombre, apellidos, edad, direccion, email);
		this.horaLlegada = horaLlegada;
		this.diasEstancia = diasEstancia;
		this.vehiculo =null;
	}
	
	// Getters y Setters
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public int getDiasEstancia() {
		return diasEstancia;
	}
	public void setDiasEstancia(int diasEstancia) {
		this.diasEstancia = diasEstancia;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
	
	
}
