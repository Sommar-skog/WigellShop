package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.ProductSpecification;
import org.example.model.observer.Notifier;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public class SewingProcessingPipeline {

    Map<SewingProcessingCommand, ProductSpecification> pipeline = new HashMap<>();
    private PropertyChangeSupport propertyChangeSupport;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void addCommand(SewingProcessingCommand command, ProductSpecification specification) {
        pipeline.put(command, specification);
    }

    public void execute(Product product) {
        Product result = product;
        for (Map.Entry<SewingProcessingCommand, ProductSpecification> entry : pipeline.entrySet()) {
            result = entry.getKey().process(result, entry.getValue());
        }

        result.getNotifier().notifyObservers("Production of product finished", result.getName(), result.getId(), null, result);
    }

}
