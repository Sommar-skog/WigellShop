package org.example.model.businessobject;

import org.example.model.singleton.Id;

public abstract class Businessobjekt {

    private final Long id; //Ingen sätter för id eftersom final, och ska inte kunna ändras.
    protected String name;

    public Businessobjekt() {
        id = Id.getInstance().getNextId(this);
    }

    public Businessobjekt(String name) {
        this.name = name;
        id = Id.getInstance().getNextId(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Businessobjekt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
