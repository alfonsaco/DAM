package ACTIVIDAD7;

/**
 * Clase Main para ejecutar operaciones básicas en una cuenta bancaria.
 * Incluye un ejemplo de uso de la clase CCuenta.
 */
public class Main {

    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        CCuenta miCuenta;
        double saldoActual;

        miCuenta = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);
        try {
            miCuenta.retirar(2300);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Fallo al retirar");
        }

        try {
            System.out.println("Ingreso en cuenta");
            miCuenta.ingresar(-1695);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Fallo al ingresar");
        }
        saldoActual = miCuenta.estado();
        System.out.println("El saldo actual es " + saldoActual);
        System.out.println();
        
        
        //Casos de prueba para verificar la función ingresar
        //CASO DE PRUEBA VÁLIDO
        pruebaIngreso("Arturo", "1234-5678-90-123456789", 1000, 500);
        //CASO DE PRUEBA NO VÁLIDO
        pruebaIngreso("Antonio", "1234-5678-90-123456789", 1000, -200);
        
        
        
        //Casos de prueba para verificar la función retirar
        //CASO DE PRUEBA VÁLIDO
        pruebaRetiro("Paco Pérez", "1234-5678-90-123456789", 1000, 0);
        //CASO DE PRUEBA NO VÁLIDO
        pruebaRetiro("Manolo Gómez", "1234-5678-90-123456789", 1000, -200);
       
        
        //Caso de prueba para ingresar y retirar al mismo tiempo
        //CASO DE PRUEBA VÁLIDO
        ingresarYRetirar("Pepa", "1234-5678-90-123456789", 1000, 500, 200);
        //CASO DE PRUEBA NO VÁLIDO
        ingresarYRetirar("Estefanía", "1234-5678-90-123456789", 1200, 0,  1700);

    }
    public static void pruebaRetiro(String nombreTitular, String numeroCuenta, double saldoInicial, double cantidadRetirar) {
        CCuenta cuenta = new CCuenta(nombreTitular, numeroCuenta, saldoInicial, 0);
        
        System.out.println("\nSaldo inicial: " + saldoInicial);
        System.out.println("Cantidad a retirar: " + cantidadRetirar);
        
        try {
            cuenta.retirar(cantidadRetirar);
            double saldoDespuesRetiro = cuenta.estado();
            System.out.println("Saldo después del retiro: " + saldoDespuesRetiro);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void pruebaIngreso(String nombreTitular, String numeroCuenta, double saldoInicial, double cantidadIngresar) {
        CCuenta cuenta = new CCuenta(nombreTitular, numeroCuenta, saldoInicial, 0);
        
        System.out.println("\nSaldo inicial: " + saldoInicial);
        System.out.println("Cantidad a ingresar: " + cantidadIngresar);
        
        try {
            cuenta.ingresar(cantidadIngresar);
            double saldoDespuesIngreso = cuenta.estado();
            System.out.println("Saldo después del ingreso: " + saldoDespuesIngreso);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void ingresarYRetirar(String nombreTitular, String numeroCuenta, double saldoInicial, double cantidadIngresar, double cantidadRetirar) {
        CCuenta cuenta = new CCuenta(nombreTitular, numeroCuenta, saldoInicial, 0);

        System.out.println("\nSaldo inicial: " + saldoInicial);
        System.out.println("Cantidad a ingresar: " + cantidadIngresar);
        System.out.println("Cantidad a retirar: " + cantidadRetirar);

        try {
            cuenta.ingresar(cantidadIngresar);
            cuenta.retirar(cantidadRetirar);

            double saldoDespuesOperaciones = cuenta.estado();
            System.out.println("Saldo después de ingresar y retirar: " + saldoDespuesOperaciones);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
