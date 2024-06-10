package proveedoresPiezas;

public class Proveedor {
	private int codProveedor;
	private String nombreProveedor;
	private String localidad;
	
	// Constructor
	public Proveedor(int codProveedor, String nombreProveedor, String localidad) {
		this.codProveedor = codProveedor;
		this.nombreProveedor = nombreProveedor;
		this.localidad = localidad;
	}
	public Proveedor() {
		this.codProveedor = 0;
		this.nombreProveedor = "";
		this.localidad = "";
	}
	
	// Getters y Setters
	public int getCodProveedor() {
		return codProveedor;
	}
	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	// toString
	@Override
	public String toString() {
		return "Proveedor [codProveedor=" + codProveedor + ", nombreProveedor=" + nombreProveedor + ", localidad="
				+ localidad + "]";
	}
	
	
	
	
}
