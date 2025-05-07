/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Customer;
import model.Item;
import model.Purchase;

/**
 *
 * @author USER
 */
public class AppController {

    FileAccess fA;

    public AppController() {
        fA = new FileAccess();
    }

    public boolean addItem(String name, Double price, int totalQty) {
        ArrayList<Item> allItems = fA.readItems();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getItemName().equals(name)) {
                return false;
            }

        }
        Item i = new Item(name, price, totalQty);
        fA.writeToFile("items", i.toString() + "\n");
        System.out.println("Item created and added ");
        return true;

    }

    public void addPurchase(ArrayList<Purchase> cart) {
        for (int i = 0; i < cart.size(); i++) {
            fA.writeToFile("purchases", cart.get(i).toString() + "\n");
        }
    }

    public ArrayList<Item> getItemList() {

        return fA.readItems();
    }

    public String PrintAllItems() {
        String s = "";

        ArrayList<Item> allItems = fA.readItems();
        for (int i = 0; i < allItems.size(); i++) {
            s += allItems.get(i).toString() + "\n";
        }
        return s;
    }

    public Double getItemPrice(String name) {
        double p = 0;
        ArrayList<Item> allItems = fA.readItems();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getItemName().equals(name)) {
                p = allItems.get(i).getItemPrice();
            }
        }
        return p;

    }

    public ArrayList<String> getAllItemsNames() {
        ArrayList<Item> allItems = fA.readItems();
        ArrayList<String> NAMES = new ArrayList();
        for (int i = 0; i < allItems.size(); i++) {
            String n = allItems.get(i).getItemName();
            NAMES.add(n);
        }
        return NAMES;
    }

    public int getTotalQuantity(String name) {
        int qty = 0;
        ArrayList<Item> allItems = fA.readItems();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getItemName().equals(name)) {
                qty = allItems.get(i).getTotalQuantity();
            }
        }
        return qty;
    }

    public int getItemCount() {
        return fA.readItems().size();
    }

    public String[][] getItemData() {
        int row = this.getItemCount();
        String[][] data = fA.getItemInfo(row);
        return data;
    }

    public void addCustomer(String name, String pass, String gmail) {
        Customer c = new Customer(name, pass, gmail);
       
        fA.writeToFile("customers", c.toString() + "\n");
    }

    public boolean CheckCustomer(String username, String pass, String gmail) {

        boolean r = false;
        ArrayList<Customer> allcust = fA.readCustomers();
        System.out.println("ArrayList : "+allcust);
        for (int i = 0; i < allcust.size(); i++) {
            System.out.println(allcust.get(i).toString());

            if (allcust.get(i).getName().equals(username) && allcust.get(i).getPass().equals(pass) && allcust.get(i).getGmail().equals(gmail)) {
//                System.out.println(allCustomers.get(i).toString());
                r = true;
            }
        }
        return r;
    }

    public void reduceItemQuantity(ArrayList<Purchase> cart) {
        String name;
        int red;
        ArrayList<Item> allItems = fA.readItems();
        for (int j = 0; j < cart.size(); j++) {
            name = cart.get(j).getIname();
            red = cart.get(j).getIquantity();

            for (int i = 0; i < allItems.size(); i++) {
                int q;
                if (allItems.get(i).getItemName().equals(name)) {
                    q = allItems.get(i).getTotalQuantity();
                    q = q - red;
                    allItems.get(i).setTotalQuantity(q);
                }
            }
        }
        fA.resetfile("Items");
        for (int i = 0; i < allItems.size(); i++) {
            fA.writeToFile("Items", allItems.get(i).toString() + "\n");
        }

    }
}
