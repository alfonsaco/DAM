package Ejercicio;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.IOException;

public class DirectorioRecursivo {

    public static void main(String[] args) {
        // Configuración del servidor FTP
        String server = "localhost";
        int port = 21;
        String user = "usuario2"; 
        // Este usuario no tiene contraseña. Por eso, lo utilizo
        String pass = "";   

        FTPClient ftpClient = new FTPClient();

        try {
            // Conexión y autenticación
            ftpClient.connect(server, port);
            boolean login = ftpClient.login(user, pass);

            if (!login) {
                System.out.println("No se pudo iniciar sesión en el servidor FTP.");
                return;
            }
            System.out.println("Conexión y autenticación correctas.");

            // Directorio de inicio (usuario1)
            String directorioInicio = "/usuario1";
            System.out.println("Listando el contenido del directorio: " + directorioInicio);

            // Llamada al método recursivo para listar directorios y archivos
            listarDirectorio(ftpClient, directorioInicio, "");

            ftpClient.logout();
            ftpClient.disconnect();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Método recursivo para listar el contenido de un directorio en el servidor FTP.
    public static void listarDirectorio(FTPClient ftpClient, String path, String indent) throws IOException {
        FTPFile[] archivos = ftpClient.listFiles(path);

        for (FTPFile archivo : archivos) {
            String nombre = archivo.getName();
            // Evitar los directorios especiales "." y ".."
            if (nombre.equals(".") || nombre.equals("..")) {
                continue;
            }

            // Ruta completa
            String rutaCompleta = path + "/" + nombre;

            // Mostrar el nombre
            if (archivo.isDirectory()) {
                System.out.println(indent + "[DIR] " + nombre);
                // Llamada recursiva para el directorio encontrado
                listarDirectorio(ftpClient, rutaCompleta, indent + "    ");
                
            } else {
                System.out.println(indent + "      " + nombre);
            }
        }
    }
}
