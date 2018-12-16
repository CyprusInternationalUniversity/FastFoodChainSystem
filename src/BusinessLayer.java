




import java.sql.*;
import javax.swing.JOptionPane;

public class BusinessLayer {
    
    private static String dbURL = "jdbc:derby://localhost:1527/App;create=true;user=fu;password=fu";
    private static String tableName="PRODUCTS";
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
    
    public static void getAllRecords(){
        try {
        
            String output ="";
            st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM "+tableName);
        
            while(result.next()){
                int product_id = result.getInt(1);
                String product_name = result.getString(2);
                int QUANTITY = result.getInt(3);
                double PRICE = result.getDouble(4);
                output +="\n "+""+ product_id + "-"+ product_name + "  there is : "+ +QUANTITY +        " piece in stock with :   "+ PRICE+"$ for each";
            }
            
            result.close();
            st.close();
            JOptionPane.showMessageDialog(null, output);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Records cannot return from the database", "Error",JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            //e.printStackTrace();
        }
    }
    
    public static void closeConnection(){
        try{
            //JOptionPane.showMessageDialog(null, "Database connection is closed sucessful");
            conn.close();
            conn = null;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection not closed", "Error",JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            //e.printStackTrace();
        }
    }    
}
