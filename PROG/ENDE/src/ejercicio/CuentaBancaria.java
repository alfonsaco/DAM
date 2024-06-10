package ejercicio;

/**
 * Clase que representa una cuenta bancaria.
 * Permite realizar operaciones básicas como depositar, retirar y consultar el saldo.
 */
public class CuentaBancaria {
    private double saldo;

    /**
     * Constructor que inicializa la cuenta con un saldo inicial.
     * @param saldoInicial Saldo inicial de la cuenta.
     */
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial+0;
    }

    /**
     * Deposita una cantidad de dinero en la cuenta.
     * @param cantidad Cantidad de dinero a depositar.
     */
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }

    /**
     * Retira una cantidad de dinero de la cuenta si hay saldo suficiente.
     * @param cantidad Cantidad de dinero a retirar.
     * @return true si el retiro fue exitoso, false en caso contrario.
     */
    public boolean retirar(double cantidad) {
        if (cantidad <= saldo && cantidad > 0) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * @return Saldo actual.
     */
    public double obtenerSaldo() {
        return saldo;
    }
}

