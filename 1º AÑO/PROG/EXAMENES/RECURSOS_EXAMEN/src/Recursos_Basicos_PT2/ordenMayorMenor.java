package Recursos_Basicos_PT2;

import java.util.Scanner;

public class ordenMayorMenor {

	public static void main(String[] args) {
		// Pedir tres números y mostrarlos ordenados de mayor a menor
		Scanner sc=new Scanner(System.in);
		System.out.println("Intoduzca el primer número: ");
		int n1=sc.nextInt();
		System.out.println("Intoduzca el segundo número: ");
		int n2=sc.nextInt();
		System.out.println("Intoduzca el tercer número: ");
		int n3=sc.nextInt();
		ordenarMayorMenor(n1,n2,n3);
		sc.close();
	}

	private static void ordenarMayorMenor(int n1, int n2, int n3) {
		if (n1>=n2 && n1>=n3) {
            if (n2>=n3) 
                System.out.println(n1+", "+n2 + ", "+n3);
            else 
                System.out.println(n1+", "+n3+", "+n2);
            
        } else if (n2>=n1 && n2>=n3) {
            if (n1>=n3)
                System.out.println(n2+", "+n1+", "+n3);
            else 
                System.out.println(n2+", "+n3 + ", "+n1);
        } else {
            if (n1>=n2)
                System.out.println(n3+", "+n1+", "+n2);
            else 
                System.out.println(n3+", "+n2+", "+n1);
        }
		
	}

}
