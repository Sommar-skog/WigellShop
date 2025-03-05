package org.example.model.singleton;

import org.example.model.businessobject.order.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final List<OrderItem> itemsToOrder;

    private static OrderService instance;

    private OrderService() {
        itemsToOrder = new ArrayList<>();
    }
    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void addItemToOrderList(OrderItem item) {
        itemsToOrder.add(item);
    }

    public void removeAllItemsFromOrderList() {
        itemsToOrder.clear();
    }

    public List<OrderItem> getItemsToOrderList() {
        return itemsToOrder;
    }
}
