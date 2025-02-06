package empledep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OracleDAOFactory extends DAOFactory {
    static Connection conexion = null;
    static String DRIVER = "";
    static String URLDB = "";
    static String USUARIO = "EJEMPLO";
    static String CLAVE = "ejemplo";

    public OracleDAOFactory() {
        DRIVER = "oracle.jdbc.driver.OracleDriver";
        URLDB = "jdbc:oracle:thin:@localhost:1521:XE";
    }

    // crear la conexión si no está creada
    public static Connection crearConexion() {
      if (conexion == null) {
        try {
           Class.forName(DRIVER); // Cargar el driver
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(OracleDAOFactory.class.getName()).
                   log(Level.SEVERE, null, ex);
        }

        try {
           conexion = DriverManager.getConnection
                          (URLDB, USUARIO, CLAVE);
        } catch (SQLException ex) {
           System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n");
           System.out.printf("Mensaje   : %s %n", ex.getMessage());
           System.out.printf("SQL estado: %s %n", ex.getSQLState());
           System.out.printf("Cód error : %s %n", ex.getErrorCode());
        }
      }
      return conexion;
    }
    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new OracleDepartamentoImpl();
    }

}
