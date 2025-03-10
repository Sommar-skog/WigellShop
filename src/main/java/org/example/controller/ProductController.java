package org.example.controller;

import org.example.model.businessobject.product.Product;
import org.example.view.ProductView;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private final MainController mainController;
    private final ProductView productView;

    public ProductController(MainController mainController) {
        this.mainController = mainController;
        productView = new ProductView();
    }

    public List<String> getProductListAsString(List<Product> productList) {
        List<String> productListAsString = new ArrayList<>();
        for (Product product : productList) {
            productListAsString.add(product.toString());
        }
        return productListAsString;
    }

    public ProductView getProductView() {
        return productView;
    }

}
