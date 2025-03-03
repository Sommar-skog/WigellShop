package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.TShirt;
import org.example.model.businessobject.product.enums.ProductSpecification;
import org.example.model.businessobject.product.enums.TShirtNeck;

public class NeckCommand implements SewingProcessingCommand{
    @Override
    public Product process(Product product, ProductSpecification productSpecification) {
        if (product instanceof TShirt) {
            if (productSpecification instanceof TShirtNeck){
                ((TShirt)product).setNeck((TShirtNeck)productSpecification);
                System.out.println("The t-shirt is customized according to the desired neck.");
            } else{
                throw new IllegalArgumentException("The product specification is not TShirtNeck");
            }
        } else {
            throw new IllegalArgumentException("The product is not TShirt");
        }

        return product;
    }
}
