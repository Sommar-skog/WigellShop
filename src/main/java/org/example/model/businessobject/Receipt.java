package org.example.model.businessobject;

import org.example.model.businessobject.order.Order;

import java.util.Date;

public class Receipt extends Businessobjekt {

    private Date date;
    private Order order;
    private Customer customer;

    public Receipt() {
        super();
    }

    public Receipt(String name, Customer customer, Order order ) {
        super(name);
        this.customer = customer;
        this.order = order;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "date=" + date +
                ", order=" + order +
                ", customer=" + customer +
                "} " + super.toString();
    }
}
