package org.example.model.businessobject;

import org.example.model.businessobject.order.Order;

public class Customer extends Businessobjekt {

    private String address;
    private String mail;
    private Order order;

    public Customer(String name, String address, String mail) {
        super(name);
        this.address = address;
        this.mail = mail;
        this.order = new Order("Order");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public String getAddress() {
        return address;
    }
    public String getMail() {
        return mail;
    }
    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Customer: \n"
                + "ID: " + getId() + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Mail: " + mail + "\n";
    }
}


