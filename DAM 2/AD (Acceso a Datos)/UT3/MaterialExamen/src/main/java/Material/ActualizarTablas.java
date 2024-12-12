package Material;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ActualizarTablas {
	private static SessionFactory factory;
	
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
                //centro.setNumAlumnos((int) numAlumnos);
                //centro.setNumCursos((int) numCursos);
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
                //curso.setNumAlumnos((int) numAlumnos);
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
                //departamento.setNumAsig((int) numAsig);
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
                //alumno.setNotaMedia(notaMedia);
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
	
	public class Alumnos {
		
	}
	
	public class Centros {
		
	}
	
	public class Departamentos {
		
	}
	
	public class Cursos {
		
	}
}
