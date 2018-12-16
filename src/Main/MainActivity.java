package Main;

import javax.swing.SwingUtilities;

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
    
    public static PresentationLayer MFRAME;
    public static void main(String args[]) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainActivity.MFRAME = new PresentationLayer(/*init parms to constructor*/);
                MainActivity.MFRAME.setVisible(true);
            }
        });
        
//        PresentationLayer pLayer = new PresentationLayer();
//        pLayer.setVisible(true);
//        
//        BusinessLayer blayer = new BusinessLayer();
//        blayer.openConnection();
//        blayer.getAllRecords();
//        blayer.closeConnection();
    }
}
