package Spotify;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Interfaz {

	static Interfaz frame2;
	private JFrame frame;
	private JTextField buscar;
	private ArrayList<Canciones>canciones;
	private ArrayList<Grupos>grupos;
	private JTextArea mostrarTodo;
	

	// CONSTRUCTORES
	public Interfaz(ArrayList<Canciones> canciones, ArrayList<Grupos> grupos) {
		this.canciones =canciones;
		this.grupos =grupos;
	}
	
	// GETTERS Y SETTERS
	public ArrayList<Canciones> getCanciones() {
		return canciones;
	}
	public void setCanciones(ArrayList<Canciones> canciones) {
		this.canciones = canciones;
	}
	public ArrayList<Grupos> getGrupos() {
		return grupos;
	}
	public void setGrupos(ArrayList<Grupos> grupos) {
		this.grupos = grupos;
	}

	// MÉTODO PARA LEER GRUPOS
	private void leerGrupos() {
		try {
			String cadena;
			String[] linea;
			Scanner entrada=new Scanner(new File("grupos.csv"));
				while(entrada.hasNext()) {
					cadena=entrada.nextLine();
					linea=cadena.split(",");
					this.getGrupos().add(new Grupos(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), linea[3]));
				}
			} catch (FileNotFoundException e) {
				System.err.println("Fichero no encontrado");
				e.printStackTrace();
		}
	}
	// MÉTODO PARA LEER CANCIONES
	private void leerCanciones() {
		try {
			String cadena;
			String[] linea;
			Scanner entrada=new Scanner(new File("canciones.csv"));
				while(entrada.hasNext()) {
					cadena=entrada.nextLine();
					linea=cadena.split(",");
					this.getCanciones().add(new Canciones(Integer.parseInt(linea[0]), linea[1], linea[2], linea[3]));
				}
			} catch (FileNotFoundException e) {
				System.err.println("Fichero no encontrado");
				e.printStackTrace();
		}
	}
	
	// MOSTRAR CANCIONES USANDO UN CÓDIGO DE GRUPO
	private void mostrarCancionesGrupo(int codigo) {
		String cadena="\tCanciones:";
		for (Canciones c : this.getCanciones()) {
			if(codigo==c.getCodigo()) {
				cadena+="\n"+c.getNombre();
			}
		}
		mostrarTodo.setText(cadena);
	}
	
	// MOSTRAR GRUPOS
	private void mostrarGrupos() {
		String cadena="\tGrupos:";
		for (Grupos g : this.getGrupos()) {
			cadena+="\n"+g.getNombre();
		}
		mostrarTodo.setText(cadena);
	}
	
	// MOSTRAR CANCIONES
	private void mostrarCanciones() {
		String cadena="\tCanciones:";
		for (Canciones c : this.getCanciones()) {
			cadena+="\n"+c.getNombre();
		}
		mostrarTodo.setText(cadena);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
					frame2 = new Interfaz();
					frame2.setVisible(true);
					Interfaz.frame2=new Interfaz();
					Interfaz.frame2.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
		this.canciones =new ArrayList<Canciones>();
		this.grupos =new ArrayList<Grupos>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(168, 255, 168));
		frame.setBounds(100, 100, 565, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton mostrar = new JButton("Mostrar grupos");
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupos.clear();
				leerGrupos();
				mostrarGrupos();
			}
		});
		
		mostrar.setBounds(39, 57, 143, 23);
		frame.getContentPane().add(mostrar);
		
		JLabel lblNewLabel = new JLabel("Código de grupo");
		lblNewLabel.setBounds(39, 103, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		buscar = new JTextField();
		buscar.setBounds(40, 128, 142, 20);
		frame.getContentPane().add(buscar);
		buscar.setColumns(10);
		
		JButton verCanciones = new JButton("Ver canciones");
		verCanciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canciones.clear();
				leerCanciones();
				String numero=buscar.getText();
				if(numero.isEmpty()) {
					mostrarCanciones();
				}else {
					if(Integer.parseInt(numero)>=1 && Integer.parseInt(numero)<=7) {
						mostrarCancionesGrupo(Integer.parseInt(numero));
					}else {
						System.err.println("ERROR");
					}
				}
				
			}
		});
		verCanciones.setBounds(39, 180, 143, 23);
		frame.getContentPane().add(verCanciones);
		
		JLabel lblNewLabel_1 = new JLabel("Grupos y canciones");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(305, 22, 161, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		mostrarTodo = new JTextArea();
		mostrarTodo.setBounds(238, 56, 276, 215);
		frame.getContentPane().add(mostrarTodo);
	}

	public void setVisible(boolean b) {
		
	}
}
