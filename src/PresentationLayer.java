/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import Basket.Basket;
import Util.Food;
        
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class PresentationLayer extends JFrame implements ActionListener {
    
   
    List<Food> foods = new LinkedList<Food>();
    private static String dbURL = "jdbc:derby://localhost:1527/App;create=true;user=fu;password=fu";
    private static String tableName="PRODUCTS";
    private static Connection conn;
    private static Statement st;
    
    JPanel headerPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel panel = new JPanel();
    
    JLabel title = new JLabel("Product List");
    JLabel quantity = new JLabel("Quantity Left in Stock");
    JLabel Price = new JLabel("Price");
    JLabel QuantityBasket  = new JLabel("Quantity to add in Basket");
    int rowcount = 0;
    JButton submitBtn = new JButton("add to basket");

 
    
    PresentationLayer(){

        setMinimumSize(new Dimension(1000, 1000));
        setTitle("My Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        headerPanel.add(title);
        footerPanel.add(submitBtn);
        title.setFont(new java.awt.Font("Tahoma", 0, 40)); 
        submitBtn.setFont(new java.awt.Font("Tahoma", 0, 20)); 

        panel.setLayout(new GridLayout(0,6));
//        setLocation(100, 500);
        this.setLocationRelativeTo(null);  

        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbURL);
//            JOptionPane.showMessageDialog(null, "Database connection is sucessful");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection Failed", "Error",JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            //e.printStackTrace();
        }
        
        try {
            String output ="";
            st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM "+tableName);

            while(result.next()){
                int product_id = result.getInt(1);
                String product_name = result.getString(2);
                int QUANTITY = result.getInt(3);
                double PRICE = result.getDouble(4);
                rowcount++;
                
                JCheckBox button1 = new JCheckBox("");
                panel.add(button1);

                
                JButton  button2 = new JButton (new ImageIcon (getClass().getResource("/Pictures/"+product_name+".jpg")));
//                button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/"+product_name+".jpg")));
                button2.setPreferredSize(new Dimension(50,50));
                button2.setMargin(new Insets(0, -50, 0, 20));
//                button2.setBorderPainted(false);
                button2.setFocusPainted(false);
                button2.setContentAreaFilled(false);
                panel.add(button2);
                
                JLabel button3 = new JLabel(""+product_name);
                button3.setFont(new java.awt.Font("Arial", 0, 18)); 
                panel.add(button3);
                
                JLabel button4 = new JLabel(""+QUANTITY);
                button4.setFont(new java.awt.Font("Arial", 0, 18)); 
                panel.add(button4);
                
                JLabel button5 = new JLabel(""+PRICE);
                button5.setFont(new java.awt.Font("Arial", 0, 18)); 
                panel.add(button5);
                
                JTextField button6 = new JTextField(5);
                button6.setFont(new java.awt.Font("Arial", 0, 20)); 
                button6.setPreferredSize(new Dimension(2,2));
                button6.setText(""+0);
                panel.add(button6);
                
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(button1.isSelected()) {
                            foods.add(new Food(product_id, product_name, QUANTITY, PRICE, Integer.parseInt(button6.getText()) ));
//                          JOptionPane.showMessageDialog(panel, Integer.parseInt(button6.getText()));
                        } else {
                            foods.remove(new Food(product_id, product_name, QUANTITY, PRICE, Integer.parseInt(button6.getText()) ));
                        }
                    }
                });
                
            }
            result.close();
            st.close();
//            JOptionPane.showMessageDialog(null, output);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Records cannot return from the database", "Error",JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        
        
//        for (int i = 0; i < rowcount; i++) {
////          final String str = ""+i;
////          JLabel labels = new JLabel(str);
////          panel.add(labels);
//            JButton button = new JButton(""+i);
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    JOptionPane.showMessageDialog(panel, str);
//                }
//            });
//            panel.add(button);
//        }
        
        panel.setPreferredSize(new Dimension (800,700));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        headerPanel.setPreferredSize(new Dimension (700,100));
        footerPanel.setPreferredSize(new Dimension (700,100));
                
        add(headerPanel);
        add(panel);
        add(footerPanel);
        submitBtn.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitBtn) {
            
//            JOptionPane.showMessageDialog(null, foods);
//            System.out.println(foods);
            
            this.dispose();
            this.setVisible(false);
            Basket.PresentationLayer BasketPLayer = new Basket.PresentationLayer(foods);
            BasketPLayer.setVisible(true);
//            Basket bpLayer = new Basket();

        }
    }

}
