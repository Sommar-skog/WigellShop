package org.example.model.businessobject.product;

import org.example.model.businessobject.Businessobjekt;

public abstract class Product extends Businessobjekt {
    private Size size;
    private Color color;
    private Material material;

    public Product(String name, Size size, Color color, Material material) {
        super(name);
        this.size = size;
        this.color = color;
        this.material = material;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Product{" +
                "size=" + size +
                ", color=" + color +
                ", material=" + material +
                "} " + super.toString();
    }
}
