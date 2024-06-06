package Ejercicio5;
/**
 * Esta clase sirve para imprimir todos los números del 1 al 100, sustituyendo los multiplos de 3 por fizz,
 * los de 5 por buzz, y los de 3 y 5 por fizzbuzz
 * 
 * @author alfonso
 * @version 1.0
 */
public class AlfonsoRinconEjercicio5 {
	public static void main(String[] args) {
		mostrarNumeros();
	}
	/**
	 * Metodo vacío con un for para imprimir el número, fizz, buzz o fizzbuzz
	 */
	private static void mostrarNumeros() {
		for(int i=1; i<=100; i++) {
			if(i%3==0 && i%5==0) {
				System.out.println("fizzbuzz");
			}else if(i%3==0){
				System.out.println("fizz");
			}else if(i%5==0) {
				System.out.println("buzz");
			}else {
				System.out.println(i);
			}
		}
	}
}