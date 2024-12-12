package Material;

import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ExisteONo {
	private static SessionFactory factory;
	
	private static boolean equipoExiste(BigInteger codigo) {
		Session session=factory.openSession();
		boolean existe=false;
		
		String consulta="from Equipos e where e.codigoequipo=:codigo";
		// Pongo comentarios, porque sino da error, ya que no existe Equipos en este proyecto
//		Equipos equipo=(Equipos) session.createQuery(consulta, Equipos.class).setParameter("codigo", codigo).uniqueResult();
//		if(equipo != null) {
//			existe=true;
//		}
		
		return existe;
	}
}
