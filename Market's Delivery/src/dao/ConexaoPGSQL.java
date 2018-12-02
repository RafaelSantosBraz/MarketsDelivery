/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Henrique Ricordi
 */
public class ConexaoPGSQL
{
    public static Connection getConnection() throws SQLException{
        try {
             Class.forName("com.mysql.jdbc.Driver");                             
             return DriverManager.getConnection("jdbc:mysql://xxx.xxx.xxx.xxx/mybd?user=eu&password=eu");                         
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());            
            throw new SQLException();            
        }        
    } 
}
