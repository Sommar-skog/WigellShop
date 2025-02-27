package org.example.model.singleton;

import org.example.model.businessobject.*;
import org.example.model.businessobject.product.Product;

public class Id {
    //TODO Ska klassen göras trådsäker? i så fall syncronized och volotile

    private long CustomerId = 0;
    private long ProductId = 0;
    private long OrderId = 0;
    private long ReceiptId = 0;
    private long CEOId = 0;

    private static Id instance;

    private Id() {

    }

    public static Id getInstance() {
        if (instance == null) {
            instance = new Id();
        }
        return instance;
    }

    public long getNextId (Businessobjekt businessobjekt) {
        if (businessobjekt instanceof Product) {
            return ++CustomerId;
        } else if (businessobjekt instanceof Customer){
            return ++ProductId;
        } else if (businessobjekt instanceof Order){
            return ++OrderId;
        } else if (businessobjekt instanceof Receipt){
            return ++ReceiptId;
        } else if (businessobjekt instanceof CEO){
            return ++CEOId;
        } else {
            throw new UnsupportedOperationException("ID generation not supported for: " + businessobjekt.getClass().getSimpleName());
        }
    }

}
