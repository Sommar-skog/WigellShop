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

        //Simulering av att det tar lite tid att lägga beställningen
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public void printOrderReadyNow(){
        System.out.println();

        //Simulering att det tar lite tid att färdigställa beställningen
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Order ready for pick-up!");
    }
}
