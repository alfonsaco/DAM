package Aplicacion; 

import java.io.*;
import java.net.*;

public class ServidorBinario {
    public static void main(String[] args) {
        try (ServerSocket serverSocket=new ServerSocket(6000)) {
            System.out.println("Servidor iniciado y esperando conexiones...");

            while (true) {
                try (Socket clientSocket=serverSocket.accept();
                     DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream dos=new DataOutputStream(clientSocket.getOutputStream())) {

                    System.out.println("Cliente conectado.");

                    int number;

                    while (true) {
                        // Recibir el número del cliente
                        number=dis.readInt();

                        if (number == 0) {
                            System.out.println("Número 0 recibido. Cerrando conexión con el cliente.");
                            break;
                        }

                        // Convertir el número a binario
                        String binary=Integer.toBinaryString(number);
                        System.out.println("Número recibido: " + number + ", binario: " + binary);

                        // Con esto, enviamos el binario al cliente
                        dos.writeUTF(binary);
                    }

                } catch (IOException e) {
                    System.err.println("Error al comunicar con el cliente: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
