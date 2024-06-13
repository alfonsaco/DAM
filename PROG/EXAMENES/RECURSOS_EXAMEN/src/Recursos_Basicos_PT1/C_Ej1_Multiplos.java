package Recursos_Basicos_PT1;

import java.util.Scanner;

public class C_Ej1_Multiplos {

	public static void main(String[] args) {
//		Dados 10 números introducidos por teclado muestra la suma de los múltiplos de 3 que 
//		sean mayores que 6.
//		También indica qué número de esos múltiplos de 3 que son mayores que 6 es el mayor.
		Scanner sc=new Scanner(System.in);
		int n=0;
		int contador=0;
		int suma=0;
		int multiploMayor=0;
		System.out.println("Dame 10 numeros");
		
		do {
			System.out.println("Dame un número");
			n=sc.nextInt();
			contador++;
			
			if(n%3==0 && n>6) {
				suma+=n;
				if(n>multiploMayor) {
					multiploMayor=n;
				}
			}
		}while(contador!=10);
		System.out.println("La suma de los múltiplos de 3 mayores que 6 es "+suma);
		
		if(suma>0) {
			System.out.println("El múltiplo mayor es "+multiploMayor);
		}else {
			System.out.println("No hay ningún múltiplo de 3");
		}
		

	}

}
