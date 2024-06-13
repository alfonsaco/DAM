package singelton;

import java.sql.ResultSet;

public class AppSingelton {
	
	public static void main(String[] args) {
		
		try {
			
			BD.getInstance().cargarParametrosConexionXML("config.xml");
			ResultSet rset = BD.getInstance().consultaBD("select count(*) from clientes");
			
			// Primera consulta
			if (rset.next()) {
				System.out.println("Hay "+rset.getString(1)+" clientes");
			}
			BD.getInstance().cerrarConsulta();
			
			// Segunda Consulta
			rset = BD.getInstance().consultaBD("select max(codigocliente) from clientes");
			if (rset.next()) {
				System.out.println("Código mayor = "+rset.getString(1));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
