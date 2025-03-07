package org.example.model.businessobject.order;

import org.example.model.businessobject.Businessobjekt;
import org.example.model.businessobject.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order extends Businessobjekt {

    private List<Product> productList;

    public Order() {
        super();
    }

    public Order(String name) {
        super(name);
        productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productList=" + productList +
                "} " + super.toString();
    }
}
