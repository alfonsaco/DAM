package Strings;

public class A_Ej1_Mayuscula {

	public static void main(String[] args) {
//		 Realizar programa en el cúal se defina una cadena de caracteres y mostrar esa 
//		 cadena por
//		 pantalla con la primera letra en mayúsculas y las demás en minúsculas
		String frase="aprobemos programación";
		 // Convierte la primera letra a mayúscula y las demás a minúscula
        String resultado=frase.substring(0, 1).toUpperCase()+frase.substring(1,10).toLowerCase()+frase.substring(10,11).toUpperCase()+frase.substring(11).toLowerCase();       
        System.out.println(resultado);
    }
}

//frase.substring(0, 1): esto obtiene la primera letra de la cadena frase. 
//						El método substring(0, 1) toma una subcadena que comienza en el 
//						índice 0 y termina justo antes del índice 1. Esto es esencialmente 	
//						solo la primera letra de la cadena.
//
//.toUpperCase(): este método convierte la primera letra obtenida en el paso anterior a 
//					mayúsculas.
//
//+: este operador de concatenación se utiliza para unir la primera letra convertida a 
//		mayúsculas con el resto de la cadena.
//
//frase.substring(1): esto obtiene el resto de la cadena, comenzando desde el índice 1 hasta 
//						el final.
//
//.toLowerCase(): este método convierte el resto de la cadena a minúsculas.