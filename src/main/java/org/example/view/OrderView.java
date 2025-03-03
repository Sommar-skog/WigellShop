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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public void printOrderReadyNow(){
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Order ready for pick-up!");
    }
}
