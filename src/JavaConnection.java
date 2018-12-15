
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class JavaConnection {
 private static String dbURL = "jdbc:derby://localhost:1527/Logindb;create=true;user=moussa;password=moussa";
    private static String tableName="STUDENTS";
    private static Connection conn;
    private static Statement st;

    
    
    public static void openConnection(){
    
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        
        conn = DriverManager.getConnection(dbURL);
        
        //JOptionPane.showMessageDialog(null, "Database connection is sucessful");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection Failed", "Error",JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            //e.printStackTrace();
        }
        
        
        
    
        
    }
    
}
