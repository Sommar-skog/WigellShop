package org.example.controller;

import org.example.model.businessobject.Customer;
import org.example.model.businessobject.product.enums.*;
import org.example.view.*;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private final MenuView MENU_VIEW = new MenuView();
    private final CustomerView CUSTOMER_VIEW = new CustomerView();
    private final ProductView PRODUCT_VIEW = new ProductView();
    private final OrderView ORDER_VIEW = new OrderView();
    private final CEOView CEO_VIEW = new CEOView();

    private final CEOController CEO_CONTROLLER = new CEOController();
    private final CustomerController CUSTOMER_CONTROLLER = new CustomerController();
    private final ProductController PRODUCT_CONTROLLER = new ProductController();
    private final OrderController ORDER_CONTROLLER = new OrderController();
    private final ReceiptController RECEIPT_CONTROLLER = new ReceiptController();

    private Customer customerShopping;



    public void start(){
        mainAppLoo();
    }

    private void mainAppLoo(){
        boolean exit = false;
        while(!exit){
            MENU_VIEW.printWelcomeMessage();
            CUSTOMER_CONTROLLER.customer();
            ORDER_CONTROLLER.order();



        }
    }



}
