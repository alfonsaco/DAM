package Examen;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class App implements GestionErrores, Serializable {
	private ArrayList<Guia> guias;

	// Constructores
	public App(ArrayList<Guia> guias) {
		this.guias = guias;
	}public App() {
		this.guias =new ArrayList<Guia>();
	}
	
	// Getters y Setters
	public ArrayList<Guia> getGuias() {
		return guias;
	}
	public void setGuias(ArrayList<Guia> guias) {
		this.guias = guias;
	}
	
	// Método para borrar la tabla
	@Override
	public boolean limpiarTotalGuia() {
		try {
			
			BD.getInstance().cargarParametrosConexionJSON();
			ResultSet rset = BD.getInstance().consultaBD("delete from totalguia");
			ResultSet rset1 = BD.getInstance().consultaBD("commit");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Método para cargar los guias en el ArrayList
	public void cargarGuias() {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File("personas.csv"));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		if(linea[1].isEmpty()) {
        			this.getGuias().add(new Guia(linea[0],linea[2],linea[3],linea[4],Integer.parseInt(linea[5])));
        		}
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		App app=new App();
		
		app.limpiarTotalGuia();
		app.cargarGuias();
		
		if(args.length==0) {
			app.cargarGuias();
			for (Guia g : app.getGuias()) {
				int cont=0;
				double suma=0;
				g.cargarTuristas("personas.csv");
				for (Turista t : g.getTuristas()) {
					cont++;
					suma+=t.getVisita().getPrecio();
				}
				System.out.println(g.getNombre()+" "+g.getApellidos()+" tiene "+cont+" visitas");
				// Insercion
				try {
					BD.getInstance().cargarParametrosConexionJSON();
					ResultSet rset = BD.getInstance().consultaBD("insert into totalguia values ('"+g.getId()+"',12,'Junio',2024,"+suma+")");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if(args.length==1) {
			String codigo=args[0].split("=")[1];
			double importe=0;
			double importeTotal=0;
			for (Guia g : app.getGuias()) {
				if(g.getId().equals(codigo)) {
					g.cargarTuristas("personas.csv");
					System.out.println("Los turistas de "+g.getNombre()+" "+g.getApellidos());
					for (Turista t : g.getTuristas()) {
						t.cargarVisita("visitasHoy.txt");
						if(t.getIdioma().equals("Español")) {
							System.out.println(t.getId()+" "+t.getNombre()+" "+t.getApellidos());
							importe=t.getVisita().getPrecio()*0.25;
							importeTotal+=importe;
							System.out.println("\tIdioma de la visita: "+t.getIdioma()+"=>"+importe+"€");
						} else {
							System.out.println(t.getId()+" "+t.getNombre()+" "+t.getApellidos());
							importe=t.getVisita().getPrecio()*0.3;
							importeTotal+=importe;
							System.out.println("\tIdioma de la visita: "+t.getIdioma()+"=>"+importe+"€");
						}
					}
					System.out.println("\t\tIMPORTE: "+importeTotal+"€");
				}
			}
		}
	}
	
}
