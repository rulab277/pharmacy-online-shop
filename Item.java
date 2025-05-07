/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class Item {
    
    private String itemName;
    private Double itemPrice;
    private int totalQuantity;

    public Item(String itemName, Double itemPrice, int totalQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.totalQuantity = totalQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    
    @Override
    public String toString()  {
        return this.itemName + "\t" + this.itemPrice + "\t" + this.totalQuantity;
    }
    
    
    
}
