package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_AreaCuadrado {

	public static void main(String[] args) {
		// Calcular área de un cuadrado con métodos
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame el lado del cuadrado");
		double lado=sc.nextInt();
		areaCuadrado(lado);

	}

	private static void areaCuadrado(double lado) {
		double area=lado*lado;
		System.out.println("El area del cuadrado con lado "+lado+" es "+area);
	}

}
