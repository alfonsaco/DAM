package Examen;

public class Consejos {
	/*
	 * 	1. Hacer un try catch para cada consulta u orden. No meterlo todo en el mismo.
	 *     Por ejemplo, tienes que crear una tabla, y luego hacer un ALTER. Pues lo haces 
	 *     en 2 ptry catch
	 *     
	 *  2. Cuando se crea una tabla, hay que ponerle una PK con el ALTER table
	 *  
	 *  3. Cerrar los "sent" y "rset" con close()
	 * 	
	 *  4. NO PONER LAS ' ' EN LOS LIKE. ES DECIR:
	 *  	String consulta3="select tasa from paises where codpais like ?";	
	 *     SI POR CASUALIDAD PUSIESEMOS COMILLAS EN LIKE, ROLLO LIKE '?', NOS VA A DAR UN ERROR DE ESTE TIPO:
	 *     	
	 *     java.sql.SQLException: Índice de columna no válido
	 * 
	 *  5. Cuando haga las verificaciones de si existe o no, recordar devoler "existe,", no false o true
	 * 
	 * 	-----------------------------------------------------------------------
	 * 				    			BORRAR COLUMNA
	 *  -----------------------------------------------------------------------
	 *  		  ALTER TABLE PRODUCTOS DROP COLUMN STOCKACTUALIZADO
	 * 
	 *  
	 *  -----------------------------------------------------------------------
	 *  							  COALESCE( ,0)
	 *  -----------------------------------------------------------------------
	 *       Sirve para evitar coger NULL. Si sale null, se sustituye por 0
	 */
}
