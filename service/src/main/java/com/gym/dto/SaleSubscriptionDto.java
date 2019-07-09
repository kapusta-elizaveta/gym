package com.gym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class SaleSubscriptionDto {

    private Integer id;

    @NotBlank
    private String endDate;

    @NotBlank
    private String startDate;

    @Positive
    private Integer clientId;

    @Positive
    private Integer subscriptionsId;

    public SaleSubscriptionDto(@NotBlank String endDate,
                               @NotBlank String startDate, @Positive Integer clientId,
                               @Positive Integer subscriptionsId) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.clientId = clientId;
        this.subscriptionsId = subscriptionsId;
    }

    public SaleSubscriptionDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSubscriptionsId() {
        return subscriptionsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleSubscriptionDto that = (SaleSubscriptionDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(subscriptionsId, that.subscriptionsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endDate, startDate, clientId, subscriptionsId);
    }

    @Override
    public String toString() {
        return "SaleSubscriptionDto{" +
                "id=" + id +
                ", endDate='" + endDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", clientId=" + clientId +
                ", subscriptionsId=" + subscriptionsId +
                '}';
    }
}
