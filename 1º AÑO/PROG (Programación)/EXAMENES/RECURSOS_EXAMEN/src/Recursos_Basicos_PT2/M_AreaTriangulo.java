package Recursos_Basicos_PT2;

import java.util.Scanner;

public class M_AreaTriangulo {

	public static void main(String[] args) {
		// Calcular area triángulo
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame la base del triángulo");
		double base=sc.nextDouble();
		System.out.println("Dame la altura del triángulo");
		double altura=sc.nextDouble();
		areaTriangulo(base,altura);
		sc.close();
	}

	private static void areaTriangulo(double base, double altura) {
		double area=(base*altura)/2;
		System.out.println("El área del triángulo es "+area);
	}

}
