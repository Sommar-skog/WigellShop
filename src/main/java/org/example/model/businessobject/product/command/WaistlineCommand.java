package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.Skirt;
import org.example.model.businessobject.product.enums.ProductSpecification;
import org.example.model.businessobject.product.enums.SkirtWaistline;

public class WaistlineCommand implements SewingProcessingCommand{

    public WaistlineCommand() {
    }

    @Override
    public Product process(Product product, ProductSpecification productSpecification) {
        if (product instanceof Skirt){
            if (productSpecification instanceof SkirtWaistline){
                ((Skirt)product).setWaistline((SkirtWaistline)productSpecification);
                System.out.println("The skirt is customized according to the desired waistline.");
            } else {
                throw new IllegalArgumentException("The product specification is not a skirt waistline");
            }
        } else {
            throw new IllegalArgumentException("The product is not a skirt");
        }
        return product;
    }
}
