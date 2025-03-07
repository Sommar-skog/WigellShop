package org.example.model.businessobject.product.builder;

import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Product;


public class PantsBuilder extends ProductBuilder {

    public PantsBuilder() {
        super();
    }

    @Override
    public Product createProduct() {
        return new Pants();
    }

}


