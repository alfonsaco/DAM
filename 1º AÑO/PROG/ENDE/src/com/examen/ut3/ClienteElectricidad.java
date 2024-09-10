package com.examen.ut3;

/**
 * Representa un cliente de electricidad con propiedades para identificación,
 * bono social, consumo, antigüedad y el total de la factura.
 */
public class ClienteElectricidad {
    private String abonado;
    private boolean bonoSocial;
    private double consumo;
    private int antiguedad;
    private double totalFactura;

    public double getTotalFactura() {
		return totalFactura;
	}


	/**
     * Constructor para crear una instancia de ClienteElectricidad.
     * 
     * @param abonado Identificación del abonado.
     * @param bonoSocial Indica si el cliente tiene asignado el bono social.
     * @param consumo Consumo en kW.
     * @param antiguedad Años de antigüedad en la compañía.
     */
    public ClienteElectricidad(String abonado, boolean bonoSocial, double consumo, int antiguedad) {
        this.abonado = abonado;
        this.bonoSocial = bonoSocial;
        this.consumo = consumo;
        this.antiguedad = antiguedad;
        this.totalFactura = 0.0;
    }

    // Getters y Setters
    public String getAbonado() {
		return abonado;
	}
	public void setAbonado(String abonado) {
		this.abonado = abonado;
	}
	public boolean isBonoSocial() {
		return bonoSocial;
	}
	public void setBonoSocial(boolean bonoSocial) {
		this.bonoSocial = bonoSocial;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public void setTotalFactura(double totalFactura) {
		this.totalFactura = totalFactura;
	}
	
    /**
     * Calcula el total de la factura considerando el bono social, el consumo
     * y la antigüedad del cliente.
     */
    public void calcularTotalFactura() {
        if (bonoSocial) {
            totalFactura = 0;
            return;
        }

        double precioKw = 0.2575; // Precio por defecto
        if (consumo >= 100 && consumo <= 250) {
            precioKw = 0.2050;
        } else if (consumo > 250) {
            precioKw = 0.1955;
        }

        double subtotal = consumo * precioKw;
        double descuento = 0.0; // Descuento por defecto

        if (antiguedad >= 5 && antiguedad <= 10) {
            descuento = 2.0; // 2% de descuento
        } else if (antiguedad > 10) {
            descuento = 5.0; // 5% de descuento
        }

        totalFactura = subtotal - (subtotal * descuento / 100);
    }


    // Métodos getter y setter omitidos por brevedad
}

