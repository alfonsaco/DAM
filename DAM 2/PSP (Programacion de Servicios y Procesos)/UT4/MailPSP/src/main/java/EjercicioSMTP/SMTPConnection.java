package EjercicioSMTP;

import java.io.IOException;
import java.net.ServerSocket;

public class SMTPConnection {

    public static void openPort(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Puerto " + port + " abierto. Esperando conexión...");
            // Se espera (bloquea) hasta que se establezca una conexión
            serverSocket.accept();
            System.out.println("¡Conexión recibida!");
        } catch (IOException e) {
            System.err.println("Error al abrir el puerto " + port + ": " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                    System.out.println("Puerto " + port + " cerrado.");
                } catch (IOException e) {
                    System.err.println("Error al cerrar el puerto: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Método principal.
     * Se espera que se pase por línea de comandos el puerto a abrir.
     */
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Uso: java PortOpener <port>");
            return;
        }
        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch(NumberFormatException e) {
            System.err.println("El puerto debe ser un número entero.");
            return;
        }
        openPort(port);
    }
}

