package org.example.model.businessobject.product.builder;


import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.ClothingColor;
import org.example.model.businessobject.product.enums.ClothingMaterial;
import org.example.model.businessobject.product.enums.ClothingSize;
import org.example.model.singleton.Id;



public abstract class ProductBuilder {

    private Product product;

    public ProductBuilder() {
        this.product = createProduct();
    }
    public abstract Product createProduct();

    public ProductBuilder addSize (ClothingSize size) {
        if (size != null) {
            product.setSize(size);
        } else {
            throw new IllegalArgumentException("Size cannot be null");
        }
        return this;
    }

    public ProductBuilder addMaterial(ClothingMaterial material) {
        if (material != null) {
            product.setMaterial(material);
        } else {
            throw new IllegalArgumentException("Material cannot be null");
        }
        return this;
    }

    public ProductBuilder addColor(ClothingColor color) {
        if (color != null) {
            product.setColor(color);
        } else {
            throw new IllegalArgumentException("Color cannot be null");
        }
        return this;
    }

    public Product build() {
        if (product.getSize() == null) {
            throw new IllegalArgumentException("Size was never set. Use addSize() before build()");
        }
        if (product.getMaterial() == null) {
            throw new IllegalArgumentException("Material was never set. Use addMaterial() before build()");
        }
        if (product.getColor() == null) {
            throw new IllegalArgumentException("Color was never set. Use addColor() before build()");
        }

        return product;
    }

    public Product getProduct() { //Används vid testning
        return product;
    }
}
