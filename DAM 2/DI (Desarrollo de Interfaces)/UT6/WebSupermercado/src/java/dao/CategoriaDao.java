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
import model.Categoria;

/**
 *
 * @author Alfonso
 */
public class CategoriaDao {
    public static boolean registrar(Categoria cat) {
        String SQL="INSERT INTO CATEGORIAS(NOMBRE) VALUES ('?');";
        Connection con=Conexion.conectar();
             
        try {
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
            if(st.executeUpdate() > 0) {
                return true;
            }
            return false;
            
        } catch (SQLException ex) {
            return false;
        }                
    }
    
    public static ArrayList<Categoria> listar() {
        String SQL="SELECT * FROM CATEGORIAS";
        Connection con=Conexion.conectar();
             
        try {
            PreparedStatement st=con.prepareStatement(SQL);
           // st.setString(1, cat.getNombre());
            ResultSet rset=st.executeQuery();
            
            ArrayList<Categoria> lista=null;
            Categoria cat;
            while(rset.next()) {
                cat=new Categoria();
                cat.setId(rset.getInt("codigo"));
                cat.setNombre(rset.getString("nombre"));
                lista.add(cat);
            }
            return lista;
            
        } catch (SQLException ex) {
            return null;
        }                
    }
}
