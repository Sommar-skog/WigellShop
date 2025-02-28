package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.TShirt;
import org.example.model.businessobject.product.enums.ProductSpecification;
import org.example.model.businessobject.product.enums.TShirtSleeves;

public class SleevesCommand implements SewingProcessingCommand{
    @Override
    public Product process(Product product, ProductSpecification productSpecification) {
        if (product instanceof TShirt){
            if (productSpecification instanceof TShirtSleeves){
                ((TShirt)product).setSleeves((TShirtSleeves)productSpecification);
            } else {
                throw new IllegalArgumentException("Product specification is not TShirtSleeves");
            }
        } else {
            throw new IllegalArgumentException("The product is not TShirt");
        }
        return product;
    }
}
