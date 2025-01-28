package Clases;

import Clases.*;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import java.io.File;
import java.util.List;

public class CrearBD {

    // Método para crear la base de datos de NeoDatis, utilizando los métodos de CargarDatosOracle
    public static void transferirDatos() {
        String dbFilePath = "proyectos.dat";

        // Verificar si el archivo existe y eliminarlo
        File dbFile = new File(dbFilePath);
        if (dbFile.exists()) {
            if (dbFile.delete()) {
                System.out.println("Archivo existente eliminado: " + dbFilePath);
            } else {
                System.err.println("No se pudo eliminar el archivo existente: " + dbFilePath);
                return; // Salir si no se puede eliminar el archivo
            }
        }

        // Abrir conexión con Neodatis
        ODB odb = ODBFactory.open(dbFilePath);

        // Cargar datos desde Oracle
        List<Estudiantes> estudiantes = CargarDatosOracle.cargarEstudiantes();
        List<Proyectos> proyectos = CargarDatosOracle.cargarProyectos();
        List<Participa> participaciones = CargarDatosOracle.cargarParticipaciones(estudiantes, proyectos);

        // Guardar en Neodatis
        for (Estudiantes estudiante : estudiantes) {
            odb.store(estudiante);
        }

        for (Proyectos proyecto : proyectos) {
            odb.store(proyecto);
        }

        for (Participa participacion : participaciones) {
            odb.store(participacion);
        }

        System.out.println("Datos transferidos de Oracle a Neodatis exitosamente.\n");
        odb.close();
    }
}