package org.example.view;

import java.util.List;

public class OrderView {

    public void printOrder(long id, String name, List<String> productsList) {
        System.out.println(name + ": \n"
        + "Id: " + id + "\n");

        for (String product : productsList) {
            System.out.println(product);
        }
    }

    public void printPlacingOrderNow(){
        System.out.println("Placing order now...");
    }
}
