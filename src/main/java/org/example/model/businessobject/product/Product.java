package org.example.model.businessobject.product;

import org.example.model.businessobject.Businessobjekt;
import org.example.model.businessobject.product.enums.ClothingColor;
import org.example.model.businessobject.product.enums.ClothingMaterial;
import org.example.model.businessobject.product.enums.ClothingSize;

public abstract class Product extends Businessobjekt {
    private ClothingSize clothingSize;
    private ClothingColor clothingColor;
    private ClothingMaterial clothingMaterial;

    public Product(String name, ClothingSize clothingSize, ClothingColor clothingColor, ClothingMaterial clothingMaterial) {
        super(name);
        this.clothingSize = clothingSize;
        this.clothingColor = clothingColor;
        this.clothingMaterial = clothingMaterial;
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

    @Override
    public String toString() {
        return "Product{" +
                "clothingSize=" + clothingSize +
                ", clothingColor=" + clothingColor +
                ", clothingMaterial=" + clothingMaterial +
                "} " + super.toString();
    }
}
