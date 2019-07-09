package com.gym.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Office extends BaseEntity {

    @OneToMany(mappedBy = "office")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "office")
    private List<Client> clients;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "coachId")
    private Coach coach;

    private String name;

    public Office(Room room, Coach coach, String name) {
        this.room = room;
        this.coach = coach;
        this.name = name;
    }

    public Office(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
