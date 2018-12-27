/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basket;

import DataAccessLayer.Basket;
import Util.Food;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Yeoman
 */
public class Helper {
    public static boolean validateAndDeductQuantityFromSQL( List<Food> foodCopies ) {
        Iterable<Food> iterable = foodCopies;
        Basket Basket = new Basket();
        for (Food foodArr : iterable) {
            // we get boolean from database
            // if successfully deducted it will fail with false
            // if it is false we will stop there
            if( !(Basket.deductProdcutFromSQL(foodArr.getnumberOfQuantity(), foodArr.getId())) ) {
                return false;
            }
        }
        return true;
    }
}
