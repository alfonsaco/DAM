package EjercicioSMTP;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {

    public static void sendEmail(String nombre, String smtpServer, String username, String password, String port, String recipient) {
        // Configuración de las propiedades para la conexión SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");              
        props.put("mail.smtp.starttls.enable", "true");       
        props.put("mail.smtp.host", smtpServer);               
        props.put("mail.smtp.port", port);              

        // Se crea una sesión con un autenticador
        Session session = Session.getInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Se construye el mensaje
            Message message = new MimeMessage(session);
            // Se establece el remitente (con nombre visible)
            message.setFrom(new InternetAddress(username, nombre));
            // Se especifica el destinatario
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            // Se define el asunto
            message.setSubject("Prueba de envío de correo");
            // Se escribe el cuerpo del mensaje
            message.setText("Este es un mensaje enviado desde Java utilizando el servidor SMTP.");

            // Se envía el mensaje
            Transport.send(message);
            System.out.println("Correo enviado exitosamente.");
            
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.err.println("Error al enviar el correo:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Uso: java EmailSender <nombre> <smtpServer> <username> <password> <port> <recipient>");
            return;
        }
        String nombre= args[0];
        String smtpServer = args[1];
        String username= args[2];
        String password = args[3];
        String port = args[4];
        String recipient = args[5];

        sendEmail(nombre, smtpServer, username, password, port, recipient);
    }
}

