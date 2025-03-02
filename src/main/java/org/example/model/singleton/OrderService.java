package org.example.model.singleton;

import org.example.model.businessobject.order.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final List<OrderItem> ITEMS_TO_ORDER;

    private static OrderService instance;

    private OrderService() {
        ITEMS_TO_ORDER = new ArrayList<>();
    }
    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void addItemToOrderList(OrderItem item) {
        ITEMS_TO_ORDER.add(item);
    }
}
