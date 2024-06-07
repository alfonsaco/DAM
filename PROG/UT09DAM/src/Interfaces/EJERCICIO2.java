package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EJERCICIO2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EJERCICIO2 window = new EJERCICIO2();
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
	public EJERCICIO2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 595, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel("Saldo cuenta:");
		label1.setBounds(42, 156, 73, 14);
		frame.getContentPane().add(label1);
		
		JLabel lblNewLabel = new JLabel("Saldo tarjeta:");
		lblNewLabel.setBounds(42, 200, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton boton1 = new JButton("Ingresar en cuenta");
		boton1.setBounds(20, 35, 148, 23);
		frame.getContentPane().add(boton1);
		
		JButton boton2 = new JButton("Sacar dinero de cuenta");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton2.setBounds(189, 35, 155, 23);
		frame.getContentPane().add(boton2);
		
		JButton boton3 = new JButton("Transferir de Cuenta a Tarjeta");
		boton3.setBounds(360, 35, 189, 23);
		frame.getContentPane().add(boton3);
		
		JButton boton4 = new JButton("Ingresar en Tarjeta");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton4.setBounds(20, 75, 148, 23);
		frame.getContentPane().add(boton4);
		
		JButton boton5 = new JButton("Sacar dinero de tarjeta");
		boton5.setBounds(189, 75, 155, 23);
		frame.getContentPane().add(boton5);
		
		JButton salir = new JButton("New button");
		salir.setBounds(442, 196, 89, 23);
		frame.getContentPane().add(salir);
	}

}
