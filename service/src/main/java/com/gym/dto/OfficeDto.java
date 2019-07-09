package com.gym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class OfficeDto {

    private Integer id;

    @NotBlank
    private String name;

    @Positive
    private Integer coachId;

    @Positive
    private Integer roomId;

    public OfficeDto(@NotBlank String name, @Positive Integer coachId,
                     @Positive Integer roomId) {
        this.name = name;
        this.coachId = coachId;
        this.roomId = roomId;
    }

    public OfficeDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficeDto officeDto = (OfficeDto) o;
        return Objects.equals(id, officeDto.id) &&
                Objects.equals(name, officeDto.name) &&
                Objects.equals(coachId, officeDto.coachId) &&
                Objects.equals(roomId, officeDto.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coachId, roomId);
    }

    @Override
    public String toString() {
        return "OfficeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coachId=" + coachId +
                ", roomId=" + roomId +
                '}';
    }
}
