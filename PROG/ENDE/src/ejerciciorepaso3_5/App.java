package ejerciciorepaso3_5;

public class App {
	public static void main(String[] args) {
		CalculadoraDescuentos app=new CalculadoraDescuentos();
		/**
		 * PRUEBAS DE CUBRIMIENTO
		 */
		System.out.println("************************ APARTADO 1 ************************");
		System.out.println("Pruebas de cubrimiento del método calcularDescuento()");
		System.out.println("CASO 1: "+app.calcularDescuento(120,1));
		System.out.println(app.calcularDescuento(550, 1));
		System.out.println(app.calcularDescuento(300, 2));
		System.out.println(app.calcularDescuento(400, 3));
		/**
		 * PRUEBAS DE CONDICIONES
		 */
		System.out.println("\n************************ APARTADO 2 ************************");
		System.out.println("Pruebas de condiciones del método calcularDescuento()");
		System.out.println("CASO 1: "+app.calcularDescuento(120,1));
		System.out.println(app.calcularDescuento(80, 1));
		System.out.println(app.calcularDescuento(550, 1));
		System.out.println(app.calcularDescuento(100, 2));
		System.out.println(app.calcularDescuento(300, 2));
		System.out.println(app.calcularDescuento(400, 3));
		/**
		 * 
		 */
	}
}
