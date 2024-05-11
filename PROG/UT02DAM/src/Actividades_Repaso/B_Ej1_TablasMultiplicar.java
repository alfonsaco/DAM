package Actividades_Repaso;

public class B_Ej1_TablasMultiplicar {

	public static void main(String[] args) {
		// Diseña una aplicación que muestre las tablas de multiplicar del 1 al 10.
		
		for(int i=1; i<=10; i++) {
			System.out.println("Tabla del "+i+":");
				for(int o=1; o<=10; o++) {
					System.out.println(i+"x"+o+"="+(i*o));
			}
			System.out.println();
		}
		

	}

}
