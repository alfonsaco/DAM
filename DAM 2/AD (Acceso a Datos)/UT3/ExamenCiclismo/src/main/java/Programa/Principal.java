package Programa;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Clases.Equipos;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Principal {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		LogManager.getLogManager().reset();
		Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		globalLogger.setLevel(java.util.logging.Level.OFF);
		
		factory=Conexion.getSession(); 		
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				actualizarCamisetas();
				break;
				
			case 2:
				System.out.print("DAME EL CÓDIGO DE UN EQUIPO: ");
				BigInteger codigo=sc.nextBigInteger();
				resumenCiclistas(codigo);
				break;
				
			case 3:
				mostrarConsultasHQL();
				break;
				
			case 4:
				System.out.println("Se finalizó el programa");
				break;
			}
			
		} while (opcion != 4);
		
		
		factory.close();		
	}

	// MÉTODO PARA ACTUALIZAR LA TABLA DE RESUMEN_CAMISETAS
	private static void actualizarCamisetas() {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		System.out.println("Llenar tabla RESUMEN_CAMISETAS");
		String consultaDatosEquipos="FROM Equipos";
		String consultaDatosCamisetas="FROM ResumenCamisetas";
		
		// Pillamos la consulta de ResumenCamisetas, para verificar que no haya datos, y así poder hacer la inserción en cuestión
		Query<Clases.ResumenCamisetas> query=session.createQuery(consultaDatosCamisetas, Clases.ResumenCamisetas.class);
		List<Clases.ResumenCamisetas> listaCamisetas=query.list();
		// Si no hay datos, se hará la inserción
		if(listaCamisetas.size() == 0) {
			Query<Equipos> query1=session.createQuery(consultaDatosEquipos, Equipos.class);
			List<Equipos> listaEquipos=query1.list();
			
			for(Equipos e : listaEquipos) {
				System.out.printf("%n %-70s %20s %20s %20s %n","EQUIPO: "+e.getCodigoequipo()+", "+e.getNombreequipo(), "CAMISETA", "Nº VECES", "IMPORTE PREMIO");
				System.out.printf("%-70s %20s %20s %20s %n","---------------------------------------------------------","------------------","-----------------","-----------------");
				
				String consultaCiclistas="SELECT c.codigociclista,"
						+ "        c.nombreciclista,"
						+ "            l.camisetas.codigocamiseta, "
						+ "            COUNT(l.camisetas.codigocamiseta), "
						+ "            SUM(l.camisetas.importepremio) "
						+ "             FROM Ciclistas c "
						+ "             JOIN c.llevas l "
						+ "            JOIN l.camisetas x "
						+ "				JOIN c.equipos e"
						+ "GROUP BY c.codigociclista, c.nombreciclista, l.camisetas.codigocamiseta "
						+ "ORDER BY l.camisetas.codigocamiseta DESC";
				Query<Object[]> query2=session.createQuery(consultaCiclistas, Object[].class);
				List<Object[]> listaCiclistas=query2.list();
				
				for(Object[] c : listaCiclistas) {
					
					String resultado="INSERTADO"+c[0]+"   "+c[1]; 
				}
			}
		}

/*		
					String ope = "INSERTADO: "+c[0];
					String hql3 = "select c.importepremio from Camisetas c where c.codigocamiseta = :cod";
					BigInteger importe1 = session.createQuery(hql3, BigInteger.class).setParameter("cod", c[1]).uniqueResult();
					double imp = importe1.doubleValue();
					double premio = imp * Integer.parseInt(String.valueOf(c[2]));
					System.out.printf("%-40s %10s %10s %12s\n",ope,c[1], c[2], premio);
					ResumenCamisetas re = new ResumenCamisetas();
					String hql4 = "from Ciclistas c where c.nombreciclista = :nombre";
					Ciclistas cicli = (Ciclistas) session.createQuery(hql4, Ciclistas.class).setParameter("nombre", c[0]).uniqueResult();
					re.setImportepremio(BigInteger.valueOf((long) premio));
					re.setNumveces(BigInteger.valueOf((long) c[2]));
					re.setCamisetas(obtenerCamiseta((BigInteger) c[1]));
					re.setEquipos(obtenerEquipo(e.getCodigoequipo()));
					re.setCiclistas(obtenerCiclista(cicli.getCodigociclista()));
					ResumenCamisetasId res = new ResumenCamisetasId((BigInteger) c[1], cicli.getCodigociclista(), e.getCodigoequipo());
					re.setId(res);
					session.persist(re);
				}
			}
		}else {
			System.err.println("\nYa están todas las filas insertadas\n");
		}
		tx.commit();
		session.close();
		*/
	}

	// MÉTODO PARA LISTAR LOS CICLISTAS DE UN EQUIPO
	private static void resumenCiclistas(BigInteger codigo) {
		Session session=factory.openSession();
		
		if(equipoExiste(codigo)) {
			String consultaEquipos="from Equipos e where e.codigoequipo=:codigo";
			Equipos equipo=(Equipos) session.createQuery(consultaEquipos, Equipos.class).setParameter("codigo", codigo).uniqueResult();
			System.out.println("COD-EQUIPO: "+equipo.getCodigoequipo()+"    NOMBRE: "+equipo.getNombreequipo());
			
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
			
			System.out.println("PAÍS: "+equipo.getPais()+"   JEFE: "+nombreCiclista);
			
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

	// VERIFICAR SI EXISTE EL EQUIPO EN CUESTIÓN
	private static boolean equipoExiste(BigInteger codigo) {
		Session session=factory.openSession();
		boolean existe=false;
		
		String consulta="from Equipos e where e.codigoequipo=:codigo";
		Equipos equipo=(Equipos) session.createQuery(consulta, Equipos.class).setParameter("codigo", codigo).uniqueResult();
		if(equipo != null) {
			existe=true;
		}
		
		return existe;
	}

	// MÉTODO PARA MOSTRAR LAS 4 CONSULTAS HQL
	private static void mostrarConsultasHQL() {
		Session session=factory.openSession();
		
		// PRIMERA CONSULTA
		String consultaHQL1="SELECT e.codigoetapa,"
				+ "       e.km,"
				+ "       e.pobsalida,"
				+ "       e.pobllegada,"
				+ "       c.nombreciclista"
				+ "	FROM Etapas e"
				+ "	JOIN e.ciclistas c"
				+ "	WHERE (e.tipoetapa LIKE 'Media Montaña' OR e.tipoetapa LIKE 'Montaña')"
				+ "	  AND e.pobsalida = e.pobllegada";
		
		Query<Object[]> query1=session.createQuery(consultaHQL1, Object[].class);
		List<Object[]> listaObjectos1=query1.list();
					
		System.out.printf("%8s %10s %20s %20s %20s\n", "CODIGO","KM","POBLACIÓN SAL","POBLACIÓN LLEG", "NOMBRE");
		System.out.printf("%8s %10s %20s %20s %20s\n", "-------","-------","---------","---------", "------------");
		
		for(Object[] o : listaObjectos1) {
			System.out.printf("%8s %10s %20s %20s %20s\n", o[0], o[1], o[2], o[3], o[4]);
		}
		System.out.println("\n\n");
		
		// SEGUNDA CONSULTA
		String consultaHQL2="SELECT c.codigociclista,"
				+ "	       c.nombreciclista,"
				+ "	       e.codigoetapa,"
				+ "	       e.tipoetapa,"
				+ "	       t.codigotramo,"
				+ "	       t.nombretramo,"
				+ "	       t.categoria"
				+ "	FROM Ciclistas c"
				+ "	JOIN c.etapases e"
				+ "	JOIN c.tramospuertoses t"
				+ "	WHERE t.pendiente LIKE '%5,5%'"
				+ "	ORDER BY c.codigociclista";
		
		Query<Object[]> query2=session.createQuery(consultaHQL2, Object[].class);
		List<Object[]> listaObjectos2=query2.list();
					
		System.out.printf("%8s %20s %20s %20s %20s %20s %20s\n", "CODIGO","NOMBRE","COD ETAPA", "TIPO ETAPA","COD TRAMO", "NOMBRE TRAMO", "CATEGORIA");
		System.out.printf("%8s %20s %20s %20s %20s %20s %20s\n", "-------","-------","---------","---------","-------------", "------------", "------------");
		
		for(Object[] o : listaObjectos2) {
			System.out.printf("%8s %20s %20s %20s %20s %20s %20s\n", o[0], o[1], o[2], o[3], o[4], o[5], o[6]);
		}
		System.out.println("\n\n");
		
		
		// TERCERA CONSULTA
		String consultaHQL3="SELECT q.codigoequipo,"
				+ "    c.nombreciclista,"
				+ "    q.nombreequipo,"
				+ "    COUNT(i.codigocamiseta)"
				+ "	FROM ResumenCamisetas x"
				+ "	JOIN x.ciclistas c"
				+ "	JOIN x.camisetas i"
				+ "	JOIN x.equipos q"
				+ "	WHERE i.color LIKE '%Lunares%'"
				+ "	GROUP BY q.codigoequipo, c.nombreciclista, q.nombreequipo"
				+ "	ORDER BY q.codigoequipo, c.nombreciclista";
		
		Query<Object[]> query3=session.createQuery(consultaHQL3, Object[].class);
		List<Object[]> listaObjectos3=query3.list();
					
		System.out.printf("%8s %20s %20s %20s \n", "CODIGO","NOMBRE","NOMBRE EQUIPO","NÚMERO CICLISTAS");
		System.out.printf("%8s %20s %20s %20s \n", "-------","----------","------------","------------");
		
		for(Object[] o : listaObjectos3) {
			System.out.printf("%8s %20s %20s %20s \n", o[0], o[1], o[2], o[3]);
		}
		System.out.println("\n\n");
		
		// CUARTA CONSULTA
		String consultaHQL4="SELECT q.codigoequipo,"
				+ "       q.nombreequipo,"
				+ "       i.codigocamiseta,"
				+ "       i.color AS color,"
				+ "       COUNT(i.codigocamiseta)"
				+ "	FROM ResumenCamisetas r"
				+ "	JOIN r.equipos q"
				+ "	JOIN r.camisetas i"
				+ "	GROUP BY q.codigoequipo, q.nombreequipo, i.codigocamiseta, i.color";
		
		Query<Object[]> query4=session.createQuery(consultaHQL4, Object[].class);
		List<Object[]> listaObjectos4=query4.list();
					
		System.out.printf("%8s %20s %20s %20s %20s\n", "CODIGO EQUIPO","NOMBRE EQUIPO","COD CAMISETA","COLOR", "VECES");
		System.out.printf("%8s %20s %20s %20s %20s\n", "--------------","------------","-------------","---------", "------------");
		
		for(Object[] o : listaObjectos4) {
			System.out.printf("%8s %20s %20s %20s %20s\n", o[0], o[1], o[2], o[3], o[4]);
		}
		System.out.println("\n\n");
		
		session.close();
		
	}

	// MÉTODO PARA IMPRIMIR UN MENÚ
	private static void menu() {
		System.out.println();
		System.out.println("----- ELIGE UNA OPCIÓN -----");
		System.out.println("1. Rellenar Resumen__Camisetas");
		System.out.println("2. Listar ciclistas de un equipo");
		System.out.println("3. Consultas HQL");
		System.out.println("4. Salir");
		System.out.println();
	}
	
	/*
	 CONSULTAS REALIZADAS
	 
	 SELECT e.codigoetapa AS codigo,
       e.km AS km,
       e.pobsalida AS salida,
       e.pobllegada AS llegada,
       c.nombreciclista AS nombreCiclista
	FROM Etapas e
	JOIN e.ciclistas c
	WHERE (e.tipoetapa LIKE 'Media Montaña' OR e.tipoetapa LIKE 'Montaña')
	  AND e.pobsalida = e.pobllegada
	  
	  
	  SELECT c.codigociclista AS codigociclista,
       c.nombreciclista AS nombreciclista,
       e.codigoetapa AS codigoetapa,
       e.tipoetapa AS tipoetapa,
       t.codigotramo AS codigotramo,
       t.nombretramo AS nombretramo,
       t.categoria AS categoria
	FROM Ciclistas c
	JOIN c.etapases e
	JOIN c.tramospuertoses t
	WHERE t.pendiente LIKE '%5,5%'
	ORDER BY c.codigociclista
	
	
	SELECT e.codigoequipo, e.nombreequipo, x.codigocamiseta, x.color, count(x.codigocamiseta)
	FROM Equipos e JOIN e.resumenCamisetases j JOIN j.camisetas x 
	GROUP BY e.codigoequipo, e.nombreequipo, x.codigocamiseta, x.color
	 
	 */
	
}
