package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.Skirt;
import org.example.model.businessobject.product.enums.ProductSpecification;
import org.example.model.businessobject.product.enums.SkirtPattern;

public class PatternCommand implements SewingProcessingCommand {

    public PatternCommand() {
    }

    @Override
    public Product process(Product product, ProductSpecification productSpecification) {
        if (product instanceof Skirt){
            if (productSpecification instanceof SkirtPattern){
                ((Skirt)product).setPattern((SkirtPattern)productSpecification);
                System.out.println("The skirt is customized according to the desired pattern.");
            } else {
                throw new IllegalArgumentException("The product specification is not a SkirtPattern");
            }
        } else {
            throw new IllegalArgumentException("The product is not Skirt");
        }
        return product;
    }
}
