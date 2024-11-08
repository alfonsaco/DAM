package Examen;

import java.sql.*;

public class Funcion {
	
	static Connection conexion=ConexionOracle.getOracle(null, null);
	
	private static void ejeciciooficinas(String codofi) {
		//
		// COD OFICINA CIUDAD PAIS REGION DIRECCION1 NUM EMPLES
		// ----------- ---------------- ----------------- -----------------
		// ---------------- ----------

		String llamad = "{ ? = call veroficina(?,?,?,?,?) }";
		System.out.printf("%12s %-30s %-50s %-50s %-50s %10s %n", "COD OFICINA", "CIUDAD", "PAIS", "REGION",
				"DIRECCION1", "NUM EMPLES");
		System.out.printf("%12s %-30s %-50s %-50s %-50s %10s %n", "------------", "------------------------",
				"------------------------", "------------------------", "------------------------", "----------");

		CallableStatement llamada;
		try {
			llamada = conexion.prepareCall(llamad);

			// Dar valor a los argumentos
			llamada.registerOutParameter(1, Types.INTEGER); // contador
			llamada.setString(2, codofi); // oficina
			llamada.registerOutParameter(3, Types.VARCHAR);// ciudad
			llamada.registerOutParameter(4, Types.VARCHAR); // pais
			llamada.registerOutParameter(5, Types.VARCHAR); // Región
			llamada.registerOutParameter(6, Types.VARCHAR); // dirección 1

			// Ejecutar el procedimiento
			llamada.executeUpdate();
			// mostrar datos
			System.out.printf("%12s %-30s %-50s %-50s %-50s %10s %n", codofi, llamada.getString(3),
					llamada.getString(4), llamada.getString(5), llamada.getString(6), llamada.getInt(1));

			llamada.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
