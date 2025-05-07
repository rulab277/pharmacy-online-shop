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
public class Customer {
    
    private String name;
    private String pass;
    private String gmail;

    public Customer(String name, String pass, String gmail) {
        this.name = name;
        this.pass = pass;
        this.gmail = gmail;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    @Override
    public String toString()  {
        return this.name + "@@@"+ this.pass +"@@@" +this.gmail;
    }
    
    
    
}
