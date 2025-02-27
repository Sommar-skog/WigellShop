package org.example.model.businessobject;

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

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                "} " + super.toString();
    }
}


