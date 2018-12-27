/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Util.Food;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Yeoman
 */
public class Products {
    private static String tableName = Config.getDBTableName();
    
    private Food extractFoodFromResultSet(ResultSet rs) throws SQLException {
        Food food = new Food();
        food.setId(rs.getInt(1));
        food.setTitle(rs.getString(2));
        food.setQuantity(rs.getInt(3));
        food.setPrice(rs.getDouble(4));
        return food;
    }

    public Set getAllProducts() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM "+tableName);
            Set products = new HashSet();
            while(rs.next()) {
                Food food = extractFoodFromResultSet(rs);
                products.add(food);
            }
            return products;
        } catch (SQLException ex) {
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        return null;
    }
    
    /*
    Public GetAll() throws SQLException {
        //List<Food> allFoodsList = new LinkedList<Food>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Food> allFoods = new ArrayList<Food>();
        int rowcount = 0;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM "+tableName);
            while(resultSet.next()){
                int product_id = resultSet.getInt(1);
                String product_name = resultSet.getString(2);
                int QUANTITY = resultSet.getInt(3);
                double PRICE = resultSet.getDouble(4);
                rowcount++;
                Food food = new Food();
                food.setId(resultSet.getInt(1));
                food.setTitle(resultSet.getString(2));
                food.setQuantity(resultSet.getInt(3));
                food.setPrice(resultSet.getDouble(4));
                
                allFoods.add(food);
               
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
        return allFoodsList;
    }
    */
}
