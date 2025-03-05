package org.example.model.businessobject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO extends Businessobjekt implements PropertyChangeListener {

    private static CEO instance;

    private CEO() {
        name = "Wigell";
    }

    public static CEO getInstance() {
        if (instance == null) {
            instance = new CEO();
        }
        return instance;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("CEO " + name + " got notified: " + evt.getPropertyName());
    }
}
