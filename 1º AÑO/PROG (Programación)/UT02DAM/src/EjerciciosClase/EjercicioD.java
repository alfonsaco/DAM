package EjerciciosClase;

import java.util.Scanner;

public class EjercicioD {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//EJERCICIOS DE CLASE DOCUMENTO "Ejercicio en clase UT2". Hecho por mí
		System.out.println("Dame un número (-1 para cerrar el programa): ");
		int i=sc.nextInt();
		int primerN=i;
		int suma=0;
		int sumaI=0;
		
		do {
			if(primerN%3==0) {
				if(i<10) {
					suma+=i;
				}
			}else {
				if(i%2!=0 && i>6) {
					sumaI+=i;
				}
			}
			System.out.println("Dame un número (-1 para cerrar el programa): ");
            i = sc.nextInt();
		} while(i!=-1);
		
		if(primerN%3==0) {
			System.out.println("La suma de los menores de 10 es "+suma);
		}else {
			System.out.println("La suma de los impares mayores que 6 es "+sumaI);
		}
			
		

	}

}
