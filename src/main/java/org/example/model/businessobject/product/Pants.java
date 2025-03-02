package org.example.model.businessobject.product;

import org.example.model.businessobject.product.enums.*;

public class Pants extends Product{

    private PantsFit fit;
    private PantsLength length;

    public Pants() {
        super();
        this.price = 899.90;
        this.name = "Pants";
        getPropertyChangeSupport().firePropertyChange("Start Production of new Product: " + name + ", Product ID: " + getId(), null, this);
    }

    public PantsFit getFit() {
        return fit;
    }

    public void setFit(PantsFit fit) {
        this.fit = fit;
    }

    public PantsLength getLength() {
        return length;
    }

    public void setLength(PantsLength length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Pants {ID: " + getId() + ", Name: "+ getName()
                + ", Size: " + getSize() + ", Color: "+ getColor()
                + ", Material: " + getMaterial() + ", Length: "+ length + ", Fit: "
                + fit + ", Price: " + getPrice() + "}";
    }
}
