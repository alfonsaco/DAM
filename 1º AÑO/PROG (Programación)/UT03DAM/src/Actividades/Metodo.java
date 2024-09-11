package Actividades;

public class Metodo {

	public static void main(String[] args) {
		metodo1();

	}

	private static void metodo1() {
		// TODO Auto-generated method stub
		metodo2();
		System.out.println("Hola! Soy el método 1");
	}

	private static void metodo2() {
		metodo3();
		System.out.println("Hola! Soy el método 2");
		
	}

	private static void metodo3() {
		System.out.println("Hola! Soy el método 3");
		
	}

}
