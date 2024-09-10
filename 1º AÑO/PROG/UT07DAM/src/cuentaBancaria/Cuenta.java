package cuentaBancaria;

public class Cuenta {
	private String iban;
	private String cuenta;
	private String codigoTitular;
	private String codigoAutorizado;
	private double saldo;
	
	// Constructor
	public Cuenta(String iban, String cuenta, String codigoTitular, String codigoAutorizado, double saldo) {
		this.iban = iban;
		this.cuenta = cuenta;
		this.codigoTitular = codigoTitular;
		this.codigoAutorizado = codigoAutorizado;
		this.saldo = saldo;
	}
	public Cuenta() {
		this.iban = "";
		this.cuenta = "";
		this.codigoTitular = "";
		this.codigoAutorizado = "";
		this.saldo = 0;
	}
	
	// Getters y Setters
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCodigoTitular() {
		return codigoTitular;
	}
	public void setCodigoTitular(String codigoTitular) {
		this.codigoTitular = codigoTitular;
	}
	public String getCodigoAutorizado() {
		return codigoAutorizado;
	}
	public void setCodigoAutorizado(String codigoAutorizado) {
		this.codigoAutorizado = codigoAutorizado;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// Método retirar saldo
	public double retirarSaldo(double cantidad) {
		if(cantidad > this.saldo) {
			System.out.println("No dispone de saldo suficiente");
			return 0;
		} else {
			setSaldo(this.saldo-cantidad);
			return cantidad;
		}
	}
	
	// Método ingresar
	public void ingresar(double cantidad) {
		setSaldo(this.saldo+cantidad);
		System.out.println("INGRESADO: "+cantidad+"€\rTOTAL: "+this.getSaldo()+"€");
	}
	
	// toString
	@Override
	public String toString() {
		return "IBAN: "+iban+"\rCuenta: "+cuenta+"\rCodigo titular: "+codigoTitular+"\rCodigo autorizado: "+codigoAutorizado+"\rSaldo: "+saldo+"€";
	}
	
	// Prueba unitaria
	public static void main(String[] args) {
		Cuenta c=new Cuenta("ES45-34543-53453","Nomina","B123","A23",234);
		System.out.println(c);
		System.out.println();
		c.ingresar(1000);
		c.retirarSaldo(200);
		System.out.println(c.saldo);
		c.retirarSaldo(10000);
		System.out.println(c.saldo);
	}
}

