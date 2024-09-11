package Recursos_Basicos_PT2;

import java.util.Scanner;

public class Contraseña {
	
    public static void main(String[] args) {
        /* Escriba un programa que pida al usuario su nombre y contraseña y le de tres
		oportunidades para introducir los datos correctos, que serán root y 1234. Si los datos
		introducidos son correctos se mostrará por pantalla “Bienvenido al sistema”. En caso
		contrario se mostrará un mensaje por pantalla indicando que se ha superado el número
		de intentos permitido*/
    	Scanner sc=new Scanner(System.in);
        String usuarioCorrecto="root";
        String contraseñaCorrecta="1234";
        int intentosMaximos=3;
        int intentos=0;
        boolean accesoPermitido=false;
        while (intentos<intentosMaximos && !accesoPermitido) {
            System.out.print("Ingrese su nombre de usuario: ");
            String usuario=sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contraseña=sc.nextLine();
            if (usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta)) {
                System.out.println("Bienvenido al sistema.");
                accesoPermitido=true;
            } else {
                System.err.println("Datos incorrectos. Intento fallido.");
                if (intentos<intentosMaximos-1)
                    System.out.println("Por favor, intente nuevamente.");
                else 
                    System.err.println("Ha superado el número de intentos permitido.");
            }
            intentos++;
        }
        sc.close();
    }
}
