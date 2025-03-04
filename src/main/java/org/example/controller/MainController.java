package org.example.controller;

import org.example.model.businessobject.Customer;
import org.example.model.businessobject.order.Order;
import org.example.view.*;


public class MainController {

    private final MenuView menuView = new MenuView();

    private final CEOController ceoController = new CEOController(this);
    private final CustomerController customerController = new CustomerController(this);
    private final ProductController productController = new ProductController(this);
    private final OrderController orderController = new OrderController(this);
    private final ReceiptController receiptController = new ReceiptController(this);

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
            menuView.printWelcomeMessage();
            customerController.customer();
            orderController.order();
            receiptController.receipt();
            exitControl();
        }
    }

    private void exitControl(){
        exit = menuView.printExitQuestion();
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public CEOController getCeoController() {
        return ceoController;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

    public ProductController getProductController() {
        return productController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public ReceiptController getReceiptController() {
        return receiptController;
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
