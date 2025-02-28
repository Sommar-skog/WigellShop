package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;

public interface SewingProcessingCommand {
    Product process(Product product);
}
