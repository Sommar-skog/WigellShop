package org.example.model.businessobject;

public abstract class Businessobjekt {

    private int id;
    private String name;

    public Businessobjekt() {
        setId();
    }
    public Businessobjekt(String name) {
        this.name = name;
        setId();
    }

    public int getId() {
        return id;
    }

    public abstract void setId();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
