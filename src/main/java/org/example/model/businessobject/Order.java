package org.example.model.businessobject;

import org.example.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order extends Businessobjekt {

    private List<Product> productList;

    public Order(String name) {
        super(name);
        productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    @Override
    public void setId() {

    }
}
