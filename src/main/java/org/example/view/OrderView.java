package org.example.view;

public class OrderView {

    public OrderView() {

    }

    public void printOrderTitle(){
        System.out.println("\n\n");
        System.out.println("            - - - ORDER - - -");
        System.out.println();
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
