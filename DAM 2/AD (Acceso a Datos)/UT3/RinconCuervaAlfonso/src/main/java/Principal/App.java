package Principal;

import java.math.BigInteger;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Clases.Alumnos;
import Clases.Asignaturas;
import Clases.Cursoasig;
import Clases.Cursos;
import Clases.Matriculas;
import Clases.Nuevosalumnos;

public class App {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		LogManager.getLogManager().reset();
		Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		globalLogger.setLevel(java.util.logging.Level.OFF);
		factory=Conexion.getSession();
		Scanner sc = new Scanner(System.in);
		
		int opcion=0;
		do {
			menu();
			opcion=sc.nextInt();
			
			switch(opcion) {
			case 1:
				mostrarAsignaturas();
				break;
				
			case 2:
				estadisticasAsignaturas();
				estadisticasAlumnos();
				break;
				
			case 3:
				insertarAlumnoNuevo();
				break;
				
			case 4:
				System.out.println("Se finalizó el programa");
				break;
			}
			
		} while(opcion != 4);
	}
	
	// MÉTODO PARA OBTENER LAS ESTADÍSTICAS DE LOS ALUMNOS
	private static void estadisticasAlumnos() {
	    Session session = factory.openSession();        
	    // Consulta para recibir la media y los datos del alumno
	    String consultaObtenerMedia = "select a.codalum, a.nombre, round(avg(m.notaasig), 2) "
	            + "from Alumnos a "
	            + "left join a.matriculases m "
	            + "group by a.codalum, a.nombre "
	            + "order by avg(m.notaasig) desc";
	
	    try {
	        Query<Object[]> query=session.createQuery(consultaObtenerMedia, Object[].class);
	        List<Object[]> resultados=query.list();
	
	        // Verificamos que exista
	        if (resultados != null && !resultados.isEmpty()) {
	            System.out.println("-------- ALUMNO(S) CON MAYOR NOTA MEDIA --------");
	            System.out.printf("%15s %15s %15s", "CÓDIGO", "NOMBRE", "NOTA MEDIA");
	            System.out.printf("\n %15s %15s %15s", "------------", "------------", "------------");
	
	            // Mayor media
	            double mayorMedia = 0;
	            for (Object[] resultado : resultados) {
	                Double media = (Double) resultado[2];
	                if (media != null && media > mayorMedia) {
	                    mayorMedia = media; 
	                }
	            }
	
	            for (Object[] resultado : resultados) {
	                Double media = (Double) resultado[2]; 
	                if (media != null && media == mayorMedia) {
	                    String codigoAlumno=String.valueOf(resultado[0]); 
	                    String nombreAlumno=(String) resultado[1];
	                    System.out.printf("\n %15s %15s %15.2f", codigoAlumno, nombreAlumno, media);
	                }
	            }
	
	            System.out.println("\n\n");
	        } else {
	            System.out.println("No se encontraron alumnos.");
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    } finally {
	        session.close();
	    }
	}

	// MÉTODO PARA OBTENER LAS ESTADÍSTICAS DE LAS ASIGNATURAS
	public static void estadisticasAsignaturas() {
        Session session=factory.openSession();        
        String consulta="FROM Asignaturas a LEFT JOIN a.matriculases m GROUP BY a ORDER BY COUNT(m) DESC";

        try {
            Query<Asignaturas> query=session.createQuery(consulta, Asignaturas.class);
            List<Asignaturas> asignaturas=query.list();
            
            // Verificamos que existan asignaturas y que no esté vacía la lista
            if (asignaturas != null && !asignaturas.isEmpty()) {
                long maxAlumnos=asignaturas.get(0).getMatriculases().size(); 
                
                System.out.println("-------- ASIGNATURA CON MÁS ALUMNOS --------");
                System.out.printf("%15s %15s %15s","CÓDIGO","NOMBRE","NÚMERO DE ALUMNOS");
                System.out.printf("\n %15s %15s %15s","------------","------------","--------------");
                
                for (Asignaturas asignatura : asignaturas) {
                    long numAlumnos = asignatura.getMatriculases().size();
                    
                    if (numAlumnos == maxAlumnos) {
                        System.out.printf("\n%15s %15s %15s", asignatura.getCodasig(),asignatura.getNombreasig(), numAlumnos);                        
                    }
                }
                System.out.println("\n\n");
            } else {
                System.out.println("No se encontraron asignaturas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

	// MÉTODO PARA INSERTAR ALUMNOS EN LA NUEVA TABLA
	private static void insertarAlumnoNuevo() {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		
		try {
			String consultaDatosAlumnos="FROM Nuevosalumnos";
			
			Query<Nuevosalumnos> queryNuevosAlumnos=session.createQuery(consultaDatosAlumnos, Nuevosalumnos.class);
			List<Nuevosalumnos> nuevosAlumnos=queryNuevosAlumnos.list();
			
			for (Nuevosalumnos a : nuevosAlumnos) {
				// Verificamos que existe el alumno
				String consultaExiste="SELECT COUNT(a.codalum) FROM Alumnos a WHERE a.nombre = :nombre";
				
				Query<Long> queryCheckNombre = session.createQuery(consultaExiste, Long.class);
				queryCheckNombre.setParameter("nombre", a.getId().getNombre());				
				Long dato=queryCheckNombre.uniqueResult();
				
				if (dato > 0) {
					System.out.println("El alumno"+a.getId().getNombre()+" está en la base de datos.\n");
					continue;
					
				} 
					// Comprobación del código
					String hqlCheckCodigo = "SELECT COUNT(a.codalum) FROM Alumnos a WHERE a.codalum = :codalum";
										
					Query<Long> queryCheckCodigo = session.createQuery(hqlCheckCodigo, Long.class);
					queryCheckCodigo.setParameter("codalum", a.getId().getCodalum());
										
					Long contCod=queryCheckCodigo.uniqueResult();
					BigInteger codFInal=a.getId().getCodalum();
					
					// Con esto, vamos a obtener el código más alto, y se le añadirá el siguiente valor al alumno
					if (contCod > 0) {						
						String consultaCod="SELECT MAX(a.codalum) FROM Alumnos a";
						Query<BigInteger> queryMaxCodigo = session.createQuery(consultaCod, BigInteger.class);
						BigInteger maxCodigo = queryMaxCodigo.uniqueResult();
						
						codFInal=maxCodigo.add(BigInteger.ONE);
						System.out.printf("El codigo "+a.getId().getCodalum()+" ya existe. El nuevo código es "+codFInal);
					}

					// Adjudicames representante y curso
					BigInteger representante=null;
					BigInteger curso=null;					
					switch (a.getId().getPoblacion().toLowerCase()) {
						case "talavera":
							representante=BigInteger.ONE;
							curso=BigInteger.ONE;
							break;
							
						case "toledo":
							representante=BigInteger.valueOf(8);
							curso=BigInteger.valueOf(4);
							break;
							
						default:
							representante=BigInteger.valueOf(11);
							curso=BigInteger.valueOf(5);
							break;
					}
										
					Alumnos alumno = new Alumnos();
					alumno.setCodalum(codFInal);
					alumno.setNombre(a.getId().getNombre());
					alumno.setDireccion(a.getId().getDireccion());
					alumno.setPoblacion(a.getId().getPoblacion());
					alumno.setTelef(a.getId().getTelef());
					alumno.setAlumnos(session.get(Alumnos.class, representante));
					alumno.setCursos(session.get(Cursos.class, curso));
					
					session.persist(alumno);							
					System.out.println("El alumno"+a.getId().getNombre()+"fue insertado");
										
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
	}

	// MÉTODO PARA MOSTRAR LAS ASIGNATURAS QUE HAY EN CADA CURSO
	public static void mostrarAsignaturas() {
		Session session=factory.openSession();  
	    String consultaCursos = "FROM Cursos c";
	    
	    try {
	        Query<Cursos> queryCursos = session.createQuery(consultaCursos, Cursos.class);
	        List<Cursos> cursos = queryCursos.list();
	        
	        for (Cursos c : cursos) {
	            System.out.println("--------------------------------------------------------------------------");
	            System.out.println("COD-CURSO: "+c.getCodcurso()+"            DENOMINACIÓN: "+c.getDenominacion());
	            System.out.println("PRECIO: " + c.getPrecio() + "€                 NIVEL: " + c.getNivel());
	            
	            // Variable para obtener el número de alumnos
	            long numAlumnos=c.getAlumnoses().size();
	            // Variable para obtener el número de asignaturas
	            Set<Cursoasig> listaAsignaturas=c.getCursoasigs();
	            long numAsignaturas=listaAsignaturas.size();
	            
	            System.out.println("NÚMERO ALUMNOS: "+numAlumnos+"          NÚMERO DE ASIGNATURAS: "+numAsignaturas);
	            
	            System.out.printf("\n %20s %20s %20s %20s %20s %20s %20s", "COD-ASIG","NOMBRE ASIG","PRECIO ASIG","TIPO ASIG","INCREMENTO","NUM ALUMNOS","TOTAL ASIG");
	            System.out.printf("\n %20s %20s %20s %20s %20s %20s %20s", "------------","------------","------------","------------","------------","------------","------------");
	            
	            int totalAlumnos=0;
	            double totalAsignaturas=0.0;
	            
	            // Variable para poner el incremento
	            double incremento=0;
	            for(Cursoasig asig : listaAsignaturas) {	                	                	                
	            	long numeroAlumnos=asig.getAsignaturas().getMatriculases().size();
	                               
	            	Character tipo=asig.getAsignaturas().getTipoasig();
	            	switch(tipo) {
	            	case 'A': 
	            		incremento=asig.getAsignaturas().getPrecioasig().doubleValue()*0.05;
	            		break;
	            	case 'B': 
	            		incremento=asig.getAsignaturas().getPrecioasig().doubleValue()*0.06;
	            		break;
	            	case 'C': 
	            		incremento=asig.getAsignaturas().getPrecioasig().doubleValue()*0.08;
	            		break;
	            	case 'D': 
	            		incremento=asig.getAsignaturas().getPrecioasig().doubleValue()*0.1;
	            		break;
	            	}
	            	
	            	// Calcular el total por asignatura
	            	double totalAsig=numeroAlumnos*((asig.getAsignaturas().getPrecioasig().doubleValue()) + incremento);
	            	totalAlumnos += numeroAlumnos;
	                totalAsignaturas += totalAsig;
	            	
	            	System.out.printf("\n %20s %20s %20s %20s %20s %20s %20s", asig.getAsignaturas().getCodasig(), asig.getAsignaturas().getNombreasig(), asig.getAsignaturas().getPrecioasig(), asig.getAsignaturas().getTipoasig(), incremento, numeroAlumnos, totalAsig);	            	
	            }	            
	            System.out.println("\n------------------------------------------------------------------------------------------");
	            System.out.printf("\\n %20s %20s %20s %20s %20s %20s %20s \n", "TOTALES:","","","","", totalAlumnos, totalAsignaturas);
		    
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }	    	        	           	            
	}

	// MÉTODO CON EL MENÚ
	// MÉTODO CON EL MENÚ
	private static void menu() {
		System.out.println("-------------------------------------------");
		System.out.println("1. Mostrar asignaturas impartidas en cada curso");
		System.out.println("2. Estadística alumnos y asignaturas");
		System.out.println("3. Insertar alumnos");
		System.out.println("4. Salir");
		System.out.println("-------------------------------------------");
		System.out.println();
	}
}
