/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.postgresql.Driver;

/**
 *
 * @author Henrique Ricordi
 */
public class ConexaoPGSQL {

    public static Connection getConnection() throws SQLException {
        try {
            String url = "jdbc:postgresql://localhost:5432/market";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");            
           return DriverManager.getConnection(url, props);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new SQLException();
        }
    }
}
