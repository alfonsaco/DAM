package App;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Clases.Alumnos;
import Clases.Asignaturas;
import Clases.Centros;
import Clases.Cursos;
import Clases.Departamentos;
import Clases.Evaluaciones;
import Clases.EvaluacionesId;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;

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
				insertarEvaluacion(1, 1011, 3, 4);
				insertarEvaluacion(6, 1011, 3, 4);
				insertarEvaluacion(2, 2222, 3, 5);
				insertarEvaluacion(2, 1011, 3, 12);
				insertarEvaluacion(2, 1011, 100, 2);
				insertarEvaluacion(2, 1011, 332, 1);
				break;
				
			case 2:
				actualizarDatos();
				break;
				
			case 3:
				mostrarCursos();
				break;
				
			case 4:
				mostrarEstadisticas();
				break;
				
			case 5:
				realizarConsultas();
				break;
				
			case 6:
				System.out.println("SE FINALIZÓ EL PROGRAMA");
				break;
			}
			
		} while (opcion != 6);
	}

	private static void mostrarEstadisticas() {
		Session session = factory.openSession();

		String consultaEstadisticas="";
	    List<Object[]> resultados = session.createQuery(consultaEstadisticas, Object[].class).list();

	    System.out.println("Ejercicio 4. Estadística de centros.");
	    System.out.println("-----------------------------------.");
	    System.out.printf("%-10s %-30s %-10s %-10s %-10s %-10s %-30s\n", 
	            "COD-CENTRO", "NOMBRE", "NUMCURSOS", "NUMALUMNOS", "NUM-ASIG", "NOTA-MEDIA", "ALUMNO MÁXIMO");
	    System.out.println("---------- ------------------------------ ---------- ---------- ---------- ---------- ------------------------------");

	    for (Object[] fila : resultados) {
	        int codCentro = (int) fila[0];
	        String nombreCentro = (String) fila[1];
	        long numCursos = (long) fila[2];
	        long numAlumnos = (long) fila[3];
	        long numAsignaturas = (long) fila[4];
	        double notaMedia = fila[5] != null ? (double) fila[5] : 0.0;
	        double notaMaxima = fila[6] != null ? (double) fila[6] : 0.0;
	        String nombreAlumnoMaximo = fila[7] != null ? (String) fila[7] : "SIN ALUMNOS";

	        System.out.printf("%-10d %-30s %-10d %-10d %-10d %-10.1f %-30s\n", 
	                codCentro, nombreCentro, numCursos, numAlumnos, numAsignaturas, notaMedia, 
	                nombreAlumnoMaximo + (notaMaxima > 0 ? " (" + notaMaxima + ")" : ""));
	    }

	    session.close();
	}
	
	@SuppressWarnings("deprecation")
	private static void actualizarDatos() {
        Session session=factory.openSession();

        try {
            session.beginTransaction();

            // Actualizar NUM_ALUMNOS y NUM_CURSOS de la tabla CENTROS
            Query<Object[]> centrosQuery = session.createQuery(
                "SELECT c.codCentro, SUM(cu.numAlumnos), COUNT(cu.codCurso) " +
                "FROM Centros c JOIN c.cursoses cu " +
                "GROUP BY c.codCentro", Object[].class);

            List<Object[]> centrosResultados = centrosQuery.getResultList();
            for (Object[] row : centrosResultados) {
                int codCentro = (int) row[0];
                long numAlumnos = row[1] != null ? (long) row[1] : 0;
                long numCursos = (long) row[2];

                Centros centro=(Centros) session.get(Centros.class, codCentro);
                centro.setNumAlumnos((int) numAlumnos);
                centro.setNumCursos((int) numCursos);
                session.update(centro);
            }

            // Actualizar NUM_ALUMNOS de la tabla CURSOS
            Query<Object[]> cursosQuery = session.createQuery(
                "SELECT cu.codCurso, COUNT(a.numAlumno) " +
                "FROM Cursos cu JOIN cu.alumnoses a " +
                "GROUP BY cu.codCurso", Object[].class);

            List<Object[]> cursosResultados = cursosQuery.getResultList();
            for (Object[] row : cursosResultados) {
                int codCurso = (int) row[0];
                long numAlumnos = (long) row[1];

                Cursos curso = session.get(Cursos.class, codCurso);
                curso.setNumAlumnos((int) numAlumnos);
                session.update(curso);
            }

            // Actualizar NUM_ASIG de la tabla DEPARTAMENTOS
            Query<Object[]> departamentosQuery = session.createQuery(
                "SELECT d.codDepar, COUNT(a.codAsig) " +
                "FROM Departamentos d JOIN d.asignaturases a " +
                "GROUP BY d.codDepar", Object[].class);

            List<Object[]> departamentosResultados = departamentosQuery.getResultList();
            for (Object[] row : departamentosResultados) {
                int codDepar = (int) row[0];
                long numAsig = (long) row[1];

                Departamentos departamento = (Departamentos) session.get(Departamentos.class, codDepar);
                departamento.setNumAsig((int) numAsig);
                session.update(departamento);
            }

            // Actualizar NOTA_MEDIA de los alumnos
            Query<Object[]> alumnosQuery = session.createQuery(
                "SELECT a.numAlumno, COALESCE(AVG(e.nota), 0) " +
                "FROM Alumnos a LEFT JOIN a.evaluacioneses e " +
                "GROUP BY a.numAlumno", Object[].class);

            List<Object[]> alumnosResultados = alumnosQuery.getResultList();
            for (Object[] row : alumnosResultados) {
                int numAlumno = (int) row[0];
                BigDecimal notaMedia = BigDecimal.valueOf((Double) row[1]);

                Alumnos alumno = session.get(Alumnos.class, numAlumno);
                alumno.setNotaMedia(notaMedia);
                session.update(alumno);
            }

            // Commit de las transacciones
            session.getTransaction().commit();
            System.out.println("Actualizaciones realizadas correctamente.");

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Error durante las actualizaciones: " + e.getMessage());
        } finally {
            session.close();
        }
    }

	private static void mostrarCursos() {
	    Session session = factory.openSession();

	    String consultaCursos = "from Cursos";
	    List<Cursos> listaCursos = session.createQuery(consultaCursos, Cursos.class).list();

	    for (Cursos c : listaCursos) {
	        System.out.println("COD-CURSO: " + c.getCodCurso() + "     NOMBRE CURSO: " + c.getDenominacion());
	        System.out.println("NOMBRE CENTRO: " + c.getCentros().getNombre() + "    LOCALIDAD: " + c.getCentros().getLocalidad());

	        System.out.printf("\t\n %20s %30s %10s %10s %10s %10s\n", "NUM ALUMNO", "NOMBRE", "NOTA 1º EV", "NOTA 2º EV", "NOTA 3º EV", "NOTA MEDIA");
	        System.out.printf("\t %20s %30s %10s %10s %10s %10s\n", "----------------", "---------------------------", "----------", "---------", "---------", "---------");

	        // Consulta HQL para obtener datos en una sola consulta
	        String consultaAlumnosConNotas = """
	            SELECT a.numAlumno, a.nombre,
	                   AVG(CASE WHEN e.id.codEvaluacion = 1 THEN e.nota ELSE NULL END) AS nota1,
	                   AVG(CASE WHEN e.id.codEvaluacion = 2 THEN e.nota ELSE NULL END) AS nota2,
	                   AVG(CASE WHEN e.id.codEvaluacion = 3 THEN e.nota ELSE NULL END) AS nota3,
	                   AVG(e.nota) AS notaMedia
	            FROM Alumnos a
	            LEFT JOIN Evaluaciones e ON a.numAlumno = e.alumnos.numAlumno
	            WHERE a.cursos = :curso
	            GROUP BY a.numAlumno, a.nombre
	        """;

	        List<Object[]> resultados = session.createQuery(consultaAlumnosConNotas, Object[].class)
	                                           .setParameter("curso", c)
	                                           .list();

	        double media1Ev = 0;
	        double media2Ev = 0;
	        double media3Ev = 0;
	        double mediaTotalFinal = 0;
	        int contMedias = 0;
	        String nombreMayorNota = "";
	        double mayorNota = 0;

	        for (Object[] fila : resultados) {
	            int numAlumno = (int) fila[0];
	            String nombre = (String) fila[1];
	            double nota1 = fila[2] != null ? (double) fila[2] : 0.0;
	            double nota2 = fila[3] != null ? (double) fila[3] : 0.0;
	            double nota3 = fila[4] != null ? (double) fila[4] : 0.0;
	            double notaMedia = fila[5] != null ? (double) fila[5] : 0.0;

	            // Acumular para estadísticas generales
	            contMedias++;
	            media1Ev += nota1;
	            media2Ev += nota2;
	            media3Ev += nota3;
	            mediaTotalFinal += notaMedia;

	            // Determinar el alumno con la mayor nota media
	            if (notaMedia > mayorNota) {
	                mayorNota = notaMedia;
	                nombreMayorNota = nombre;
	            }

	            System.out.printf("\t %20s %30s %10.2f %10.2f %10.2f %10.2f\n", numAlumno, nombre, nota1, nota2, nota3, notaMedia);
	        }

	        // Mostrar estadísticas generales
	        System.out.printf("\t %20s %30s %10s %10s %10s %10s\n", "----------------", "---------------------------", "----------", "---------", "---------", "---------");
	        System.out.printf("\t %20s %30s %10.2f %10.2f %10.2f %10.2f\n", "NOTAS MEDIAS:", "", media1Ev / contMedias, media2Ev / contMedias, media3Ev / contMedias, mediaTotalFinal / contMedias);
	        System.out.println("\tALUMNO CON MAYOR NOTA: " + nombreMayorNota);
	    }

	    session.close();
	}

	private static void insertarEvaluacion(int codEv, int codAlum, int codAsig, int nota) {		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(codEv > 0 && codEv <=3) {
			if(existeAlumno(codAlum)) {
				if(nota > 0 && nota <= 10) {
					if(existeAsignatura(codAsig)) {
						EvaluacionesId evalId=new EvaluacionesId(codEv, codAlum, codAsig);
						Evaluaciones nuevo=new Evaluaciones(evalId, session.get(Alumnos.class, codAlum)
								, session.get(Asignaturas.class, codAsig), new BigDecimal(nota));
						
						session.persist(nuevo);
						tx.commit();
						System.out.println("\nEMPLEADO INSERTADO CORRECTAMENTE...\n");
					} else {
						System.out.println("ASIGNATURA NO EXISTE EN LA BASE DE DATOS\n");
					}
					
				} else {
					System.out.println("NOTA NO VÁLIDA. DEBE ESTAR ENTRE 1 Y 10\n");
				}
				
			} else {
				System.out.println("EL ALUMNO "+codAlum+" NO EXISTE\n");
			}
			
		// EVALUACIÓN NO VÁLIDA
		} else {
			System.out.println("EVALUACIÓN NO VÁLIDA. DEBE ESTAR ENTRE 1 Y 3\n");
		}
			
		session.close();
	}

	private static boolean existeAsignatura(int codAsig2) {
		Session session=factory.openSession();
		boolean existe=false;
		
		String consulta="from Asignaturas e where e.codAsig=:codAsig2";		 
		Asignaturas asinatura=(Asignaturas) session.createQuery(consulta, Asignaturas.class).setParameter("codAsig2", codAsig2).uniqueResult();
		if(asinatura != null) {
			existe=true;
		}
		
		return existe;
	}

	private static boolean existeAlumno(int codAlum) {
		Session session=factory.openSession();
		boolean existe=false;
		
		String consulta="from Alumnos e where e.numAlumno=:codAlum";		 
		Alumnos alumno=(Alumnos) session.createQuery(consulta, Alumnos.class).setParameter("codAlum", codAlum).uniqueResult();
		if(alumno != null) {
			existe=true;
		}
		
		return existe;
	}

	private static void realizarConsultas() {
		Session session = factory.openSession();

		// PRIMERA CONSULTA
		String consultaHQL1 = "SELECT e.codigoetapa," + "       e.km," + "       e.pobsalida," + "       e.pobllegada,"
				+ "       c.nombreciclista" + "	FROM Etapas e" + "	JOIN e.ciclistas c"
				+ "	WHERE (e.tipoetapa LIKE 'Media Montaña' OR e.tipoetapa LIKE 'Montaña')"
				+ "	  AND e.pobsalida = e.pobllegada";

		Query<Object[]> query1 = session.createQuery(consultaHQL1, Object[].class);
		List<Object[]> listaObjectos1 = query1.list();

		System.out.printf("%8s %10s %20s %20s %20s\n", "CODIGO", "KM", "POBLACIÓN SAL", "POBLACIÓN LLEG", "NOMBRE");
		System.out.printf("%8s %10s %20s %20s %20s\n", "-------", "-------", "---------", "---------", "------------");

		for (Object[] o : listaObjectos1) {
			System.out.printf("%8s %10s %20s %20s %20s\n", o[0], o[1], o[2], o[3], o[4]);
		}
		System.out.println("\n\n");
	}

	private static void menu() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("OPERACIONES CON PROYECTOS. Realizado por Alfonso Rincón");
		System.out.println("1. EJERCICIO 1: Insertar evaluaciones");
		System.out.println("2. EJERCICIO 2: Actualizar contadores");
		System.out.println("3. EJERCICIO 3: Mostrar datos de todos los cursos");
		System.out.println("4. EJERCICIO 4: Mostrar estadísticas de centros");
		System.out.println("5. EJERCICIO 5: Realizar consultas");
		System.out.println("6. Salir");
		System.out.println("-------------------------------------------------------------");
	} 
}
