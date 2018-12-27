/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

/**
 *
 * @author Yeoman
 */
public class Config {
    public static String DBConnectionString = "jdbc:derby://localhost:1527/App;create=true;";
    public static String DBUser = "fu";
    public static String DBPass = "fu";
//    user=fu;password=fu
    public static String DBTableName = "PRODUCTS";
    
    public static String getDBConnectionString() {
        return DBConnectionString;
    }
    public static String getDBUser() {
        return DBUser;
    }
    public static String getDBPass() {
        return DBPass;
    }
    public static String getDBTableName() {
        return DBTableName;
    }
}
