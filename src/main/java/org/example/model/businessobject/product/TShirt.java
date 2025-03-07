package org.example.model.businessobject.product;

import org.example.model.businessobject.product.enums.TShirtNeck;
import org.example.model.businessobject.product.enums.TShirtSleeves;

public class TShirt extends Product {

    private TShirtSleeves sleeves;
    private TShirtNeck neck;

    public TShirt() {
        super();
        this.price = 499.90;
        this.name = "T-Shirt";
        getNotifier().notifyObservers("Start Production of new Product",name,getId(),null,this);
    }

    public TShirtSleeves getSleeves() {
        return sleeves;
    }

    public void setSleeves(TShirtSleeves sleeves) {
        this.sleeves = sleeves;
    }

    public TShirtNeck getNeck() {
        return neck;
    }

    public void setNeck(TShirtNeck neck) {
        this.neck = neck;
    }

    @Override
    public String toString() {
        return "T-shirt {ID: " + getId() + ", Name: "+ getName()
                + ", Size: " + getSize() + ", Color: "+ getColor()
                + ", Material: " + getMaterial() + ", Sleeves: "+ sleeves + ", Neck: "
                + neck + ", Price: " + getPrice() + "}";
    }
}
