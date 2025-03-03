package org.example.controller;

import org.example.model.businessobject.Customer;
import org.example.model.businessobject.order.Order;
import org.example.view.*;


public class MainController {

    private final MenuView MENU_VIEW = new MenuView();

    private final CEOController CEO_CONTROLLER = new CEOController(this);
    private final CustomerController CUSTOMER_CONTROLLER = new CustomerController(this);
    private final ProductController PRODUCT_CONTROLLER = new ProductController(this);
    private final OrderController ORDER_CONTROLLER = new OrderController(this);
    private final ReceiptController RECEIPT_CONTROLLER = new ReceiptController(this);

    private Customer customerShopping;
    private Order currentOrder = new Order("Order");
    private boolean exit = false;

    public MainController() {
    }

    public void start(){
        mainAppLoo();
    }

    private void mainAppLoo(){

        while(!exit){
            MENU_VIEW.printWelcomeMessage();
            CUSTOMER_CONTROLLER.customer();
            ORDER_CONTROLLER.order();
            RECEIPT_CONTROLLER.receipt();
            exitControl();
        }
    }

    private void exitControl(){
        exit = MENU_VIEW.printExitQuestion();
    }

    public MenuView getMENU_VIEW() {
        return MENU_VIEW;
    }

    public CEOController getCEO_CONTROLLER() {
        return CEO_CONTROLLER;
    }

    public CustomerController getCUSTOMER_CONTROLLER() {
        return CUSTOMER_CONTROLLER;
    }

    public ProductController getPRODUCT_CONTROLLER() {
        return PRODUCT_CONTROLLER;
    }

    public OrderController getORDER_CONTROLLER() {
        return ORDER_CONTROLLER;
    }

    public ReceiptController getRECEIPT_CONTROLLER() {
        return RECEIPT_CONTROLLER;
    }

    public Customer getCustomerShopping() {
        return customerShopping;
    }

    public void setCustomerShopping(Customer customerShopping) {
        this.customerShopping = customerShopping;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
