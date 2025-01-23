package Ejercicio;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        final int puerto = 6000;

        try (Socket socket = new Socket("localhost", puerto);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor.");

            // Recibir mensaje inicial del servidor
            String serverMessage = in.readLine();
            System.out.println("Servidor: " + serverMessage);

            while (true) {
                System.out.print("Introduce una palabra: ");
                String userGuess = scanner.nextLine();
                out.println(userGuess);

                serverMessage = in.readLine();
                System.out.println("Servidor: " + serverMessage);

                // Terminar el juego si el servidor indica que ha terminado
                if (serverMessage.startsWith("¡Has ganado!") || serverMessage.startsWith("Has perdido")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
