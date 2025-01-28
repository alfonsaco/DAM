package Clases;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import Clases.*;
import java.util.List;
import org.neodatis.odb.Objects; 
import java.util.ArrayList;
public class ListarProyecto {
    public static void listarProyecto(int codigoProyecto) {
        String dbFilePath = "proyectos.dat";
        ODB odb = ODBFactory.open(dbFilePath);
        // Buscar el proyecto por código
        Objects<Proyectos> proyectosNeodatis = odb.getObjects(Proyectos.class);
        Proyectos proyectoBuscado = null;
        // Iterar sobre los resultados para buscar el proyecto deseado
        for (Proyectos proyecto : proyectosNeodatis) {
            if (proyecto.getCodigoproyecto() == codigoProyecto) {
                proyectoBuscado = proyecto;
                break;
            }
        }

        if (proyectoBuscado == null) {
            System.out.println("El proyecto con código " + codigoProyecto + " no existe.");
        } else {
        	int sumAportaciones=0;
        	double sumImporte=0;
        	double importe=0;
        	
            // Mostrar los datos del proyecto
            System.out.println("\n--------------------------------------------------------------------");
            System.out.printf("%-30s %-40s %n", "Código Proyecto: " + proyectoBuscado.getCodigoproyecto(), "Nombre: " + proyectoBuscado.getNombre());
            System.out.printf("%-30s %-40s %n", "Fecha Inicio: " + proyectoBuscado.getFechainicio(), "Fecha Fin: " + proyectoBuscado.getFechafin());
            System.out.printf("%-30s %-40s %n", "Presupuesto: " + proyectoBuscado.getPresupuesto(), "Extraaportación: " + proyectoBuscado.getExtraaportacion());            
            System.out.println("--------------------------------------------------------------------");

            // Mostrar los participantes                               
            System.out.println("Participantes en el proyecto:");
            System.out.println("-----------------------------------");
            System.out.printf("%-20s %20s %-20s %20s %20s %20s %n","CODPARTICIPACION", "CODESTUDIANTE", "NOMBREESTUDIANTE", "TIPOPARTICIPACION", "NUMAPORTACIONES", "IMPORTE");
            System.out.printf("%-20s %20s %-20s %20s %20s %20s %n","-----------------","------------------","-----------------","--------------", "--------------","--------------");
            for (Participa p : proyectoBuscado.getParticipantes()) {
                System.out.printf("%-20s %20s %-20s %20s %20s %20s %n",
                        p.getCodparticipacion(), p.getEstudiante().getCodestudiante(),
                        p.getEstudiante().getNombre(), p.getTipoparticipacion(),
                        p.getNumaportaciones(), p.getNumaportaciones()*proyectoBuscado.getExtraaportacion()+"€");
                
                sumAportaciones+=p.getNumaportaciones();
                sumImporte+=p.getNumaportaciones()*proyectoBuscado.getExtraaportacion();
            }
            System.out.printf("%-20s %20s %-20s %20s %20s %20s %n","--------------","--------------","--------------" ,"--------------","--------------","--------------");
            System.out.printf("%-20s %20s %-20s %20s %20s %20s %n%n","TOTALES: ","", "","",sumAportaciones, sumImporte+"€");
        }

        odb.close();
    }
}
