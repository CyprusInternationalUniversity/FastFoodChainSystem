/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basket;

import Products.ProductsLayer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Yeoman
 */
public class Thankyou extends JFrame implements ActionListener {

    JButton buttonImage = new JButton(new ImageIcon(getClass().getResource("/Pictures/success.png")));
    JPanel RootPanel = new JPanel();
    JPanel panel = new JPanel();
    JPanel fpanel = new JPanel();

    JLabel title = new JLabel("Thank you for your order.");
    JLabel description = new JLabel("We have recieved your order. It will be delievered to you shortly.");
    JLabel quantity = new JLabel("Quantity");
    JLabel Price = new JLabel("Price");
    JLabel TotalPrice  = new JLabel("totalPrice");
    int rowcount = 0;
    
    JButton OrderAgainBtn = new JButton("Order Again");
    JButton ExitAppBtn = new JButton("Exit App");
    

    public Thankyou() {
        setMinimumSize(new Dimension(1000, 1000));
        setTitle("Thank you");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);  

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        fpanel.setLayout(new BoxLayout(fpanel, BoxLayout.X_AXIS));
        
        title.setFont(new java.awt.Font("Tahoma", 0, 40));
        OrderAgainBtn.setMargin(new Insets(10,10,10,10));
        ExitAppBtn.setMargin(new Insets(10,10,10,10));
        OrderAgainBtn.setBackground(Color.decode("#4098e3"));
        OrderAgainBtn.setForeground(Color.WHITE);
        ExitAppBtn.setBackground(Color.decode("#4098e3"));
        ExitAppBtn.setForeground(Color.WHITE);

        buttonImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonImage.setBorderPainted(false);
        buttonImage.setFocusPainted(false);
        buttonImage.setContentAreaFilled(false);
        panel.add(buttonImage);

        panel.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(description);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(fpanel);
        fpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fpanel.add(Box.createRigidArea(new Dimension(0, 100))); // top space

        fpanel.add(OrderAgainBtn);
        fpanel.add(Box.createRigidArea(new Dimension(5,0))); // left right space
        fpanel.add(ExitAppBtn);
        
        add(panel);
        
        OrderAgainBtn.addActionListener(this);
        ExitAppBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ExitAppBtn) {
            System.exit(0);
        } else {

            ProductsLayer MainFrame = new ProductsLayer();
            MainFrame.setVisible(true);
            
            this.setVisible(false);
            this.dispose();
        }
    }
}
