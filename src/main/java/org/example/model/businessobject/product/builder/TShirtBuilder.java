package org.example.model.businessobject.product.builder;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.TShirt;

public class TShirtBuilder extends ProductBuilder {
    @Override
    public Product createProduct() {
        return new TShirt();
    }
}
