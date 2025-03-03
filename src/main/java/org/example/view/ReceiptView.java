package org.example.view;

import java.util.Date;
import java.util.List;

public class ReceiptView {

    private CustomerView customerView;

    public ReceiptView(CustomerView customerView) {
        this.customerView = customerView;
    }

    public void printReceiptTitle() {
        System.out.println("\n\n");
        System.out.println("            - - - RECEIPT - - -");
    }

    public void printReceipt(long receiptId, String receiptName, Date orderDate, String orderName,
                             long orderId , List<String> productList, double totalPrice,
                             Long customerId, String customerName,
                             String customerAddress, String customerMail  ) {
        System.out.println("---------------------------------------------------------");
        System.out.println("            " + receiptName.toUpperCase() + " - id:" + receiptId +"\n\n" +
                orderName + " - id: " + orderId + "\n" +
                orderDate);
        System.out.println();
        for (String product : productList) {
            System.out.println(product);
        }
        System.out.println();
        System.out.println("Total price: " + totalPrice);
        System.out.println("--------------------");
        customerView.printCustomerDetails("Customer details",customerId,customerName,customerAddress,customerMail);
        System.out.println("--------------------");
        System.out.println("Thank you for shopping! Have a nice day!");
        System.out.println("----------------------------------------------------------");
        System.out.println("\n\n");
    }
}
