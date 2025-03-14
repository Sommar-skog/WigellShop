package org.example.model.businessobject.product;

import org.example.model.businessobject.product.enums.SkirtPattern;
import org.example.model.businessobject.product.enums.SkirtWaistline;

public class Skirt extends Product{

    private SkirtWaistline waistline;
    private SkirtPattern pattern;

    public Skirt() {
        super();
        this.price = 649.99;
        this.name = "Skirt";
        getNotifier().notifyObservers("Start Production of new Product",name,getId(),null,this);
    }

    public SkirtWaistline getWaistline() {
        return waistline;
    }

    public void setWaistline(SkirtWaistline waistline) {
        this.waistline = waistline;
    }

    public SkirtPattern getPattern() {
        return pattern;
    }

    public void setPattern(SkirtPattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Skirt {ID: " + getId() + ", Name: "+ getName()
                + ", Size: " + getSize() + ", Color: "+ getColor()
                + ", Material: " + getMaterial() + ", Waistline: "+ waistline + ", Pattern: "
                + pattern + ", Price: " + getPrice() + "}";
    }
}
