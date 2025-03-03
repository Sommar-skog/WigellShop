package org.example.controller;

import org.example.model.businessobject.Customer;
import org.example.model.businessobject.Receipt;
import org.example.model.businessobject.order.Order;
import org.example.model.businessobject.product.Product;
import org.example.view.CustomerView;
import org.example.view.ReceiptView;

import java.util.List;

public class ReceiptController {

    private final ReceiptView RECEIPT_VIEW;
    private final MainController MAIN_CONTROLLER;
    private final CustomerView CUSTOMER_VIEW;

    public ReceiptController(MainController mainController) {
        MAIN_CONTROLLER = mainController;
        CUSTOMER_VIEW = mainController.getCUSTOMER_CONTROLLER().getCUSTOMER_VIEW();
        RECEIPT_VIEW = new ReceiptView(CUSTOMER_VIEW);
    }

    public void receipt() {
        Order currentOrder = MAIN_CONTROLLER.getCurrentOrder();
        Customer currentCustomer = MAIN_CONTROLLER.getCustomerShopping();
        Receipt receipt = new Receipt("Receipt",currentCustomer,currentOrder);

        List<Product> productList = currentOrder.getProductList();
        Double totalPrice = 0.0d;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }

        ProductController pc = MAIN_CONTROLLER.getPRODUCT_CONTROLLER();
        List<String> productListAsString = pc.getProductListAsString(productList);

        RECEIPT_VIEW.printReceiptTitle();
        RECEIPT_VIEW.printReceipt(receipt.getId(), receipt.getName(), receipt.getDate(),currentOrder.getName(),currentOrder.getId(), productListAsString, totalPrice
                ,currentCustomer.getId(),currentCustomer.getName(), currentCustomer.getAddress(), currentCustomer.getMail());

    }

    public ReceiptView getRECEIPT_VIEW() {
        return RECEIPT_VIEW;
    }
}
