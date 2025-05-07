/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Customer;
import model.Purchase;

/**
 *
 * @author USER
 */
public class OrderController {

    ArrayList<Purchase> cart;
    Customer activeCustomer;
    AppController controller;

    public OrderController() {
        cart = new ArrayList();
        controller = new AppController();

    }

    public ArrayList<Purchase> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Purchase> cart) {
        this.cart = cart;
    }

    public Customer getActiveCustomer() {
        return activeCustomer;
    }

    public void addToCart(String iname, int qty, String customer) {
        Purchase p = new Purchase(iname, customer, qty);
        cart.add(p);
    }

    public void removeFromCart(String iname) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getIname().equals(iname)) {
                cart.remove(i);
            }
        }
    }

    public int countItems() {
        int num = 0;
        for (int i = 0; i < cart.size(); i++) {
            num += cart.get(i).getIquantity();
        }
        return num;
    }

    public void emptyCart() {
        cart.removeAll(cart);
    }

    public Double estimateprice() {
        Double sum = 0.0;
        for (int i = 0; i < cart.size(); i++) {
            String iname = cart.get(i).getIname();
            Double p = controller.getItemPrice(iname);
            int qt = cart.get(i).getIquantity();
            sum += p * qt;
        }
        return sum;
    }

    public String printCart() {
        String s = "";
        for (int i = 0; i < cart.size(); i++) {
            s += cart.get(i).getIname() + "\t" + cart.get(i).getIquantity() + "\t";
            s += controller.getItemPrice(cart.get(i).getIname()) + "\n";
        }
        return s;
    }
}
