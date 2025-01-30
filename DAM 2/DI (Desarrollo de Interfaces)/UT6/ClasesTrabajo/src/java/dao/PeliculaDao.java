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
import model.Pelicula;

/**
 *
 * @author josec
 */
public class PeliculaDao {

    public static boolean registrar(Pelicula p) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            String SQL = "INSERT INTO Pelicula(PeliculaID) values(?)";
            con = conexion.conectar();

            if (con == null) {
                return false;
            }

            st = con.prepareStatement(SQL);
            st.setString(1, p.getNombre());

            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static ArrayList<Pelicula> listar() {

        ArrayList<Pelicula> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {

            String SQL = "SELECT * FROM Pelicula";
            con = conexion.conectar();

            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            resultado = st.executeQuery();

            while (resultado.next()) {

                Pelicula p = new Pelicula();

                p = new Pelicula();
                p.setNombre("nombre_pelicula");
                p.setGenero("genero_pelicula");
                lista.add(p);

            }

            return lista;

        } catch (SQLException ex) {

            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static String getCategoria(int cod) {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {

            String SQL = "select Nombre from Pelicula where PeliculaID=?";
            con = conexion.conectar();

            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            st.setInt(1, cod);
            resultado = st.executeQuery();

            if (resultado.next()) {
                return (resultado.getString("nombre_pelicula"));
            }

            return "--";

        } catch (SQLException ex) {

            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

}
