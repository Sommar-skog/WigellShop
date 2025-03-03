package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.PantsFit;
import org.example.model.businessobject.product.enums.PantsLength;
import org.example.model.businessobject.product.enums.ProductSpecification;

public class LengthCommand implements SewingProcessingCommand{
    @Override
    public Product process(Product product, ProductSpecification productSpecification) {
        if (product instanceof Pants){
            if ( productSpecification instanceof PantsLength){
                ((Pants) product).setLength((PantsLength)productSpecification);
                System.out.println("The pants are customized according to the desired length.");
            } else{
                throw new IllegalArgumentException("Length command requires a PantsLength specification");
            }
        } else {
            throw new IllegalArgumentException("The Product is not a Pants");
        }
        return product;
    }
}
