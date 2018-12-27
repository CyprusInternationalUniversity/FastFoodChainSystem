/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Yeoman
 */
public class ConnectionFactory {
    
    private static final String DBURL = Config.getDBConnectionString();
    private static final String USER  = Config.getDBUser();
    private static final String PASS  = Config.getDBPass();
    
    public static Connection con;

    public static boolean getFirstConnectionCheck() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection(DBURL, USER, PASS);
            //con = DriverManager.getConnection(dbURL);
            //JOptionPane.showMessageDialog(null, "Database Connected sucessfully");
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            //JOptionPane.showMessageDialog(null, "Connection Failed", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
        }
        return false;
    }
    
    public static Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //con = DriverManager.getConnection(DBURL, USER, PASS);
            return DriverManager.getConnection(DBURL, USER, PASS);
            //JOptionPane.showMessageDialog(null, "Database Connected sucessfully");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            //JOptionPane.showMessageDialog(null, "Connection Failed", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
    
    
    public static void closeConnection() {
        try {
            JOptionPane.showMessageDialog(null, "Database connection is closed!");
            con.close();
            con = null;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing Database connection.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
        }
    }
}
