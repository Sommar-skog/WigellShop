package org.example.model.businessobject;

import org.example.model.businessobject.product.Product;

import java.util.Date;
import java.util.List;

public class Receipt extends Businessobjekt {

    private Date date;
    private List<Product> productList;

    public Receipt(String name, List<Product> productList) {
        super(name);
        this.productList = productList;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                ", date=" + date +
                "} " + super.toString();
    }
}
