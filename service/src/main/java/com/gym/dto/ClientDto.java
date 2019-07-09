package com.gym.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class ClientDto {

    private Integer id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String login;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String phoneNumber;

    @Positive
    private Integer officeId;

    public ClientDto(@NotBlank @Email String email, @NotBlank String login,
                     @NotBlank String name, @NotBlank String password, @NotBlank String phoneNumber,
                     @Positive Integer officeId) {
        this.email = email;
        this.login = login;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.officeId = officeId;
    }

    public ClientDto(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
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
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(id, clientDto.id) &&
                Objects.equals(email, clientDto.email) &&
                Objects.equals(login, clientDto.login) &&
                Objects.equals(name, clientDto.name) &&
                Objects.equals(password, clientDto.password) &&
                Objects.equals(phoneNumber, clientDto.phoneNumber) &&
                Objects.equals(officeId, clientDto.officeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, login, name, password, phoneNumber, officeId);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", officeId=" + officeId +
                '}';
    }
}
