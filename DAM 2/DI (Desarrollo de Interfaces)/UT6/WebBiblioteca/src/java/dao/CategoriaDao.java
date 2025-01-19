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
import model.Categoria;

/**
 *
 * @author Alfonso
 */
public class CategoriaDao {
    public static boolean registrar(Categoria cat) {        
        Connection con=null;
        PreparedStatement st=null;
             
        try {            
            String SQL="INSERT INTO CATEGORIAS(NOMBRE) VALUES (?);";
            con=Conexion.conectar();
            if(con == null) {
                return false;
            }
            
            st=con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
            
            if(st.executeUpdate() > 0) {
                return true;
            } else {
                return false;   
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        } finally {
            try {
                if(st != null) {
                    st.close();
                } else {
                    con.close();
                }
                
            } catch(SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                        
    }
    
    public static ArrayList<Categoria> listar() {
        ArrayList<Categoria> lista=new ArrayList<>();
        PreparedStatement st=null;
        Connection con=null;
        ResultSet rset=null;
             
        try {
            String SQL="SELECT * FROM CATEGORIAS";
            con=Conexion.conectar();            
            if(con == null) {
                return null;
            }
            
            st=con.prepareStatement(SQL);
            rset=st.executeQuery();
            
            Categoria cat;
            while(rset.next()) {
                cat=new Categoria();
                cat.setCodigo(rset.getInt("codigo"));
                cat.setNombre(rset.getString("nombre"));
                lista.add(cat);
            }
            return lista;
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   finally {
            try {
                if(rset != null) {
                    rset.close();
                }
                if(st != null) {
                    st.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch(SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }              
    }
}
