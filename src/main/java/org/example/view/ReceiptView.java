package org.example.view;

import java.util.Date;
import java.util.List;

public class ReceiptView {

    public void printReceipt(long receiptId, String receiptName, Date orderDate, String orderName, long orderId , List<String> productList) {
        System.out.println("---------------------------------------------------------");
        System.out.println("            " + receiptName.toUpperCase() + " - id:" + receiptId +"\n\n" +
                orderName + "- id: " + orderId + "\n" +
                orderDate);
        System.out.println();
        for (String product : productList) {
            System.out.println(product);
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }
}
