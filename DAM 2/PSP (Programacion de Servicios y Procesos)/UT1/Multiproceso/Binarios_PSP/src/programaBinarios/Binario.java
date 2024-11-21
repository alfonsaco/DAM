package programaBinarios;

import java.util.Scanner;

public class Binario {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Dame un numero: ");
		int binario=sc.nextInt();
		
		int total=binario;
		
		// Variables para crear la cadena
		String numeroParaCadena="";
		String cadenaBinario="";
	
		while(total != 0 && total != 1) {
			numeroParaCadena=String.valueOf(total%2);
			total/=2;
			cadenaBinario=(numeroParaCadena+cadenaBinario);
		}
		
		// Para sumar el primer dígito, en caso de que este sea 1
		if(total==1) {
			cadenaBinario=(total+cadenaBinario);			
		}

		System.out.printf("%d en binario: %s",binario, cadenaBinario);
	}
}

