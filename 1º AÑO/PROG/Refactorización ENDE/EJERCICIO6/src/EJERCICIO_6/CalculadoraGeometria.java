package EJERCICIO_6;
/**
 * Clase para realizar cálculos geométricos, de área y volumen
 * 
 * @author alfonso
 * @version 1.0
 */
public class CalculadoraGeometria {
	/**
	 * método para calcular el área del circulo
	 * 
	 * @param r
	 * @return	resultado, de tipo double
	 */
    public static double areaCirculo(double r) {
        double resultado = Math.PI * r * r;
        return resultado;
    }
    /**
     * Método para calcular el área del cuadrado
     * 
     * @param lLado
     * @return	devuelve lado,de tipo double
     */
    public static double areaCuadrado(double lado) {
        return lado * lado;
    }
    /**
     * Método para calcular el volumen del cuadrado
     * 
     * @param lado
     * @return	resultado, de tipo double
     */
    public static double volumenCuadrado(double lado) {
        double resultado = lado * lado * lado;
        return resultado;
    }
}

