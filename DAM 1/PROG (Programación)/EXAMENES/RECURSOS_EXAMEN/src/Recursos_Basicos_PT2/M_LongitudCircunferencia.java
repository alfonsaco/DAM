package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_LongitudCircunferencia {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame el radio del círculo: ");
		double radio=sc.nextDouble();
		calcularLongitudCircunferencia(radio);
		sc.close();
	}

	private static void calcularLongitudCircunferencia(double radio) {
		double longitud=2*Math.PI*radio;
    	if (longitud==0) 
    		System.out.println("Si el radio de la circunferencia es 0, la circunferencia no tiene longitud");
    	else 
    		System.out.println("La longitud de la circunferencia con radio "+radio+" es: "+longitud);
	}

}
