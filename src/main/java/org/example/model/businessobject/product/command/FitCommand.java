package org.example.model.businessobject.product.command;

import net.bytebuddy.implementation.bytecode.Throw;
import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.PantsFit;
import org.example.model.businessobject.product.enums.ProductSpecification;

public class FitCommand implements SewingProcessingCommand {


    @Override
    public Product process(Product product, ProductSpecification productSpecification) {
        if (product instanceof Pants) {
            if (productSpecification instanceof PantsFit) {
                ((Pants) product).setFit((PantsFit) productSpecification);
            } else{
                throw new IllegalArgumentException("The product specification is not a PantsFit");
            }
        } else{
            throw new IllegalArgumentException("The product is not Pants");
        }
             return product;
    }
}
