/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciorepaso3_2;

/**
 *
 * @author luism
 */
public class EjercicioRepaso3_2 {

    //La clase devolverá los datos de un préstamo hipotecario

    private String titular_prestamo;
    private double cantidad_solicitada;
    private double ingresos_mensuales;
    private double cantidad_ofertada;
    private double interes_prestamo;

    public EjercicioRepaso3_2() {
    }

    public EjercicioRepaso3_2(String titular_prestamo, double cantidad_solicitada, double ingresos_mensuales) {
        this.titular_prestamo = titular_prestamo;
        this.cantidad_solicitada = cantidad_solicitada;
        this.ingresos_mensuales = ingresos_mensuales;
    }

    public String getTitular_prestamo() {
        return titular_prestamo;
    }

    public void setTitular_prestamo(String titular_prestamo) {
        this.titular_prestamo = titular_prestamo;
    }

    public double getCantidad_solicitada() {
        return cantidad_solicitada;
    }

    public void setCantidad_solicitada(double cantidad_solicitada) {
        this.cantidad_solicitada = cantidad_solicitada;
    }

    public double getIngresos_mensuales() {
        return ingresos_mensuales;
    }

    public void setIngresos_mensuales(double ingresos_mensuales) {
        this.ingresos_mensuales = ingresos_mensuales;
    }

    public double getCantidad_ofertada() {
        return cantidad_ofertada;
    }

    public void setCantidad_ofertada(double cantidad_ofertada) {
        this.cantidad_ofertada = cantidad_ofertada;
    }

    public double getInteres() {
        return interes_prestamo;
    }

    public void setInteres(double interes_prestamo) {
        this.interes_prestamo = interes_prestamo;
    }

    //Este método calculará la cantidad ofertada por la entidad para el préstamo solicitado
    public double calcular_cantidad_solicitada(double cantidad_solicitada, double ingresos) {

        double cantidad_calculada = 0;

        if (ingresos <= 0) {
            cantidad_calculada = 0;
        } else if (ingresos > 0 && ingresos <= 900) {
            if (cantidad_solicitada > 3000) {
                cantidad_calculada = 3000;
            } else {
                cantidad_calculada = cantidad_solicitada;
            }
        } else if (ingresos > 900 && ingresos < 1500) {
            if (cantidad_solicitada > 9000) {
                cantidad_calculada = 9000;
            } else {
                cantidad_calculada = cantidad_solicitada;
            }
        } else if (ingresos >= 1500) {
            if (cantidad_solicitada > 15000) {
                cantidad_calculada = 15000;
            } else {
                cantidad_calculada = cantidad_solicitada;
            }
        }
        return cantidad_calculada;
    }

    //Este método calculará el interés asociado al préstamo
    public double calcular_interes_prestamo(double cantidad_solicitada) {

        double interes_calculado = 0;
        double cantidad_intermedia = cantidad_solicitada;
        //int ciclos = ((int) (cantidad_solicitada)) + 1;

        do {
            interes_calculado += 1.5;
            cantidad_intermedia -= 1000;
        } while (cantidad_intermedia >= 0);

        return interes_calculado;
    }

    
}
