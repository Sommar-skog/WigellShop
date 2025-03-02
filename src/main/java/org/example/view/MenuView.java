package org.example.view;


import java.util.Scanner;

public class MenuView {

    private final Scanner INPUT = new Scanner(System.in);

    public void printWelcomeMessage() {
        System.out.println("            WELCOME TO WIGELL SHOP");
    }

    public int printCustomerMeny(){
        while(true){
            System.out.println();
            System.out.println("1. Add New Customer \n" +
                    "2. Shop as an Existing Customer");
            System.out.print("Choose an option (1 or 2): ");
            try{
                return INPUT.nextInt();
            }catch(Exception e) {
                INPUT.nextLine();
                System.out.println("Please enter a valid option!");
            }
        }
    }

    public int printProductChoice(){
        while(true){
            System.out.println();
            System.out.println("Choose what product you would like to add to your order: "
            + "\n1. A pari of Pants" +
                    "\n2. A T-shirt" +
                    "\n3. A Skirt");
            System.out.print("Choose an option (1, 2 or 3): ");
            try{
                return INPUT.nextInt();
            } catch (Exception e){
                INPUT.nextLine();
                System.out.println("Please enter a valid option!");
            }
        }
    }
}
