package Ejercicio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import Clases.Estudiantes;
import Clases.Participa;
import Clases.Proyectos;

public class App {
	static Connection conexion=Conexion.getOracle("PROYECTOS", "PROYECTOS");
	
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		ODB odb=ODBFactory.open("neonatis.test");
		
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			
			switch(opcion) {
			case 1:
				crearDB(odb);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
			
		} while(opcion != 0);
	}

	private static void crearDB(ODB odb) {	
		try {
			//IQuery query=new CriteriaQuery(Clases.Proyectos.class, Where.equal(null, false));
			
			
			// AÑADIR ESTUDIANTES
			try {
				Statement stmtEstudiantes=conexion.createStatement();
	            String consulta="SELECT codestudiante, nombre, direccion, tlf, fechaalta FROM Estudiantes";
	            ResultSet rsetEstudiantes=stmtEstudiantes.executeQuery(consulta);
	            
	            // Crear una lista y añadir los estudiantes
	            List<Estudiantes> listaEstudiantes = new ArrayList<>();
	            
	            while(rsetEstudiantes.next()) {
	            	Estudiantes e=new Estudiantes();
	            	e.setCodestudiante(rsetEstudiantes.getInt("codestudiante"));
	            	e.setNombre(rsetEstudiantes.getString("nombre"));
	            	e.setDireccion(rsetEstudiantes.getString("direccion"));
	            	e.setTlf(rsetEstudiantes.getString("tlf"));
	            	e.setFechaalta(rsetEstudiantes.getDate("fechaalta"));
	            	e.setParticipaen(new ArrayList<>());
	            	listaEstudiantes.add(e);
	            	
	            	odb.store(e);
	            }
	            
	            System.out.println("Estudiantes añadidos correctamente");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}						                       
            
			
			// AÑADIR PROYECTOS
			try {
				Statement stmtEstudiantes=conexion.createStatement();
	            String consulta="SELECT codigoproyecto, nombre, fechainicio, fechafin, presupuesto, extraaportacion FROM proyectos";
	            ResultSet rsetProyectos=stmtEstudiantes.executeQuery(consulta);
	            
	            List<Clases.Proyectos> listaProyectos=new ArrayList<>();
	            while(rsetProyectos.next()) {
	            	Proyectos p=new Proyectos();
	            	int cod=rsetProyectos.getInt("codigoproyecto");
	            	
	            	p.setCodigoproyecto(cod);
	            	p.setNombre(rsetProyectos.getString("nombre"));
	            	p.setFechainicio(rsetProyectos.getDate("fechainicio"));
	            	p.setFechafin(rsetProyectos.getDate("fechafin"));
	            	p.setPresupuesto(rsetProyectos.getFloat("presupuesto"));
	            	p.setExtraaportacion(rsetProyectos.getFloat("extraaportacion"));
	            	p.setParticipantes(new ArrayList<>());
	            	
	            	// Metemos los proyectos en los que se participa en el arraylist
	            	try {
	            		Statement stmtParticipaciones=conexion.createStatement();
	    	            String consultaPar="SELECT codparticipacion, estudiante, proyecto, tipoparticipacion, numaportaciones FROM participaciones where codigoproyecto="+cod;
	    	            ResultSet rsetParticipaciones=stmtParticipaciones.executeQuery(consultaPar);
	            		
	    	            while(rsetParticipaciones.next()) {
	    	            	Participa par=new Participa();
	    	            	par.setCodparticipacion(rsetParticipaciones.getInt("codparticipacion"));
	    	            	par.setEstudiante(rsetParticipaciones.getInt("estudiante"));
	    	            	par.setProyecto(rsetParticipaciones.getInt("proyecto"));
	    	            	par.setTipoparticipacion(rsetParticipaciones.getString("tipoparticipacion"));
	    	            	par.setNumaportaciones(rsetParticipaciones.getInt("numaportaciones"));
	    	            		 
	    	            	odb.store(par);	    	           
	    	            }
	            		
					} catch (SQLException e) {
						e.printStackTrace();
					}
	            	
	            	odb.store(p);
	            	
	            	System.out.println("Proyectos añadidos correctamente");
	            }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Statement stmtEstudiantes=conexion.createStatement();
            String consulta="SELECT codestudiante, nombre, direccion, tlf, fechaalta FROM Estudiantes";
            ResultSet rsetEstudiantes=stmtEstudiantes.executeQuery(consulta);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
    
	}

	private static void menu() {
		System.out.println("----------------------------------------------");
		System.out.println("OPERACIONES PROYECTOS");
		System.out.println("1. Crear BD");
		System.out.println("2. Listar un proyecto.");
		System.out.println("3. Insertar participación.");
		System.out.println("0. Salir");
		System.out.println("----------------------------------------------");
	}
}