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

}
