package org.example.view;

public class CustomerView {

    public void printCustomerDetails(long id, String name, String address, String mail) {
        System.out.println("Customer: \n"
        + "ID: " + id + "\n"
        + "Name: " + name + "\n"
        + "Address: " + address + "\n"
        + "Mail: " + mail + "\n");
    }
}
