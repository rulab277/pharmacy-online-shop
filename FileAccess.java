/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import model.Customer;
import model.Item;
import model.Purchase;

/**
 *
 * @author USER
 */
public class FileAccess {

    public void writeToFile(String fileName, String str) {
        try {
            FileWriter fw = new FileWriter(fileName + ".txt", true);
            fw.write(str);
            fw.close();
        } catch (IOException ioe) {
        }
    }

//    public ArrayList<Customer> readcustomers() {
//        ArrayList<Customer> allcustomers = new ArrayList();
//        String line;
//        String cinfo[];
//
//        try {
//            FileInputStream fs = new FileInputStream("customers.txt");
//            InputStreamReader ir = new InputStreamReader(fs);
//
//            BufferedReader in = new BufferedReader(ir);
//            while (in.ready()) {
//                // for (int i = 0; i < 3; i++) {
//                line = in.readLine();
//                cinfo = line.split("\t");
//                System.out.println(cinfo[0] + "  " + cinfo[1]);
//                System.out.println("line splittedd");
//                Customer r = new Customer(cinfo[0], cinfo[1]);
//                allcustomers.add(r);
//                System.out.println("Customer created and added");
//                System.out.println(allcustomers.get(0)+"..............."+allcustomers.get(1));
//
//            }in.close();
//        } catch (IOException e) {
//            System.out.println(e.toString());
//           // Throwable.printStackTrace();
//        }
//
//        return allcustomers;
//
//    }
    public ArrayList<Item> readItems() {
        ArrayList<Item> allItems = new ArrayList();
        String line;
        String info[];

        try {
            FileInputStream fs = new FileInputStream("Items.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                info = line.split("\t");
                Item i = new Item(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]));
                allItems.add(i);
//                System.out.println(allItems.get(0).toString());
//                System.out.println(allItems.get(1).toString());

            }
            in.close();
        } catch (IOException e) {
        }
        return allItems;

    }

    public ArrayList<Purchase> readPurchase() {
        ArrayList<Purchase> allPurchases = new ArrayList();
        return allPurchases;
    }

    public ArrayList<Customer> readCustomers() {
        ArrayList<Customer> allCustomers = new ArrayList();
        String line;
        String Cinfo[];

        try {
            FileInputStream fs = new FileInputStream("customers.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            line = in.readLine();
            int i = 0;
            while (line != null) {

                Cinfo = line.split("@@@");
                Customer k = new Customer(Cinfo[0], Cinfo[1], Cinfo[2]);
                allCustomers.add(k);
//                System.out.println(allCustomers.get(i).toString());
//                System.out.println("Array Size "+allCustomers.size());
                line = in.readLine();
                i++;

//                System.out.println(allCustomers.get(1).toString());
            }
            System.out.println("I is " + i);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allCustomers;

    }

    public void resetfile(String fileName) {
        try {
            FileWriter stdinf = new FileWriter(fileName + ".txt", false);
            stdinf.close();
        } catch (IOException e) {
        }
    }

    public String[][] getItemInfo(int rowCount) {
        String[][] data = new String[rowCount][4];
        String cinfo[];
        String line = "";

        int row = 0;
        try {
            FileInputStream fs = new FileInputStream("items.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                cinfo = line.split("\t");
                data[row][0] = cinfo[0];
                data[row][1] = cinfo[1];
                data[row][2] = cinfo[2];
//to: (int j- 0;
//System.arraycopytcinfo, j. hta[row], j. 1):
                if (cinfo[2].equals("0")) {
                    data[row][3] = "out of stock";
                }

                row++;
            }
            in.close();
        } catch (IOException e) {
        }
        return data;
    }

}
