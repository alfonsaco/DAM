package Interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EJERCICIO1_1 {

    private JFrame frame;
    private JTextField textFieldUsuario;
    private JTextField textFieldContraseña;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EJERCICIO1_1 window = new EJERCICIO1_1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public EJERCICIO1_1() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(69, 61, 69, 14);
        frame.getContentPane().add(lblUsuario);

        JLabel lblContraseña = new JLabel("Clave:");
        lblContraseña.setBounds(69, 108, 89, 14);
        frame.getContentPane().add(lblContraseña);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(148, 58, 172, 20);
        frame.getContentPane().add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        textFieldContraseña = new JTextField();
        textFieldContraseña.setBounds(148, 105, 172, 20);
        frame.getContentPane().add(textFieldContraseña);
        textFieldContraseña.setColumns(10);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String contraseña = textFieldContraseña.getText();

                if (usuario.equals("pepe") && contraseña.equals("1234")) {
                    JOptionPane.showMessageDialog(frame, "Bienvenido");
                } else {
                    JOptionPane.showMessageDialog(frame, "Contraseña incorrecta");
                }
            }
        });
        btnEntrar.setBounds(105, 167, 89, 23);
        frame.getContentPane().add(btnEntrar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(216, 167, 89, 23);
        frame.getContentPane().add(btnSalir);
    }
}