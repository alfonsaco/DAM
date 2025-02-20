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
import model.Producto;

/**
 *
 * @author Alfonso
 */
public class ProductoDao {

    public static boolean registrar(Producto p) throws SQLException {

        Connection con = null;
        PreparedStatement st = null;

        try {

            String SQL = "INSERT INTO productos (id, nombre, descripcion, cantidad, precio, id_categoria, id_proveedor) VALUES (?, ?, ?, ?, ?, ?, ?)";

            con = conexion.conectar();

            if (con == null) {
                return false;
            }

            st = con.prepareStatement(SQL);
            st.setInt(1, p.getCodigo());
            st.setString(2, p.getNombre());
            st.setString(3, p.getDescripcion());
            st.setInt(4, p.getCantidad_inventario());
            st.setFloat(5, p.getPrecio());
            st.setInt(6, p.getCodigo_categoria());
            st.setString(7, p.getId_poveedor());

            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static ArrayList<Producto> listar() {

        ArrayList<Producto> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;

        try {

            String SQL = "select * from productos";
            con = conexion.conectar();

            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            resultado = st.executeQuery();

            Producto p;
            while (resultado.next()) {
                p = new Producto();
                p.setCodigo(resultado.getInt("id"));
                p.setNombre(resultado.getString("nombre"));
                p.setDescripcion(resultado.getString("descripcion"));
                p.setCantidad_inventario(resultado.getInt("cantidad"));
                p.setPrecio(resultado.getFloat("precio"));
                p.setCodigo_categoria(resultado.getInt("id_categoria"));
                p.setId_poveedor(resultado.getString("id_proveedor"));

                // Obtener nombres de categoría y proveedor
                p.setNombreCategoria(CategoriaDao.getCategoria(p.getCodigo_categoria()));
                p.setNombreProveedor(ProveedorDao.getProveedor(p.getId_poveedor()));

                lista.add(p);
            }

            return lista;

        } catch (SQLException ex) {

            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static boolean actualizar(Producto p) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            String SQL = "UPDATE productos SET "
                    + "                    nombre = ?,"
                    + "                    descripcion = ?,"
                    + "                    cantidad = ?,"
                    + "                    precio = ?,"
                    + "                    id_categoria = ?,"
                    + "                    id_proveedor = ?"
                    + "                    WHERE id = ?";
            con = conexion.conectar();

            if (con == null) {
                return false;
            }

            st = con.prepareStatement(SQL);
            st.setString(1, p.getNombre());
            st.setString(2, p.getDescripcion());
            st.setInt(3, p.getCantidad_inventario());
            st.setFloat(4, p.getPrecio());
            st.setInt(5, p.getCodigo_categoria());
            st.setString(6, p.getId_poveedor());
            st.setInt(7, p.getCodigo());

            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

    public static boolean eliminar(Producto p) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            String SQL = "DELETE FROM productos WHERE id=?";
            con = conexion.conectar();

            if (con == null) {
                return false;
            }

            st = con.prepareStatement(SQL);
            st.setInt(1, p.getCodigo());

            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
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

                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

}
