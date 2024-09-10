package Strings;

public class A_Ej2_Invertido {

	public static void main(String[] args) {
//		Crea un programa Java que defina una cadena de caracteres y los muestre con la posición
//		de sus caracteres invertida
		String frase="Hola Mundo";
		
		String resultado="";
		for(int i=frase.length()-1; i>=0; i--) {
			resultado+=frase.charAt(i);
		}
		
		System.out.println(resultado);
	}

}
	
//	resultado+=frase.charAt(i);: lo que hace esto, es que como i valor lo mismo que frase, en
//							este caso 10, pues le da a resultado la letra que hay en cada una
//							de esas posiciones hasta formar la palabra entera, que es cuando
//							10 llega a 0.
//	int i=frase.length()-1: debemos poner -1, ya que aunque Hola Mundo vale 10, el último
//							carácter, ene ste caso la "o", se representa como 9 en el 
//							String. Osea son 10 caracteres, pero cada una con un valor de -1