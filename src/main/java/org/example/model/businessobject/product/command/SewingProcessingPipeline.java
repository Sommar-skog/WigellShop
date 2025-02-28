package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SewingProcessingPipeline {

    private List<SewingProcessingCommand> pipeline = new ArrayList<>();

    public void addCommand(SewingProcessingCommand command) {
        pipeline.add(command);
    }

    public Product execute(Product product) {
        Product result = product;
        for (SewingProcessingCommand command : pipeline) {
            result = command.process(result);
        }
        return result;
    }

}
