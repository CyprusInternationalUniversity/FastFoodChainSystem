/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Basket.BasketLayer;
import Util.Food;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yeoman
 */
public class Basket {
    private static String tableName = Config.getDBTableName();

    public boolean deductProdcutFromSQL(int getnumberOfQuantity, int productID) {
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE "+tableName+" SET quantity=(quantity - "+getnumberOfQuantity+") WHERE id="+productID);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating prodcut with ID of " + productID, "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
            return false;
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }
}
