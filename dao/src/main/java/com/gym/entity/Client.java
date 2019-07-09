package com.gym.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client extends BaseEntity {

    @OneToMany(mappedBy = "client")
    private List<SaleSubscription> saleSubscriptions;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "officeId")
    private Office office;

    private String name;

    private String login;

    private String email;

    private String password;

    private String phoneNumber;

    public Client(){};

    public Client(Office office, String name, String login, String email, String password, String phoneNumber) {
        this.office = office;
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(saleSubscriptions, client.saleSubscriptions) &&
                Objects.equals(office, client.office) &&
                Objects.equals(name, client.name) &&
                Objects.equals(login, client.login) &&
                Objects.equals(email, client.email) &&
                Objects.equals(password, client.password) &&
                Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleSubscriptions, office, name, login, email, password, phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "saleSubscriptions=" + saleSubscriptions +
                ", office=" + office +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
