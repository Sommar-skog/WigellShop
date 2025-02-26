package org.example.model.businessobject;

public abstract class Businessobjekt {

    private Long id;
    private String name;

    public Businessobjekt() {
        id = Id.getInstance.setNextId();
    }

    public Long getId() {
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
