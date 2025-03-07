package org.example.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerView {

    private final Scanner input = new Scanner(System.in);

    public CustomerView() {
    }

    public void printCustomerTitle() {
        System.out.println("\n\n");
        System.out.println("            - - - CUSTOMER - - -");
    }

    public void printCustomerDetails(String title, long id, String name, String address, String mail) {
        System.out.println();
        System.out.println(title + "\nCustomer: \n"
        + "ID: " + id + "\n"
        + "Name: " + name + "\n"
        + "Address: " + address + "\n"
        + "Mail: " + mail + "\n");
    }

    public List<String> printAddNewCustomer(){
        System.out.println();

        System.out.println("Add new customer:");
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter address: ");
        String address = input.nextLine();
        System.out.print("Enter mail: ");
        String mail = input.nextLine();

        List<String> result = new ArrayList<>();
        result.add(name);
        result.add(address);
        result.add(mail);

        return result;
    }

    public String printChooseExistingCustomers(List<String> customers) {
        System.out.println();
        System.out.println("Choose an existing Customer:");
        int counter = 1;
        int choice = 0;
        String result = "";
        boolean found = false;
        for (String customer : customers) {
            System.out.println(counter + ". " + customers.get(counter - 1));
            counter++;
        }
        while (!found) {
            System.out.print("Enter choice: ");
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid choice");
                input.nextLine();
            }
            if (choice > 0 && choice <= customers.size()) {
                found = true;
                result = customers.get(choice - 1);
            } else {
                System.out.println("Invalid choice");
            }
        }
        return result;
    }
}

