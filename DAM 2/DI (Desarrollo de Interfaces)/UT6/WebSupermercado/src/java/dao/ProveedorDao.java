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
import model.Proveedor;

/**
 *
 * @author Alfonso
 */
public class ProveedorDao {

    public static boolean registrar(Proveedor p) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            String SQL = "INSERT INTO proveedores (nit, nombre, telefono, direccion, correo)"
                    + " VALUES (?, ?, ?, ?, ?);";

            con = conexion.conectar();

            if (con == null) {
                return false;
            }

            st = con.prepareStatement(SQL);
            st.setString(1, p.getNit());
            st.setString(2, p.getNombre());
            st.setString(3, p.getTelefono());
            st.setString(4, p.getDireccion());
            st.setString(5, p.getCorreo_electronico());

            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static ArrayList<Proveedor> listar() {

        ArrayList<Proveedor> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {

            String SQL = "select * from proveedores";
            con = conexion.conectar();

            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            resultado = st.executeQuery();

            Proveedor prov;

            while (resultado.next()) {
                prov = new Proveedor();
                prov.setNit(resultado.getString("nit"));
                prov.setNombre(resultado.getString("nombre"));
                prov.setTelefono(resultado.getString("telefono"));
                prov.setDireccion(resultado.getString("direccion"));
                prov.setCorreo_electronico(resultado.getString("correo"));
                lista.add(prov);
            }

            return lista;

        } catch (SQLException ex) {

            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static String getProveedor(String nit) {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {

            String SQL = "select nombre from proveedores where nit=?";
            con = conexion.conectar();

            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            st.setString(1, nit);
            resultado = st.executeQuery();

            if (resultado.next()) {
                return (resultado.getString("nombre"));
            }

            return "--";

        } catch (SQLException ex) {

            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

}
