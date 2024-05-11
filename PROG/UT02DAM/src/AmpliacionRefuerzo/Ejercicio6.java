package AmpliacionRefuerzo;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame 2 números: ");
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		
		int d=n1%n2;
		System.out.println("El resto es "+d);

	}

}
