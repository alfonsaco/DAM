/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alfonso
 */
public class Conexion {
    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jbdc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado", "root", "");
            
        } catch (ClassNotFoundException ex) {
            return null;
            
        } catch (SQLException ex) {
            return null;
        }
    }
}