package juegos;

import java.util.Scanner;

public class wordle {
	
    public static void main(String[] args) {
        String[] palabras = {"PLATO","PISAR","PLANO","MAREO","LISTA","LISTO","SUCIO","PERRO","MIXTO","BULTO","CASTO","PRADO","MOSCA","PISTO","TURCO","BRAVO","VISTO","QUESO","GUISO","USADO",};
        // Número aleatorio para seleccionar la palabra secreta
        int posicionAleatoria=(int)(Math.random()*20);
        String palabraSecreta=palabras[posicionAleatoria];
        String adivina="_".repeat(palabraSecreta.length());
        int intentosRestantes=6;
        Scanner sc=new Scanner(System.in);
        while (intentosRestantes>0 && !adivina.equals(palabraSecreta)) {
            System.out.println("Dame una palabra de 5 letras en mayúsculas:");
            String palabraUsuario=sc.next().toUpperCase();
            // Validación de la entrada del usuario
            while (!palabraUsuario.matches("[A-Z]{5}")) {
                System.out.println("Error. Debe ingresar una palabra de 5 letras en mayúsculas:");
                palabraUsuario=sc.next().toUpperCase();
            }
            // Compara la palabra secreta con la palabra del usuario
            for (int i=0;i<palabraSecreta.length();i++) {
                if (palabraUsuario.charAt(i)==palabraSecreta.charAt(i)) {
                    // La letra está en la posición correcta
                    char[] adivinaArray=adivina.toCharArray();
                    adivinaArray[i]=palabraUsuario.charAt(i);
                    adivina=new String(adivinaArray);
                }
            }
            System.out.println("Palabra adivinada: "+adivina);
            intentosRestantes--;
            System.out.println("Intentos restantes: "+intentosRestantes);
        }
        if (adivina.equals(palabraSecreta)) 
            System.out.println("La palabra es: " + palabraSecreta + " ¡¡Espléndido!!");
        else 
            System.out.println("La palabra era: " + palabraSecreta);
        sc.close();
    }
}

