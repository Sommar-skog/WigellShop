package org.example.model.businessobject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO extends Businessobjekt implements PropertyChangeListener {

    public CEO(String name) {
        super(name);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("CEO " + name + " got notified: " + evt.getPropertyName());
    }
}
