/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import static Products.ProductsLayer.validateSelection;
import Util.Food;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Yeoman
 */
public class Helper {
    public static void clearSelectionCount(int countItems) {
        countItems = 0;
    }
    
    public static boolean clearValidation(boolean validateSelection) {
        return validateSelection = true;
    }
    
    public static boolean checkForEmptySelections( int foodListSize ) {
        System.out.println("foodListSize ="+ foodListSize);
        if(foodListSize == 0) {
            return false;
        }
        return true;
    }
    public static boolean validateProductsSelections( List<Food> foods ) {
        Iterable<Food> iterable = foods;
        for (Food foodArr : iterable) {
            // first we see if we are not out of ORDER
            if( foodArr.getQuantity() == 0 ) {
                JOptionPane.showMessageDialog(null, "SORRY, WE ARE OUT OF OURDER FOR Product(Name) = "+foodArr.getTitle(), "Error Selecting Products", JOptionPane.ERROR_MESSAGE);
                return false;
            } 
            // check if use has not selected anything
            else if(foodArr.getnumberOfQuantity() == 0) {
                JOptionPane.showMessageDialog(null, "You have not selected Quantity for product(Name) = "+foodArr.getTitle()+ " to add for Basket.\n Please Correct this.", "Error Selecting Products", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            // check if use has selected MORE than stock
            else if(foodArr.getnumberOfQuantity() > foodArr.getQuantity() ) {
                JOptionPane.showMessageDialog(null, "You have selected TOO many number of quantities for product(Name) = "+foodArr.getTitle()+ " to add for Basket. \n Maximum we can provide you is "+foodArr.getQuantity(), "Error Selecting Products", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
