package org.example.controller;

import org.example.model.businessobject.Customer;
import org.example.view.CustomerView;
import org.example.view.MenuView;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    //TODO fixa en hashMap som ska simulera databas med kunder. Så att nya kunder sparas dit och existerande kunder hämtas därifrån.
    private final CustomerView CUSTOMER_VIEW;
    private final MenuView MENU_VIEW;

    private final MainController MAIN_CONTROLLER;
    private Customer customerShopping;

    public CustomerController(MainController mainController) {
        this.MAIN_CONTROLLER = mainController;
        this.CUSTOMER_VIEW = new CustomerView();
        this.MENU_VIEW = MAIN_CONTROLLER.getMENU_VIEW();
    }

    public void customer(){
        System.out.println("Customer");
        int choice = MENU_VIEW.printCustomerMeny();
        if(choice == 1){
            List<String> customerDetails = CUSTOMER_VIEW.printAddNewCustomer();
            customerShopping = new Customer(customerDetails.get(0),customerDetails.get(1),customerDetails.get(2) );

        } else if (choice == 2) {
            //Simulerar existerande kunder
            Customer existingCustomer1 = new Customer("Anna", "Stora Gatan 1, STOCKHOLM", "anna@example.com");
            Customer existingCustomer2 = new Customer("Erik", "Lilla Gatan 1, STOCKHOLM", "erik@example.com");

            List<String> existingCustomers = new ArrayList<>();
            existingCustomers.add("Customer ID: "+ existingCustomer1.getId() + ", " + existingCustomer1.getName());
            existingCustomers.add("Customer ID: " + existingCustomer2.getId() + ", " + existingCustomer2.getName());

            String chosenCustomer = CUSTOMER_VIEW.printChooseExistingCustomers(existingCustomers);

            //Hade fått göra annan lösning om detta inte vore en simulation
            if (chosenCustomer.contains("Customer ID: 1")){
                customerShopping = existingCustomer1;
            } else if (chosenCustomer.contains("Customer ID: 2")){
                customerShopping = existingCustomer2;
            }
        }
        CUSTOMER_VIEW.printCustomerDetails("Selected Customer for Shopping",customerShopping.getId(),customerShopping.getName(), customerShopping.getAddress(), customerShopping.getMail());
        MAIN_CONTROLLER.setCustomerShopping(customerShopping);
    }

    public CustomerView getCUSTOMER_VIEW() {
        return CUSTOMER_VIEW;
    }
}
