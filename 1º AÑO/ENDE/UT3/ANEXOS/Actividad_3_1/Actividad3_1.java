package Actividad_3_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class Actividad3_1 {

	private JFrame frame;
	private JTextField Textn1;
	private JTextField Textn2;
	private JLabel salida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividad3_1 window = new Actividad3_1();
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
	public Actividad3_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(188, 237, 190));
		frame.setBounds(100, 100, 450, 253);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Labeln1 = new JLabel("Numero 1:");
		Labeln1.setBounds(10, 11, 66, 14);
		frame.getContentPane().add(Labeln1);
		
		JLabel Labeln2 = new JLabel("Numero 2:");
		Labeln2.setBounds(10, 36, 66, 14);
		frame.getContentPane().add(Labeln2);
		
		Textn1 = new JTextField();
		Textn1.setBounds(86, 8, 86, 20);
		frame.getContentPane().add(Textn1);
		Textn1.setColumns(10);
		
		Textn2 = new JTextField();
		Textn2.setBounds(86, 33, 86, 20);
		frame.getContentPane().add(Textn2);
		Textn2.setColumns(10);
		
		JButton division = new JButton("DIVIDIR");
		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero1=Integer.parseInt(Textn1.getText());
				int numero2=Integer.parseInt(Textn2.getText());
				
				float division=(float)numero1/numero2;
				
				salida.setText(String.format("%f",division));
			}
		});
		division.setBounds(10, 64, 89, 23);
		frame.getContentPane().add(division);
		
		JButton limpiar = new JButton("LIMPIAR");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Textn1.setText(" ");
				Textn2.setText(" ");
				
				salida.setText("RESULTADO");
			}
		});
		limpiar.setBounds(114, 64, 89, 23);
		frame.getContentPane().add(limpiar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(231, 251, 227));
		panel.setBounds(10, 98, 414, 105);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		salida = new JLabel("RESULTADO");
		salida.setBackground(new Color(192, 192, 192));
		salida.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		salida.setHorizontalAlignment(SwingConstants.CENTER);
		salida.setBounds(10, 11, 394, 83);
		panel.add(salida);
	}
}
