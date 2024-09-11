package Actividades_Repaso;

import java.util.Scanner;

public class Ej2_NegativoOPositivo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=2;
		
		do {
			System.out.println("Dame un número, y te diré si es negativo o positivo");
			n=sc.nextInt();
			
			if(n>0) {
				System.out.println(n+" es positivo");
			}else if(n<0){
				System.out.println(n+" es negativo");
			} else {
				System.out.println("Se cerró el programa");
			}
		}while(n!=0);

	}

}
