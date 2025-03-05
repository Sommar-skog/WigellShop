package org.example.controller;

import org.example.model.businessobject.Customer;
import org.example.model.businessobject.Receipt;
import org.example.model.businessobject.order.Order;
import org.example.model.businessobject.product.Product;
import org.example.view.CustomerView;
import org.example.view.ReceiptView;

import java.util.List;

public class ReceiptController {

    private final ReceiptView receiptView;
    private final MainController mainController;
    private final CustomerView customerView;

    public ReceiptController(MainController mainController) {
        this.mainController = mainController;
        customerView = mainController.getCustomerController().getCustomerView();
        receiptView = new ReceiptView(customerView);
    }

    public void receipt() {
        Order currentOrder = mainController.getCurrentOrder();
        Customer currentCustomer = mainController.getCustomerShopping();
        Receipt receipt = new Receipt("Receipt",currentCustomer,currentOrder);

        List<Product> productList = currentOrder.getProductList();
        double totalPrice = 0.0d;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }

        ProductController pc = mainController.getProductController();
        List<String> productListAsString = pc.getProductListAsString(productList);

        receiptView.printReceiptTitle();
        receiptView.printReceipt(receipt.getId(), receipt.getName(), receipt.getDate(),currentOrder.getName(),currentOrder.getId(), productListAsString, totalPrice
                ,currentCustomer.getId(),currentCustomer.getName(), currentCustomer.getAddress(), currentCustomer.getMail());

    }
}
