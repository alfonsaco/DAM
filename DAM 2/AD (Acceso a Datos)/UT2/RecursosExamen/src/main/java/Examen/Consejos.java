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
	 * 
	 * 
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
