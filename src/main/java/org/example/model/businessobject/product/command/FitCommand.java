package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.PantsFit;
import org.example.model.businessobject.product.enums.ProductSpecification;

public class FitCommand implements SewingProcessingCommand {

    public FitCommand() {
    }

    @Override
    public Product process(Product product, ProductSpecification productSpecification) {
        if (product instanceof Pants) {
            if (productSpecification instanceof PantsFit) {
                ((Pants) product).setFit((PantsFit) productSpecification);
                System.out.println("The pants are customized according to the desired fit.");
            } else{
                throw new IllegalArgumentException("The product specification is not a PantsFit");
            }
        } else{
            throw new IllegalArgumentException("The product is not Pants");
        }
             return product;
    }
}
