package ejercicio;

/**
 * Clase principal para probar las funcionalidades de la clase CuentaBancaria.
 * Crea una cuenta bancaria, realiza operaciones de depósito y retiro, y muestra el saldo.
 */
public class CuentaBancariaPrueba {
    public static void main(String[] args) {
        // Creación de una cuenta bancaria con un saldo inicial de 1000
        CuentaBancaria miCuenta = new CuentaBancaria(1000.0);
        System.out.println("Saldo inicial: " + miCuenta.obtenerSaldo());

        // Realizar un depósito
        miCuenta.depositar(500.0);
        System.out.println("Después de depositar 500: " + miCuenta.obtenerSaldo());

        // Intentar retirar una cantidad
        if (miCuenta.retirar(200.0)) {
            System.out.println("Después de retirar 200: " + miCuenta.obtenerSaldo());
        } else {
            System.out.println("Retiro fallido. Saldo insuficiente.");
        }

        // Intentar retirar una cantidad que supera el saldo
        if (miCuenta.retirar(2000.0)) {
            System.out.println("Después de retirar 2000: " + miCuenta.obtenerSaldo());
        } else {
            System.out.println("Retiro fallido. Saldo insuficiente.");
        }

        // Mostrar el saldo final
        System.out.println("Saldo final: " + miCuenta.obtenerSaldo());
    }
}

