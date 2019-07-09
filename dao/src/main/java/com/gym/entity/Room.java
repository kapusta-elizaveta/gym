package com.gym.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Room extends BaseEntity{

     @OneToMany(mappedBy = "room")
     private List<Office> offices;

     private String name;

     public Room(String name) {
          this.name = name;
     }

     public Room(){}

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

}
