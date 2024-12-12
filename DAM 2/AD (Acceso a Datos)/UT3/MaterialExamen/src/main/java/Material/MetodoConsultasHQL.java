package Material;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class MetodoConsultasHQL {
	private static SessionFactory factory;

	// MÉTODO PARA MOSTRAR LAS 4 CONSULTAS HQL
	private static void mostrarConsultasHQL() {
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

		// SEGUNDA CONSULTA
		String consultaHQL2 = "SELECT c.codigociclista," + "	       c.nombreciclista," + "	       e.codigoetapa,"
				+ "	       e.tipoetapa," + "	       t.codigotramo," + "	       t.nombretramo,"
				+ "	       t.categoria" + "	FROM Ciclistas c" + "	JOIN c.etapases e" + "	JOIN c.tramospuertoses t"
				+ "	WHERE t.pendiente LIKE '%5,5%'" + "	ORDER BY c.codigociclista";

		Query<Object[]> query2 = session.createQuery(consultaHQL2, Object[].class);
		List<Object[]> listaObjectos2 = query2.list();

		System.out.printf("%8s %20s %20s %20s %20s %20s %20s\n", "CODIGO", "NOMBRE", "COD ETAPA", "TIPO ETAPA",
				"COD TRAMO", "NOMBRE TRAMO", "CATEGORIA");
		System.out.printf("%8s %20s %20s %20s %20s %20s %20s\n", "-------", "-------", "---------", "---------",
				"-------------", "------------", "------------");

		for (Object[] o : listaObjectos2) {
			System.out.printf("%8s %20s %20s %20s %20s %20s %20s\n", o[0], o[1], o[2], o[3], o[4], o[5], o[6]);
		}
		System.out.println("\n\n");

		// TERCERA CONSULTA
		String consultaHQL3 = "SELECT q.codigoequipo," + "    c.nombreciclista," + "    q.nombreequipo,"
				+ "    COUNT(i.codigocamiseta)" + "	FROM ResumenCamisetas x" + "	JOIN x.ciclistas c"
				+ "	JOIN x.camisetas i" + "	JOIN x.equipos q" + "	WHERE i.color LIKE '%Lunares%'"
				+ "	GROUP BY q.codigoequipo, c.nombreciclista, q.nombreequipo"
				+ "	ORDER BY q.codigoequipo, c.nombreciclista";

		Query<Object[]> query3 = session.createQuery(consultaHQL3, Object[].class);
		List<Object[]> listaObjectos3 = query3.list();

		System.out.printf("%8s %20s %20s %20s \n", "CODIGO", "NOMBRE", "NOMBRE EQUIPO", "NÚMERO CICLISTAS");
		System.out.printf("%8s %20s %20s %20s \n", "-------", "----------", "------------", "------------");

		for (Object[] o : listaObjectos3) {
			System.out.printf("%8s %20s %20s %20s \n", o[0], o[1], o[2], o[3]);
		}
		System.out.println("\n\n");

		// CUARTA CONSULTA
		String consultaHQL4 = "SELECT q.codigoequipo," + "       q.nombreequipo," + "       i.codigocamiseta,"
				+ "       i.color AS color," + "       COUNT(i.codigocamiseta)" + "	FROM ResumenCamisetas r"
				+ "	JOIN r.equipos q" + "	JOIN r.camisetas i"
				+ "	GROUP BY q.codigoequipo, q.nombreequipo, i.codigocamiseta, i.color";

		Query<Object[]> query4 = session.createQuery(consultaHQL4, Object[].class);
		List<Object[]> listaObjectos4 = query4.list();

		System.out.printf("%8s %20s %20s %20s %20s\n", "CODIGO EQUIPO", "NOMBRE EQUIPO", "COD CAMISETA", "COLOR",
				"VECES");
		System.out.printf("%8s %20s %20s %20s %20s\n", "--------------", "------------", "-------------", "---------",
				"------------");

		for (Object[] o : listaObjectos4) {
			System.out.printf("%8s %20s %20s %20s %20s\n", o[0], o[1], o[2], o[3], o[4]);
		}
		System.out.println("\n\n");

		session.close();

	}
}
