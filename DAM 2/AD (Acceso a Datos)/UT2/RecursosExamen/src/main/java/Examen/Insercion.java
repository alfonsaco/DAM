package Examen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insercion {
	static Connection conexion=ConexionOracle.getOracle("USUARIO", "CONTRA");

	private static void insertarEmpleado(String n, String a1p, String a2p, String ext, String email, String codOf,
			int codJefe, String puesto) {
		
		String mensaje="";
		int error=0;
		
//		if(!verificarJefe(codJefe)) {
//			mensaje+="CODJEFE NO DISPONIBLE";
//			error=1;
//		}
//		
//		if(!verificarOficina(codOf)) {
//			mensaje+="COD OFICiNA NO DISPONIBLE";
//			error=1;
//		}
		
		if(error == 0) {
			String insercion="insert into empleados values"+"(?,?,?,?,?,?,?,?,?)";
			String codigoMax="select max(codigoempleado+1) from empleados";
			
			java.sql.PreparedStatement sent;
			try {								
				sent=conexion.prepareStatement(codigoMax);				
				ResultSet res=sent.executeQuery(codigoMax);
				res.next();
				int codigoEmpleado=res.getInt(1);

				sent=conexion.prepareStatement(insercion);
				sent.setInt(1, codigoEmpleado);
				sent.setString(2, n);
				sent.setString(3, a1p);
				sent.setString(4, a2p);
				sent.setString(5, ext);
				sent.setString(6, email);
				sent.setString(7, codOf);
				sent.setInt(8, codJefe);
				sent.setString(9, puesto);

				int filas = sent.executeUpdate();
				
				System.out.println("INSERCIÓN REALIZADA CON ÉXITO");
				
				res.close();
				sent.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("ERROR, DATOS SE PUDO INSERTAR");
			System.out.println(mensaje);
		}
		
	}
}
