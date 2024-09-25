package VariablesCondiciones;

import java.util.Scanner;

public class Ejericico4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame 2 números amigo: ");
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		
		if(n1==n2) {
			System.out.println(n1+" es igual que "+n2);
		} else {
			System.out.println("Son distintos");
		}

	}

}
