package Material;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
public class InsertarDatos {

	private static SessionFactory factory;

  	
 
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
	
	
	import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.math.BigInteger;
import java.util.List;

public class AlumnoService {

    public void agregarNuevosAlumnos() {
        // Abrir sesión y comenzar transacción
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // 1. Leer los datos de la tabla NUEVOSALUMNOS
            String hql = "FROM NuevosAlumnos";
            Query<NuevosAlumnos> query = session.createQuery(hql, NuevosAlumnos.class);
            List<NuevosAlumnos> nuevosAlumnos = query.getResultList();

            // 2. Recorrer la lista de nuevos alumnos
            for (NuevosAlumnos nuevoAlumno : nuevosAlumnos) {
                // 2.1 Comprobar si el código del alumno ya existe en la tabla ALUMNOS
                Alumnos alumnoExistente = session.get(Alumnos.class, nuevoAlumno.getCodalum());
                if (alumnoExistente != null) {
                    // Si ya existe, asignamos un nuevo código que sea el mayor de los códigos actuales + 1
                    Query<BigInteger> maxCodalumQuery = session.createQuery("SELECT MAX(codalum) FROM Alumnos", BigInteger.class);
                    BigInteger maxCodalum = maxCodalumQuery.uniqueResult();
                    nuevoAlumno.setCodalum(maxCodalum.add(BigInteger.ONE));
                    System.out.println("Se ha asignado un nuevo código al alumno " + nuevoAlumno.getNombre() + ": " + nuevoAlumno.getCodalum());
                }

                // 2.2 Comprobar si el nombre ya existe en la tabla ALUMNOS
                Query<Long> nombreExistenteQuery = session.createQuery("SELECT COUNT(a) FROM Alumnos a WHERE a.nombre = :nombre", Long.class);
                nombreExistenteQuery.setParameter("nombre", nuevoAlumno.getNombre());
                long count = nombreExistenteQuery.uniqueResult();
                if (count > 0) {
                    System.out.println("El alumno " + nuevoAlumno.getNombre() + " ya existe en la base de datos.");
                    continue; // Si el nombre ya existe, no lo insertamos
                }

                // 2.3 Asignar representante y curso según la ciudad
                BigInteger codrepresentante;
                BigInteger codcurso;
                if ("Talavera".equalsIgnoreCase(nuevoAlumno.getPoblacion())) {
                    codrepresentante = BigInteger.ONE;  // Representante código 1
                    codcurso = BigInteger.ONE;  // Curso código 1
                    System.out.println("Alumno de Talavera: " + nuevoAlumno.getNombre() + " asignado con representante 1 y curso 1.");
                } else if ("Toledo".equalsIgnoreCase(nuevoAlumno.getPoblacion())) {
                    codrepresentante = BigInteger.valueOf(8);  // Representante código 8
                    codcurso = BigInteger.valueOf(4);  // Curso código 4
                    System.out.println("Alumno de Toledo: " + nuevoAlumno.getNombre() + " asignado con representante 8 y curso 4.");
                } else {
                    codrepresentante = BigInteger.valueOf(11);  // Representante código 11
                    codcurso = BigInteger.valueOf(5);  // Curso código 5
                    System.out.println("Alumno de otra ciudad: " + nuevoAlumno.getNombre() + " asignado con representante 11 y curso 5.");
                }

                // 2.4 Insertar el nuevo alumno en la tabla ALUMNOS
                Alumnos nuevoAl = new Alumnos();
                nuevoAl.setCodalum(nuevoAlumno.getCodalum());
                nuevoAl.setNombre(nuevoAlumno.getNombre());
                nuevoAl.setDireccion(nuevoAlumno.getDireccion());
                nuevoAl.setPoblacion(nuevoAlumno.getPoblacion());
                nuevoAl.setTelef(nuevoAlumno.getTelef());

                // Asignar el curso y representante
                Cursos curso = session.get(Cursos.class, codcurso);
                Alumnos representante = session.get(Alumnos.class, codrepresentante);
                nuevoAl.setCursos(curso);  // Curso
                nuevoAl.setAlumnos(representante);  // Representante

                // Guardar el nuevo alumno
                session.save(nuevoAl);
                System.out.println("Alumno " + nuevoAlumno.getNombre() + " insertado correctamente.");

            }

            // Confirmar la transacción
            transaction.commit();

        } catch (Exception e) {
            // En caso de error, hacer rollback de la transacción
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar la sesión
            session.close();
        }
    }
}

Realiza un método que obtenga por pantalla las asignaturas que se imparten en cada curso.
El informe por curso debe visualizar la siguiente información (Se deben de visualizar todos los cursos, si no tiene
asignaturas, que se indique que no tiene):
CODCURSO: ……………………………… DENOMINACIÓN:……………………
PRECIO: …………… NIVEL: ………………………
Número de alumnos: ……… Número de asignaturas: …….
CODASIG NOMBREASIG PRECIOASIG TIPOASIG %INCREMENTO NUM_ALUMNOS TOTALASIG
--------- -------------- ------------ -------- ----------- ------------ ----------
xxxxxx xxxxxxxxxx xxxxxxxxx xxx xxxxxxx xxxxxxxx xxxxxxxx
xxxxxx xxxxxxxxxx xxxxxxxxx xxx xxxxxxx xxxxxxxx xxxxxxxx
------------------------------------------------------------------------------------------
TOTALES: xxxxxxx xxxxxxxx
Donde:
INCREMENTO: se debe de calcular un porcentaje de subida que se sumará al precio de la asignatura (PRECIOASIG),
y que depende del tipo de asignatura TIPOASIG. Así pues el INCREMENTO se calcula de la siguiente manera:
 Si el tipo es A el INCREMENTO es el 5% del PRECIOASIG,
si el tipo es B el INCREMENTO es el 6% del PRECIOASIG,
si el tipo es C el INCREMENTO será del 8% del PRECIOASIG,
y si es D debe ser del 10%.
NUM_ALUMNOS es el número de alumnos que se han matriculado en esa asignatura
TOTALASIG es el número de alumnos de la asignatura (NUM_ALUMNOS) por el precio de la asignatura
(PRECIOASIG) + el INCREMENTO calculado
TOTALES: se debe ir acumulando el NUM_AUMNOS, y el TOTALASIG de las asignaturas del curso.
(Datos de cursos 0,5 puntos, datos de asignaturas por curso 1 punto, cálculos de asignaturas 1 punto, totales 0,5 puntos)
Por ejemplo, para el Curso 1, la salida será esta:
--------------------------------------------------------------------------
CODCURSO: 1 DENOMINACIÓN: Lenguajes
PRECIO: 200 NIVEL: Iniciación
Número de alumnos: 2 Número de asignaturas: 5
CODASI NOMBRE ASIGNATURA PVPASI TIPOASI %INCREMENT NUM_ALUMNS TOTALASIG
------ -------------------- ------ ------- ---------- ---------- ----------
 1 Sistemas 80 A 4.0 1 84,00
 2 BBDD 50 A 2.5 2 105,00
 3 JAVA 70 B 4.2 2 148,40
 4 XQL 80 B 4.8 2 169,60
 7 C++ 30 C 2.4 2 64,80
------ -------------------- ------ ------- ---------- ---------- ----------
TOTALES=> 9 571,80

}
*/