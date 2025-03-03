package org.example.controller;

import org.example.model.businessobject.product.Product;
import org.example.view.ProductView;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private final MainController MAIN_CONTROLLER;
    private final ProductView PRODUCT_VIEW;

    public ProductController(MainController mainController) {
        MAIN_CONTROLLER = mainController;
        PRODUCT_VIEW = new ProductView();
    }

    public List<String> getProductListAsString(List<Product> productList) {
        List<String> productListAsString = new ArrayList<>();
        for (Product product : productList) {
            productListAsString.add(product.toString());
        }
        return productListAsString;
    }

    public ProductView getPRODUCT_VIEW() {
        return PRODUCT_VIEW;
    }
}
