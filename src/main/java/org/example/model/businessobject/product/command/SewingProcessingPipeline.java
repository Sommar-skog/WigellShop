package org.example.model.businessobject.product.command;

import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.ProductSpecification;


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

    public Product execute(Product product) {
        Product oldProduct = product;
        Product result = product;
        for (Map.Entry<SewingProcessingCommand, ProductSpecification> entry : pipeline.entrySet()) {
            result = entry.getKey().process(result, entry.getValue());
        }
        result.getPropertyChangeSupport().firePropertyChange("Production of product finished: " + result.getName() + ", Product ID: " + result.getId(), null, result); //Null så att jag inte behöver skapa en ny product för att hålla de gamla värderna, eftersom då blir ID genereringen fel.
        //result.getPropertyChangeSupport().firePropertyChange("Production of product finished: " +result.getName(),oldProduct,result);

        return result;
    }



}
