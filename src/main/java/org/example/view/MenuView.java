package org.example.view;


import java.util.Scanner;

public class MenuView {

    private final Scanner INPUT = new Scanner(System.in);

    public void printWelcomeMessage() {
        System.out.println();
        System.out.println("           - - - WELCOME TO WIGELL SHOP - - -");
    }

    public int printCustomerMeny(){
        boolean validChoice = false;
        int choice = 0;
        while(!validChoice) {
            System.out.println();
            System.out.println("1. Add New Customer \n" +
                    "2. Shop as an Existing Customer");
            System.out.print("Choose an option (1 or 2): ");
            try{
                choice = INPUT.nextInt();
                INPUT.nextLine();
                if (choice == 1 || choice == 2) {
                    validChoice = true;
                } else {
                    System.out.println("Please enter a valid option! (1 or 2)");
                }

            }catch(Exception e) {
                INPUT.nextLine();
                System.out.println("Please enter a valid option! (1 or 2)");
            }

        }
        System.out.println();
        System.out.println("Your choice: " + choice);
        return choice;
    }

    public int printProductChoice(){
        boolean validChoice = false;
        int choice = 0;

        while(!validChoice) {
            System.out.println();
            System.out.println("Choose what product you would like to add to your order: "
            + "\n1. A pair of Pants" +
                    "\n2. A T-shirt" +
                    "\n3. A Skirt");
            System.out.print("Choose an option (1, 2 or 3): ");
            try{
                choice = INPUT.nextInt();
                if (choice == 1 || choice == 2 || choice == 3) {
                    validChoice = true;
                } else {
                    System.out.println("Please enter a valid option! (1, 2 or 3)");
                }
            } catch (Exception e){
                INPUT.nextLine();
                System.out.println("Please enter a valid option! (1,2 or 3)");
            }
        }
        System.out.println();
        System.out.println("Your choice: " + choice);
        return choice;
    }

    public boolean printExitQuestion(){
        System.out.println();
        boolean validChoice = false;
        boolean result = false;
        while (!validChoice) {
            System.out.print("Would you like to start a new session or exit? (1) Start Over, (2) Exit Program: ");
            try {
                int choice = INPUT.nextInt();

                if (choice == 1 || choice == 2) {
                    if (choice == 2) {
                        result = true;
                    }
                    validChoice = true;
                } else {
                    System.out.println("Please enter a valid option! (1 or 2)");
                }
            } catch (Exception e) {
                INPUT.nextLine();
                System.out.println("Please enter a valid option (1 or 2)");
            }
        }
        return result;
    }

}
