package com.gym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class ScheduleDto {

    private Integer id;

    @NotBlank
    private String startTime;

    @NotBlank
    private String endTime;

    @Positive
    private Integer officeId;

    @Positive
    private Integer roomId;

    public ScheduleDto(@NotBlank String startTime, @NotBlank String endTime,
                       @Positive Integer officeId, @Positive Integer roomId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.officeId = officeId;
        this.roomId = roomId;
    }

    public ScheduleDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleDto that = (ScheduleDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(officeId, that.officeId) &&
                Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, officeId, roomId);
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", officeId=" + officeId +
                ", roomId=" + roomId +
                '}';
    }
}
