package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.ProductSpecification;

public interface SewingProcessingCommand {
     Product process(Product product, ProductSpecification productSpecification);
}
