package com.gym.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Subscription extends BaseEntity{

    @OneToMany(mappedBy = "subscription")
    private List<SaleSubscription> saleSubscriptions;


    private double price;

    private int numberVisits;


    public Subscription(double price, int numberVisits) {
        this.price = price;
        this.numberVisits = numberVisits;
    }

    public Subscription(){}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberVisits() {
        return numberVisits;
    }

    public void setNumberVisits(int numberVisits) {
        this.numberVisits = numberVisits;
    }



}
