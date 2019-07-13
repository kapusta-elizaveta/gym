package com.gym.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleSubscription extends BaseEntity{

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "clientId")
    private Client client;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "subscriptionsId")
    private Subscription subscription;

    private String startDate;

    private String endDate;

    public SaleSubscription(Client client, Subscription subscription, String startDate, String endDate) {
        this.client = client;
        this.subscription = subscription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SaleSubscription(){}

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
