package org.example.controller;

import org.example.model.businessobject.CEO;
import org.example.model.businessobject.Customer;
import org.example.model.businessobject.order.Order;
import org.example.model.observer.Notifier;
import org.example.view.*;


public class MainController {

    private final MenuView menuView = new MenuView();
    private final CustomerController customerController = new CustomerController(this);
    private final ProductController productController = new ProductController(this);
    private final OrderController orderController = new OrderController(this);
    private final ReceiptController receiptController = new ReceiptController(this);

    private Customer customerShopping;
    private Order currentOrder;
    private Notifier notifier;
    private boolean exit = false;

    public MainController() {
    }

    public void start(){
        mainAppLoop();
    }

    private void mainAppLoop(){

        createNotifier();

        while(!exit){
            currentOrder = new Order("Order");
            menuView.printWelcomeMessage();
            customerController.customer();
            orderController.order();
            receiptController.receipt();
            exitControl();
        }
    }

    private void createNotifier(){
        notifier = Notifier.getInstance();
        addObserversToNotifier();

    }

    private void addObserversToNotifier(){
        CEO ceo = new CEO("Wigell");
        notifier.addObserver(ceo);
    }

    private void exitControl(){
        exit = menuView.printExitQuestion();
    }

    public MenuView getMenuView() {
        return menuView;
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

    public Customer getCustomerShopping() {
        return customerShopping;
    }

    public void setCustomerShopping(Customer customerShopping) {
        this.customerShopping = customerShopping;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
