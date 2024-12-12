package Material;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;

public class MostrarElementosConCodigo {
	private static SessionFactory factory;
	
	private static void resumenCiclistas(BigInteger codigo) {
		Session session=factory.openSession();
		
		if(equipoExiste(codigo)) {
			String consultaEquipos="from Equipos e where e.codigoequipo=:codigo";
			//Equipos equipo=(Equipos) session.createQuery(consultaEquipos, Equipos.class).setParameter("codigo", codigo).uniqueResult();
			//System.out.println("COD-EQUIPO: "+equipo.getCodigoequipo()+"    NOMBRE: "+equipo.getNombreequipo());
			
			// Obtener el jefe del equipo
			String hql = "SELECT c.nombreciclista"
					+ "		             FROM Ciclistas c"
					+ "		             JOIN c.resumenCamisetases j"
					+ "		             JOIN j.equipos e"
					+ "		             WHERE e.codigoequipo=:codigo";
			Query<String> query = session.createQuery(hql, String.class);
			query.setParameter("codigo", codigo);
			String nombreCiclista = "";

			try {
			    nombreCiclista = query.uniqueResult();
			    
			} catch (NonUniqueResultException e) {
			    System.err.println("La consulta devolvió más de un resultado.");
			} catch (NoResultException e) {
			    System.err.println("No se encontró ningún resultado.");
			}
			
			//System.out.println("PAÍS: "+equipo.getPais()+"   JEFE: "+nombreCiclista);
			
			String consultaCiclistas = "SELECT c.codigociclista, c.nombreciclista, " +
                    "       COUNT(e.codigoetapa), COUNT(t.codigotramo), " +
                    "       (SELECT COUNT(l.camisetas.codigocamiseta) " +
                    "        FROM Lleva l " +
                    "        WHERE l.ciclistas.codigociclista = c.codigociclista) " +
                    "FROM Ciclistas c " +
                    "LEFT JOIN Etapas e ON c.codigociclista = e.ciclistas.codigociclista " +
                    "LEFT JOIN Tramospuertos t ON c.codigociclista = t.ciclistas.codigociclista " +
                    "WHERE c.equipos.codigoequipo = :codigo " +
                    "GROUP BY c.codigociclista, c.nombreciclista " +
                    "ORDER BY c.codigociclista";

			Query<Object[]> query2 = session.createQuery(consultaCiclistas, Object[].class)
			                         .setParameter("codigo", codigo);
			List<Object[]> lista = query2.list();
			
			if (lista.size() > 0) {
				System.out.printf("%10s %25s %10s %10s %15s\n", "CODIGO", "NOMBRE", "ETAPAS_WIN", "TRAMOS_GANADOS", "Nº VECES CAMISETA");
				System.out.printf("%10s %25s %10s %10s %15s\n", "---------", "-------------------------", "-----------", "-----------", "-------------------");
				
				int masGanadas=0;
				String nombreMasGanadas="";
				
				int montanaGanadas=0;
				String nombreMontanaGanadas="";
				
				for (Object[] ci : lista) {
					int numero=((Long) ci[2]).intValue();
					String nombre=(String) ci[1];
					if(masGanadas < numero) {
						masGanadas=numero;
						nombreMasGanadas=nombre;
					} else if(masGanadas == numero) {
						nombreMasGanadas+=(", "+nombre);
					}
					
					int numero2=((Long) ci[3]).intValue();
					String nombre2=(String) ci[1];
					if(montanaGanadas < numero2) {
						montanaGanadas=numero2;
						nombreMontanaGanadas=nombre2;
					} else if(montanaGanadas == numero2) {
						nombreMontanaGanadas+=(", "+nombre2);
					}
					
					System.out.printf("%10s %25s %8s %8s %15s\n", ci[0], ci[1], ci[2], ci[3], ci[4]);
				}
				System.out.println("--------------------------------------------------------------------------");				
				System.out.println("Nombre del corredor con más etapas ganadas: "+nombreMasGanadas);
				if(montanaGanadas <= 0) {
					System.out.print("Nombre del corredor con más tramo de montaña ganados: NO HAY");
				} else {
					System.out.print("Nombre del corredor con más tramo de montaña ganados: "+nombreMontanaGanadas);
				}											
				
			} else {
			System.out.println("No hay ciclistas para este equipo.");
			}
		}
		
		session.close();
	}
	
	// MÉTODO DE RELLENO
	private static boolean equipoExiste(BigInteger codigo) {
		// MÉTODO DE RELLENO
		return false;
	}

}
