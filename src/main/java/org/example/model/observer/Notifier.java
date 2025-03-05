package org.example.model.observer;


import org.example.model.businessobject.Businessobjekt;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Notifier {

    private final List<Businessobjekt> observers;
    private final PropertyChangeSupport support;
    private static Notifier instance;

    private Notifier() {
        observers = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    public static Notifier getInstance() {
        if (instance == null) {
            instance = new Notifier();
        }
        return instance;
    }

    public void addObserver(Businessobjekt observer) {
        observers.add(observer);
        addPropertyChangeListener((PropertyChangeListener) observer);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeObserver(Businessobjekt observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message, String name, long productId, Object oldValue, Object newValue) {
        for (Businessobjekt observer : observers) {
            support.firePropertyChange(message + ": "+ name + ", Product ID: " + productId, oldValue, newValue);

        }
    }
}
