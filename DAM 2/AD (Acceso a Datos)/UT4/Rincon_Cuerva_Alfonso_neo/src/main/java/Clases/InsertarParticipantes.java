package Clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class InsertarParticipantes {

    public static void insertarParticipacion(int codEstudiante, int codProyecto, String tipoParticipacion, int numAportaciones) {
        String dbFilePath = "proyectos.dat";
        ODB odb = ODBFactory.open(dbFilePath);

        Estudiantes estudiante = null;
        Proyectos proyecto = null;

        // Buscar estudiante
        Objects<Estudiantes> estudiantes = odb.getObjects(Estudiantes.class);
        for (Estudiantes e : estudiantes) {
            if (e.getCodestudiante() == codEstudiante) {
                estudiante = e;
                break;
            }
        }
        // Buscar proyecto
        Objects<Proyectos> proyectos = odb.getObjects(Proyectos.class);
        for (Proyectos p : proyectos) {
            if (p.getCodigoproyecto() == codProyecto) {
                proyecto = p;
                break;
            }
        }

        // Validar si estudiante o proyecto no existen
        if (estudiante == null || proyecto == null) {
            System.out.println("Estudiante o proyecto no encontrados. No se puede insertar la participación.\n");
            odb.close();
            return;
        }

        // Crear nueva participación
        int nuevoCodParticipacion = odb.getObjects(Participa.class).size() + 1;
        Participa nuevaParticipacion = new Participa(nuevoCodParticipacion, estudiante, proyecto, tipoParticipacion, numAportaciones);
        
        // Actualizar las listas
        estudiante.getParticipaen().add(nuevaParticipacion);
        proyecto.getParticipantes().add(nuevaParticipacion);

        // Guardar cambios en la BD
        odb.store(estudiante);
        odb.store(proyecto);
        odb.store(nuevaParticipacion);

        System.out.println("Participación añadida exitosamente.\n");
        odb.close();
    }
}
