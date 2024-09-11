package Bucles;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
        int numeroSecreto=(int)(1+Math.random()*20);
        System.out.println("El número screto es: "+numeroSecreto);
        System.out.println("El número secreto es un valor entre 1 y 20.");

        int numeroIntroducido;
        int intentos=0;
        int maxIntentos=5;

        boolean acertado=false;
        while (intentos<maxIntentos && !acertado) {
            System.out.println("Introduce un número: ");
            numeroIntroducido=teclado.nextInt();
            intentos++;
            if (numeroIntroducido<numeroSecreto) 
                System.out.println("El número es mayor.");
            else if (numeroIntroducido>numeroSecreto) 
                System.out.println("El número es menor.");
            else 
                acertado=true;
            if (!acertado && intentos<maxIntentos) 
                System.out.println("Te quedan "+(maxIntentos-intentos)+" intentos.");
        }
        if (acertado) 
            System.out.println("¡Has acertado el número!");
        else 
            System.out.println("Has agotado tus intentos. El número secreto era: "+numeroSecreto);  
        teclado.close();

	}

}
