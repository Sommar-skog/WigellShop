package org.example.model.businessobject.product;

import org.example.model.businessobject.Businessobjekt;
import org.example.model.businessobject.product.enums.ClothingColor;
import org.example.model.businessobject.product.enums.ClothingMaterial;
import org.example.model.businessobject.product.enums.ClothingSize;
import org.example.model.observer.Notifier;

public abstract class Product extends Businessobjekt {
    private ClothingSize clothingSize;
    private ClothingColor clothingColor;
    private ClothingMaterial clothingMaterial;
    protected double price;
    protected final Notifier notifier = Notifier.getInstance();

    public Product() {
        super();
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

    public Notifier getNotifier() {
        return notifier;
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
