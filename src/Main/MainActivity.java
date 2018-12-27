package Main;

import DataAccessLayer.ConnectionFactory;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MainActivity {
    
    private static boolean isDBok = false;
    public static Products.ProductsLayer MFRAME;
    
    private static void appInit()
    {
        for(int i=1;i<=10;i++)
        {
            try
            {
                Thread.sleep(900);
            }
            catch (InterruptedException ex)
            {
                // ignore it
            }
        }
    }
    
    public static void main(String args[]) {
        
        ConnectionFactory DBConnection = new ConnectionFactory();
        isDBok = DBConnection.getFirstConnectionCheck();
        appInit();
        
        if(isDBok) {
            //JOptionPane.showMessageDialog(null, "Database Connected sucessfully");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainActivity.MFRAME = new Products.ProductsLayer();
                    MainActivity.MFRAME.setVisible(true);
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Database Connection Failed, Is Database Server is Running?", "Error", JOptionPane.ERROR_MESSAGE);
        }
//        BusinessLayer blayer = new BusinessLayer();
//        blayer.openConnection();
//        blayer.getAllRecords();
//        blayer.closeConnection();
    }
}
