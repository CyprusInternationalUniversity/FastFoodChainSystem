/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basket;

import Main.MainActivity;
import Util.Common;
import Util.Food;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class BasketLayer extends JFrame implements ActionListener {
    
    List<Food> foodCopies = new ArrayList<>();
    
 
    JLabel title = new JLabel("Basket Menu");
//    JLabel quantity = new JLabel("Quantity");
//    JLabel Price = new JLabel("Price");
    JLabel TotalPrice  = new JLabel("totalPrice");
    int rowcount = 0;
    JButton payBtn = new JButton("Pay");
    JButton cancelBtn = new JButton("Go Back");
    JLabel totalPay = new JLabel("Total");  
    double sum = 0.0;
    JLabel totalPayAmmount = new JLabel("<Ammount>");
    
    JPanel topHeaderPanel = new JPanel();
    JPanel bottomHeaderPanel = new JPanel();
    JPanel SubFooterPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel pane = new JPanel();

    JLabel ftitle = new JLabel("Food Name");
    JLabel quantity = new JLabel("<html>Quantity in<br>Stock</html>           ");
    JLabel Price = new JLabel("Price");
    JLabel QuantityBasket = new JLabel("Quantities Ordered");
    public static boolean validate = true;

    
    public BasketLayer(List<Food> foodList, int SelectedItemsCount) {
        createView(foodList, SelectedItemsCount);

        // Make window exit on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set size
        setSize(new Dimension(1000, 1000));
        // center in the middle of screen
        setLocationRelativeTo(null);
        // Title of Form
        setTitle("Basket Form");
        // Disable Resize
        setResizable(false);
    }
     
    public void createView(List<Food> foodList, int SelectedItemsCount) {
        JPanel panelMain = new JPanel();
        JPanel RootPanel = new JPanel();

        getContentPane().add(RootPanel);
        // Root layout
        RootPanel.setLayout(new BoxLayout(RootPanel, BoxLayout.Y_AXIS));
        // labels layout
        JPanel labelsPanel = new JPanel(new GridLayout(0, 6));
        // showing products (data) layout
        JPanel datapanel = new JPanel(new GridLayout(0, 6));
        // footer layout
        // add scroll to data panel
        JScrollPane datapanelScroll = new JScrollPane(datapanel);
        datapanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        datapanelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        datapanelScroll.setPreferredSize(new Dimension(800, SelectedItemsCount < 7 ? SelectedItemsCount * 100 : 600));

        topHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        topHeaderPanel.setPreferredSize(new Dimension(1000, 90));
        bottomHeaderPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        bottomHeaderPanel.setPreferredSize(new Dimension(800, 60));
        SubFooterPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        SubFooterPanel.setPreferredSize(new Dimension(800, 90));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        footerPanel.setPreferredSize(new Dimension(800, 90));

        datapanel.setPreferredSize(new Dimension (800, SelectedItemsCount < 7 ? SelectedItemsCount * 100 : 700 ));
        datapanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        labelsPanel.setPreferredSize(new Dimension(800, 50));
        

        panelMain.setAlignmentX(Component.CENTER_ALIGNMENT);
        footerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //panelMain including all other panels
        panelMain.add(topHeaderPanel);
        panelMain.add(bottomHeaderPanel);
        panelMain.add(datapanelScroll);
        panelMain.add(SubFooterPanel);
        panelMain.add(footerPanel);
        // Main panel including main panel
        RootPanel.add(panelMain);

        // styles
        labelsPanel.add(new JLabel(" "));
        labelsPanel.add(new JLabel(" "));
        labelsPanel.add(ftitle);
        labelsPanel.add(quantity);
        labelsPanel.add(Price);
        labelsPanel.add(QuantityBasket);
        ftitle.setHorizontalAlignment(JLabel.CENTER);
        quantity.setHorizontalAlignment(JLabel.CENTER);
        Price.setHorizontalAlignment(JLabel.CENTER);
        QuantityBasket.setHorizontalAlignment(JLabel.CENTER);

        title.setFont(new java.awt.Font("Tahoma", 0, 40));
        ftitle.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        quantity.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        Price.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        QuantityBasket.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 15));
        
        payBtn.setFont(new java.awt.Font("Tahoma", 0, 20));
        cancelBtn.setFont(new java.awt.Font("Tahoma", 0, 20));
        cancelBtn.setBackground(Color.decode("#4098e3"));
        cancelBtn.setForeground(Color.WHITE);
        payBtn.setBackground(Color.decode("#4098e3"));
        payBtn.setForeground(Color.WHITE);
        
        totalPay.setFont(new java.awt.Font("Tahoma", 0, 25));
        totalPayAmmount.setFont(new java.awt.Font("Tahoma", Font.BOLD, 35));
        totalPayAmmount.setForeground(Color.decode("#4098e3"));
                
        // size
        payBtn.setPreferredSize(new Dimension(100,40));
        cancelBtn.setPreferredSize(new Dimension(120,40));
   
        
        // panels components
        topHeaderPanel.add(title);
        bottomHeaderPanel.add(labelsPanel);
        SubFooterPanel.add(totalPay);
        SubFooterPanel.add(Box.createRigidArea(new Dimension(5,0))); // left right space
        SubFooterPanel.add(totalPayAmmount);
        footerPanel.add(payBtn);
        footerPanel.add(Box.createRigidArea(new Dimension(5,0))); // left right space
        footerPanel.add(cancelBtn);
        // action listen for submit button
        payBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        /**
         * @Description creating iterable on copy of data sent from Product form
         * @return foodList
         */
        Iterable<Food> iterable = foodList;
        iterable.forEach(foodCopies::add);
        
        
        for (Food singleFoodArr : iterable) {
            sum += singleFoodArr.getPrice() * singleFoodArr.getnumberOfQuantity();
            JButton  button1 = new JButton (new ImageIcon (getClass().getResource("/Pictures/"+ singleFoodArr.getTitle() +".jpg")));
            button1.setPreferredSize(new Dimension(50,50));
            button1.setMargin(new Insets(0, -50, 0, 20));
            button1.setBorderPainted(false);
            button1.setFocusPainted(false);
            button1.setContentAreaFilled(false);
            datapanel.add(button1);
            datapanel.add(new JLabel(" "));


            JLabel button2 = new JLabel(""+ singleFoodArr.getTitle() );
            button2.setFont(new java.awt.Font("Arial", 0, 18)); 
            datapanel.add(button2);

            JLabel button3 = new JLabel(""+ singleFoodArr.getQuantity(), JLabel.CENTER );
            button3.setFont(new java.awt.Font("Arial", 0, 18)); 
            datapanel.add(button3);

            JLabel button4 = new JLabel(""+ singleFoodArr.getPrice() + "$", JLabel.CENTER );
            button4.setFont(new java.awt.Font("Arial", 0, 18)); 
            datapanel.add(button4);

            JLabel button5 = new JLabel(""+ singleFoodArr.getnumberOfQuantity() );
            button5.setFont(new java.awt.Font("Arial", 0, 20)); 
            datapanel.add(button5);
        }
        
        totalPayAmmount.setText( Double.toString(sum) + "$" );
        
       
    }
       
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == payBtn) {
            validate = Helper.validateAndDeductQuantityFromSQL(foodCopies);
            if(validate != false) {
                Thankyou thanksFrame = new Thankyou();
                thanksFrame.setVisible(true);

                this.setVisible(false);
                this.dispose();                
            }
        }
        
        if(e.getSource() == cancelBtn) {
            
            MainActivity.MFRAME.setVisible(true);
            this.setVisible(false);
            this.dispose();


        }    
    }
}