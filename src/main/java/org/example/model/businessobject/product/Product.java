package org.example.model.businessobject.product;

import org.example.model.businessobject.Businessobjekt;
import org.example.model.businessobject.CEO;
import org.example.model.businessobject.product.enums.ClothingColor;
import org.example.model.businessobject.product.enums.ClothingMaterial;
import org.example.model.businessobject.product.enums.ClothingSize;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Product extends Businessobjekt {
    private ClothingSize clothingSize;
    private ClothingColor clothingColor;
    private ClothingMaterial clothingMaterial;
    protected double price;
    private PropertyChangeSupport propertyChangeSupport;
    private CEO ceo = new CEO("Wigell");

    public Product() {
        super();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        addPropertyChangeListener(ceo);
        this.propertyChangeSupport.firePropertyChange("Start Production of new Product",null,this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public ClothingSize getSize() {
        return clothingSize;
    }

    public void setSize(ClothingSize clothingSize) {
        this.clothingSize = clothingSize;
    }

    public ClothingColor getColor() {
        return clothingColor;
    }

    public void setColor(ClothingColor clothingColor) {
        this.clothingColor = clothingColor;
    }

    public ClothingMaterial getMaterial() {
        return clothingMaterial;
    }

    public void setMaterial(ClothingMaterial clothingMaterial) {
        this.clothingMaterial = clothingMaterial;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "clothingSize=" + clothingSize +
                ", clothingColor=" + clothingColor +
                ", clothingMaterial=" + clothingMaterial +
                ", price=" + price +
                "} " + super.toString();
    }
}
