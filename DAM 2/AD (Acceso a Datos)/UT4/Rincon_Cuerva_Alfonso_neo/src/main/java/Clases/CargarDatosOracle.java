package Clases;


import Clases.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargarDatosOracle {

	// Método para obtener estudiantes
    public static List<Estudiantes> cargarEstudiantes() {
        List<Estudiantes> estudiantes = new ArrayList<>();
        // Consulta para obtener los estudiantes
        String consulta = "SELECT * FROM estudiantes";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
            	// Obtengo cada dato del estudiante
                int codEstudiante = rs.getInt("codestudiante");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String tlf = rs.getString("tlf");
                Date fechaAlta = rs.getDate("fechaalta");

                // Crear objeto Estudiantes y lo añadimos al List
                Estudiantes estudiante = new Estudiantes(codEstudiante, nombre, direccion, tlf, fechaAlta, new ArrayList<>());
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar estudiantes: " + e.getMessage());
        }

        return estudiantes;
    }

    // Método para obtener proyectos
    public static List<Proyectos> cargarProyectos() {
        List<Proyectos> proyectos = new ArrayList<>();
        String consulta = "SELECT * FROM proyectos";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                int codigoProyecto = rs.getInt("codigoproyecto");
                String nombre = rs.getString("nombre");
                Date fechaInicio = rs.getDate("fechainicio");
                Date fechaFin = rs.getDate("fechafin");
                float presupuesto = rs.getFloat("presupuesto");
                float extraAportacion = rs.getFloat("extraaportacion");

                // Crear objeto Proyectos
                Proyectos proyecto = new Proyectos(codigoProyecto, nombre, fechaInicio, fechaFin, presupuesto, extraAportacion, new ArrayList<>());
                proyectos.add(proyecto);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar proyectos: " + e.getMessage());
        }

        return proyectos;
    }
    
    // Método para obtener las participaciones
    public static List<Participa> cargarParticipaciones(List<Estudiantes> estudiantes, List<Proyectos> proyectos) {
        List<Participa> participaciones = new ArrayList<>();
        // Consulta para obtener las participaciones
        String consulta = "SELECT * FROM participa";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                int codParticipacion = rs.getInt("codparticipacion");
                int codEstudiante = rs.getInt("codestudiante");
                int codProyecto = rs.getInt("codigoproyecto");
                String tipoParticipacion = rs.getString("tipoparticipacion");
                int numAportaciones = rs.getInt("numaportaciones");

                // Buscar el estudiante
                Estudiantes estudiante = estudiantes.stream()
                        .filter(e -> e.getCodestudiante() == codEstudiante)
                        .findFirst()
                        .orElse(null);
                // Buscar el proyecto
                Proyectos proyecto = proyectos.stream()
                        .filter(p -> p.getCodigoproyecto() == codProyecto)
                        .findFirst()
                        .orElse(null);

                if (estudiante != null && proyecto != null) {
                    // Crear objeto Participa y lo añade a la lista correspondiente
                    Participa participacion = new Participa(codParticipacion, estudiante, proyecto, tipoParticipacion, numAportaciones);

                    estudiante.getParticipaen().add(participacion);
                    proyecto.getParticipantes().add(participacion);

                    // Añadir la participación a la lista de participaciones
                    participaciones.add(participacion);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar participaciones: " + e.getMessage());
        }

        return participaciones;
    }
}
