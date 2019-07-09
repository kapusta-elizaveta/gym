package com.gym.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Schedule extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "officeId")
    private Office office;


    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;


    private String startTime;

    private String endTime;

    public Schedule(Office office, Room room, String startTime, String endTime) {
        this.office = office;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Schedule(){}

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
