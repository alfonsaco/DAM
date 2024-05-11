package Otros;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        String usuarioCorrecto = "root";
        String contrasenaCorrecta = "1234";
        int intentos = 0;
        Scanner scanner = new Scanner(System.in);
        while (intentos < 3) {
            System.out.print("Nombre de usuario: ");
            String usuario=scanner.nextLine();
            
            System.out.print("Contraseña: ");
            String contrasena=scanner.nextLine();
            
            if (usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta)) {
                System.out.println("Bienvenido al sistema.");
                break;
            } else {
                System.out.println("Datos incorrectos. Intento " + (intentos + 1) + " de 3.");
                intentos++;
            }
        }
        
        scanner.close();
        if (intentos >= 3) {
            System.out.println("Se ha superado el número de intentos permitido. El programa se cerrará.");
        }
    }
}
