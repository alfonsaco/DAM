package Examen;

public class PosibleRespuesta {/*
	// Método para visualizar los proyectos y estudiantes según un código de entidad
	private static void visualizarEntidad(int codEntidad) {
	    if (entidadExiste(codEntidad)) {
	        String obtenerInfoEntidad = "SELECT descripcion, direccion FROM entidades WHERE codentidad=?";
	        String numProyectos = "SELECT COUNT(*) FROM proyectos p JOIN patrocina pa ON p.codigoproyecto = pa.codigoproyecto WHERE pa.codentidad=?";
	        
	        try {
	            java.sql.PreparedStatement sent1 = conexion.prepareStatement(numProyectos);
	            sent1.setInt(1, codEntidad);
	            ResultSet rset2 = sent1.executeQuery();
	            rset2.next();
	            int numProyectos = rset2.getInt(1);
	            
	            java.sql.PreparedStatement sent = conexion.prepareStatement(obtenerInfoEntidad);
	            sent.setInt(1, codEntidad);
	            ResultSet rset = sent.executeQuery();
	            rset.next();
	            
	            System.out.println("\n------------------------------------------------------------------------------------");
	            System.out.println("COD-ENTIDAD: " + codEntidad + "                                    DESCRIPCIÓN: " + rset.getString(1));
	            System.out.println("DIRECCIÓN: " + rset.getString(2) + "             NÚMERO DE PROYECTOS: " + numProyectos);
	            System.out.println("-------------------------------------------------------------------------------------");
	            
	            visualizarProyectos(codEntidad);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	    } else {
	        System.out.println("LA ENTIDAD NO EXISTE");
	    }
	}

	// Método para visualizar los proyectos patrocinados por la entidad
	private static void visualizarProyectos(int codEntidad) {
	    String consultaProyectos = "SELECT p.codigoproyecto, p.nombre, p.fechainicio, p.fechafin FROM proyectos p " +
	                               "JOIN patrocina pa ON p.codigoproyecto = pa.codigoproyecto " +
	                               "WHERE pa.codentidad=?";
	    
	    try {
	        java.sql.PreparedStatement sent = conexion.prepareStatement(consultaProyectos);
	        sent.setInt(1, codEntidad);
	        ResultSet rset = sent.executeQuery();
	        
	        while (rset.next()) {
	            System.out.println("\tCOD-PROYECTO: " + rset.getInt(1) + "    NOMBRE: " + rset.getString(2) + 
	                               "    FECHA INICIO: " + rset.getDate(3) + "    FECHA FIN: " + rset.getDate(4));
	            visualizarEstudiantes(rset.getInt(1));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Método para visualizar los estudiantes de cada proyecto
	private static void visualizarEstudiantes(int codProyecto) {
	    String consultaEstudiantes = "SELECT e.codestudiante, e.nombre, e.direccion, e.tlf FROM estudiantes e " +
	                                 "JOIN participa pa ON e.codestudiante = pa.codestudiante " +
	                                 "WHERE pa.codigoproyecto=?";
	    
	    try {
	        java.sql.PreparedStatement sent = conexion.prepareStatement(consultaEstudiantes);
	        sent.setInt(1, codProyecto);
	        ResultSet rset = sent.executeQuery();
	        
	        while (rset.next()) {
	            System.out.println("\t\tCOD-ESTUDIANTE: " + rset.getInt(1) + "    NOMBRE: " + rset.getString(2) + 
	                               "    DIRECCIÓN: " + rset.getString(3) + "    TELÉFONO: " + rset.getString(4));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Método auxiliar para verificar si una entidad existe
	private static boolean entidadExiste(int codEntidad) {
	    String consultaExistencia = "SELECT COUNT(*) FROM entidades WHERE codentidad=?";
	    
	    try {
	        java.sql.PreparedStatement sent = conexion.prepareStatement(consultaExistencia);
	        sent.setInt(1, codEntidad);
	        ResultSet rset = sent.executeQuery();
	        rset.next();
	        return rset.getInt(1) > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
*/
}
