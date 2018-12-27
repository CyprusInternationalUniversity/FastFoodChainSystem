/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and o9pen the template in the editor.
 */
package Util;

/**
 *
 * @author User
 */
public class Food {
    private int id;
    private String title;
    private int quantity;
    private double price;
    private int numberOfQuantity;
    
    public Food() {
    }
    
    public Food(int id, String title, int quantity, double price, int numberOfQuantity) {
        super();
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.numberOfQuantity = numberOfQuantity;
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getnumberOfQuantity() {
        return numberOfQuantity;
    }
    public void setnumberOfQuantity(int numberOfQuantity) {
        this.numberOfQuantity = numberOfQuantity;
    }
        
    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            return true;
        }
        else {
            if(obj.getClass() == Food.class) {
                Food that = (Food)obj;
                return  (id == that.getId()) && 
                        title.equals(that.getTitle()) && 
                        (quantity == that.getQuantity()) && 
                        (price == that.getPrice());
            }
            else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return id + "," + title + "," + quantity + "," + price + "," + numberOfQuantity + "\n";
//        return "Food [id=" + id + ", title=" + title + ", quantity=" + quantity + ", price=" + price + ", numberOfQuantity=" + numberOfQuantity +"]\n";
    }
}
