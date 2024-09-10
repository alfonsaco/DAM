package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_AreaRectangulo {

	public static void main(String[] args) {
		// Calcular el área de un rectángulo
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame la base de un cuadrado");
		double b=sc.nextDouble();
		System.out.println("Dame la altura de un cuadrado");
		double h=sc.nextDouble();
		areaRectangulo(b,h);

	}

	private static void areaRectangulo(double b, double h) {
		double area=b*h;
		System.out.println("El área del rectángulo es "+area);
		
	}

}
