package com.gym.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class CoachDto {

    private Integer id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    public CoachDto(@NotBlank @Email String email, @NotBlank String name,
                    @NotBlank String phoneNumber) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }



    public CoachDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachDto coachDto = (CoachDto) o;
        return Objects.equals(id, coachDto.id) &&
                Objects.equals(email, coachDto.email) &&
                Objects.equals(name, coachDto.name) &&
                Objects.equals(phoneNumber, coachDto.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, phoneNumber);
    }

    @Override
    public String toString() {
        return "CoachDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
