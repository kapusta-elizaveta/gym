package com.gym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class SubscriptionDto {

    private Integer id;

    @NotBlank
    private int numberVisits;

    @Positive
    @NotBlank
    private double price;

    public SubscriptionDto( @NotBlank int numberVisits,
                           @Positive @NotBlank double price) {
        this.numberVisits = numberVisits;
        this.price = price;
    }

    public SubscriptionDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumberVisits() {
        return numberVisits;
    }

    public void setNumberVisits(int numberVisits) {
        this.numberVisits = numberVisits;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionDto that = (SubscriptionDto) o;
        return numberVisits == that.numberVisits &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberVisits, price);
    }

    @Override
    public String toString() {
        return "SubscriptionDto{" +
                "id=" + id +
                ", numberVisits=" + numberVisits +
                ", price=" + price +
                '}';
    }
}
