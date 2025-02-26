package org.example.model.businessobject.product.builder;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.Skirt;

public class SkirtBuilder extends ProductBuilder {
    @Override
    public Product createProduct() {
        return new Skirt();
    }
}
