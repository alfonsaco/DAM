package Aplicacion;

import java.io.*;
import java.net.*;

public class Clientebinario {
    public static void main(String[] args) {
        try  {
        	Socket socket=new Socket("localhost", 6000);
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

            int number;
            String input;

            do {
                System.out.print("Introduce un número (0 para salir): ");
                input=reader.readLine();
                
                // Try catch para convertir el número, y verificar que sea un número
                try {
                    number = Integer.parseInt(input);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Caracter no válido");
                    continue;
                }

                // Enviar el número al servidor
                dos.writeInt(number);

                // Caso 0
                if (number == 0) {
                    System.out.println("Fin de la comunicación. Saliendo.");
                    break;
                }

                // Recibir el número binario desde el servidor
                String binary = dis.readUTF();
                System.out.println(number + " en binario es: " + binary);

            } while (true);

        } catch (IOException e) {
            System.err.println("Hubo un error en el cliente");
        }
    }
}
