/*
 *  En la tabla CLIENTES hay clientes que no tienen pedidos. Se desea hacer un método para eliminar los clientes que no han realizado pedidos. Los clientes borrados se deben de añadir a una tabla que el método tiene que crear. Esta tabla se llamará CLIENTESSINPEDIDO, tendrá la misma estructura que la tabla CLIENTES.
	El método a crear deberá crear la tabla CLIENTESSINPEDIDO, añadir a esa tabla los clientes sin pedidos, y eliminar de la tabla CLIENTES esos mismos clientes.
	El método se podrá ejecutar tantas veces como se desea. Hay que controlar todos los errores posibles.
	Visualizar todo en la consola, los errores que surjan y los clientes que se va insertando en la nueva tabla.

 */
package Examen;

import java.sql.Connection;
import java.sql.SQLException;

public class CrearTabla {
	// NO COPIAR ESTO
	static Connection conexion=ConexionOracle.getOracle(null, null);
	// NO COPIAR ESTO
	
	
	// Método para crear una tabla
	private static void crearTablaClientes() {
			/*
			 * 	create table clientessinpedido as 
			 * 		CREA LA TABLA
			 *  
			 *  select * from clientes where codigocliente not in (select codigocliente from pedidos) order by codigocliente
			 *  	A ESTA TABLA, LE AÑADE TODOS LOS REGISTROS QUE APARECEN CON LA CONSULTA
			 *  
			 */
		// Crear tabla, para meter ahí todos los clientes sin pedido
		String crear="create table clientessinpedido as "
				+ "select * from clientes where codigocliente not in (select codigocliente from pedidos) order by codigocliente";
		// Añadir PK a la table
		String alter="alter table clientessinpedido add constraint CSP_PK PRIMARY KEY (codigocliente)";
		// Borrar clientes sin pedidos de la tabla original (clientes)
		String borrar="delete from clientes where codigocliente not in (select codigocliente from pedidos)";
		
		try {
			java.sql.PreparedStatement sent = conexion.prepareStatement(crear);
			sent.executeUpdate();
			System.out.println("TABLA CLIENTESSINPEDIDO CREADA");
			System.out.println();
			
			sent= conexion.prepareStatement(alter);
			sent.executeUpdate();
			System.out.println("PK AGREGADA CON ÉXITO");
			System.out.println();

			sent= conexion.prepareStatement(borrar);
			sent.executeUpdate();
			System.out.println("CLIENTES SIN PEDIDOS BORRADOS EXITOSAMENTE");
			System.out.println();
			
			sent.close();
			
		} catch (SQLException e) {
			System.out.println("TABLA YA CREADA, REGISTROS YA BORRADOS");
		}
		
	}

}
