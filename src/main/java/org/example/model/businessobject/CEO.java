package org.example.model.businessobject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO extends Businessobjekt implements PropertyChangeListener {

    public CEO() {
        super();
    }

    public CEO(String name) {
        super(name);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("CEO " + name + " got notified: " + evt.getPropertyName());
    }

    @Override
    public String toString() {
        return "CEO{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
