package Spotify;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textousuario;
	private JPasswordField textocontraseña;
	static Login frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new Login();
					frame1.setVisible(true);
					Interfaz.frame2=new Interfaz();
					Interfaz.frame2.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 255, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setBounds(127, 71, 72, 37);
		usuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(usuario);
		
		JLabel contraseña = new JLabel("Contraseña");
		contraseña.setBounds(127, 134, 91, 37);
		contraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(contraseña);
		
		textousuario = new JTextField();
		textousuario.setBounds(308, 83, 96, 19);
		contentPane.add(textousuario);
		textousuario.setColumns(10);
		
		textocontraseña = new JPasswordField();
		textocontraseña.setBounds(308, 146, 96, 19);
		contentPane.add(textocontraseña);
		
		JButton boton = new JButton("Entrar");
		boton.setBounds(264, 291, 116, 37);
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textousuario.getText().equals("admin") && textocontraseña.getText().equals("admin")) {
					frame1.setVisible(false);
					Interfaz.frame2.setVisible(true);
				}
				if(textousuario.getText().equals("admin") && !textocontraseña.getText().equals("admin")) {
							JOptionPane.showMessageDialog(boton, "Contraseña Incorrecta");
				}
				if(!textousuario.getText().equals("admin") && textocontraseña.getText().equals("admin")) {
							JOptionPane.showMessageDialog(boton, "Usuario Incorrecto");
				}
				if(!textousuario.getText().equals("admin") && !textocontraseña.getText().equals("admin")) {
					JOptionPane.showMessageDialog(boton, "Contraseña y usuario incorrectos");
		}
				
			}
		});
		boton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(boton);
	}
}