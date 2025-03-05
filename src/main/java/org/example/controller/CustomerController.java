package org.example.controller;

import org.example.model.businessobject.Customer;
import org.example.view.CustomerView;
import org.example.view.MenuView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerController {

    private final CustomerView customerView;
    private final MenuView menuView;

    private final MainController mainController;
    private Customer customerShopping;
    private final Map<Long, Customer> customerDb;

    public CustomerController(MainController mainController) {
        this.mainController = mainController;
        this.customerView = new CustomerView();
        this.menuView = this.mainController.getMenuView();
        this.customerDb = new HashMap<>();
        customerDatabase();
    }

    public void customer(){
        customerView.printCustomerTitle();
        int choice = menuView.printCustomerMeny();

        if(choice == 1){
            List<String> customerDetails = customerView.printAddNewCustomer();
            customerShopping = new Customer(customerDetails.get(0),customerDetails.get(1),customerDetails.get(2));
            customerShopping.setOrder(mainController.getCurrentOrder());
            customerDb.put(customerShopping.getId(),customerShopping); //Lägger den nya kunden i databasen

        } else if (choice == 2) {
            List<String> existingCustomers = new ArrayList<>();

            for (Customer customer : customerDb.values()) {
                existingCustomers.add("Customer ID: " + customer.getId() + ", " + customer.getName());
            }

            String chosenCustomer = customerView.printChooseExistingCustomers(existingCustomers);
            String chosenCustomerIDstring = chosenCustomer.replace("Customer ID: ", "").split(",")[0].trim();
            long chosenCustomerID = Long.parseLong(chosenCustomerIDstring);

            for (Customer customer : customerDb.values()) {
                if (customer.getId() == chosenCustomerID) {
                    customerShopping = customer;
                    break;
                }
            }

            // Kontrollera om ingen kund hittades
            if (customerShopping == null) {
                throw new IllegalArgumentException("No customer found with the given ID: " + chosenCustomerID);
            }
        }

        customerView.printCustomerDetails("Selected Customer for Shopping",customerShopping.getId(),customerShopping.getName(), customerShopping.getAddress(), customerShopping.getMail());
        mainController.setCustomerShopping(customerShopping);
    }

    private void customerDatabase(){
        // Detta är en simuleringsmetod för en databas.
        Customer existingCustomer1 = new Customer("Anna Andersson", "Stora Gatan 1, STOCKHOLM", "anna@example.com");
        Customer existingCustomer2 = new Customer("Erik Eriksson", "Lilla Gatan 1, STOCKHOLM", "erik@example.com");

        customerDb.put(existingCustomer1.getId(), existingCustomer1);
        customerDb.put(existingCustomer2.getId(), existingCustomer2);
    }

    public CustomerView getCustomerView() {
        return customerView;
    }
}
