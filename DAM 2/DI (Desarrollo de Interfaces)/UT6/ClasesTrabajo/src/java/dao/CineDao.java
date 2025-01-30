/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cine;

/**
 *
 * @author josec
 */
public class CineDao {
    
    public static boolean registrar(Cine c) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            String SQL = "INSERT INTO cine(Nombre, Direccion) values(?, ?)";
            con = conexion.conectar();

            if (con == null) {
                return false;
            }

            st = con.prepareStatement(SQL);
            st.setString(1, c.getNombre());
            st.setString(2, c.getDirecion());

            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {

                if (st != null) {
                    st.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static ArrayList<Cine> listar() {

        ArrayList<Cine> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {

            String SQL = "SELECT * FROM Cine";
            con = conexion.conectar();

            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            resultado = st.executeQuery();

            

            while (resultado.next()) {

                Cine c = new Cine();
                
                c = new Cine();
                c.setNombre("nombre_cine");
                c.setDirecion("direccion_cine");
                lista.add(c);

            }

            return lista;

        } catch (SQLException ex) {

            Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } finally {

            try {

                if (resultado != null) {
                    resultado.close();
                }

                if (st != null) {
                    st.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static String getCine(int cod) {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {

            String SQL = "select nombre from categorias where CineID=?";
            con = conexion.conectar();

            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            st.setInt(1, cod);
            resultado = st.executeQuery();

            if (resultado.next()) {
                return (resultado.getString("nombre_cine"));
            }

            return "--";

        } catch (SQLException ex) {

            Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            return "--";

        } finally {

            try {

                if (resultado != null) {
                    resultado.close();
                }

                if (st != null) {
                    st.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }
    
    
}
