package Ejercicio;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int puerto = 6000;
        final int intentos = 4;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");

            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Cliente conectado.");
                int intentosRestantes = intentos;
                boolean victoria = false;

                out.println("Bienvenido al juego. Tienes " + intentos + " intentos para adivinar la palabra secreta.");

                while (intentosRestantes > 0 && !victoria) {
                    String textoCliente = in.readLine();
                    if (textoCliente == null) break;

                    if (textoCliente.equalsIgnoreCase("gato")) {
                        out.println("¡Has ganado! La palabra secreta era: " + "gato");
                        victoria = true;
                    } else {
                        intentosRestantes--;
                        if (intentosRestantes > 0) {
                            out.println("Incorrecto. Te quedan " + intentosRestantes + " intentos.");
                        } else {
                            out.println("Has perdido. La palabra secreta era: " + "gato");
                        }
                    }
                }

                System.out.println("Juego terminado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}