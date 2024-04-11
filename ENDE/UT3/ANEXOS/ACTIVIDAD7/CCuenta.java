package ACTIVIDAD7;

/**
 * Clase CCuenta para representar una cuenta bancaria.
 * Permite la gestión de operaciones básicas como depósitos y retiros, así como consulta de saldo.
 */
public class CCuenta {

    // Atributos de la clase CCuenta
    private String nombre;       // Nombre del titular de la cuenta
    private String cuenta;       // Número de cuenta
    private double saldo;        // Saldo actual de la cuenta
    private double tipoInterés;  // Tipo de interés aplicado a la cuenta (no utilizado actualmente)

    /**
     * Constructor por defecto de CCuenta.
     */
    public CCuenta() {
    }

    /**
     * Constructor de CCuenta con parámetros para inicializar la cuenta.
     *
     * @param nom  Nombre del titular de la cuenta
     * @param cue  Número de la cuenta
     * @param sal  Saldo inicial de la cuenta
     * @param tipo Tipo de interés de la cuenta (actualmente no se utiliza)
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        // tipoInterés no se asigna en el constructor, esto podría ser un error
    }

    /**
     * Asigna el nombre del titular de la cuenta.
     *
     * @param nom Nombre del titular
     */
    public void asignarNombre(String nom) {
        nombre = nom;
    }

    /**
     * Obtiene el nombre del titular de la cuenta.
     *
     * @return Nombre del titular
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Retorna el saldo actual de la cuenta.
     *
     * @return Saldo actual
     */
    public double estado() {
        return saldo;
    }

    /**
     * Permite ingresar una cantidad a la cuenta. Incrementa el saldo.
     *
     * @param cantidad Cantidad a ingresar. Debe ser un valor positivo.
     * @throws Exception Si la cantidad es negativa, lanza una excepción.
     */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        saldo += cantidad;
    }

    /**
     * Permite retirar una cantidad de la cuenta. Disminuye el saldo.
     *
     * @param cantidad Cantidad a retirar. Debe ser un valor positivo y menor o igual al saldo.
     * @throws Exception Si la cantidad es negativa o mayor que el saldo, lanza una excepción.
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (estado() < cantidad) {
            throw new Exception("No hay suficiente saldo");
        }
        saldo -= cantidad;
    }

    /**
     * Obtiene el número de la cuenta.
     *
     * @return Número de la cuenta
     */
    public String obtenerCuenta() {
        return cuenta;
    }
}
