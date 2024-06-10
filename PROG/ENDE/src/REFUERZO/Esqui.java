package REFUERZO;

import java.util.Scanner;

public class Esqui {
	public static void main(String[] args) {
		String deporte=definirDeporte();
		System.out.println("El deporte es "+deporte);
	}

	/**
	 * Método con un do while, para definir, según la temperatura, que deporte nos toca
	 * 
	 * @return deporte	Devuelve el deporte
	 */
	private static String definirDeporte() {
		Scanner sc=new Scanner(System.in);
		double temp;
		String deporte="";
		do {
			System.out.print("Dime una temperatura entre -10 y 40: ");
			temp=sc.nextDouble();
		
			if(temp>-10 && temp<=0) {
				deporte="Esquí";
			}else if(temp>0 && temp<=10) {
				deporte="Atletismo";
			}else if(temp>10 && temp<=20) {
				deporte="Fútbol";
			}else if(temp>20 && temp<=30){
				deporte="Balonmano";
			}else if (temp>30 && temp<40){
				deporte="Badminton";
			}else {
				System.out.println("INVALIDO");
			}
		} while (temp<-10 || temp>40);
		sc.close();
		return deporte;
	}
}
