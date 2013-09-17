package com.codaconsultancy.casework.dto.user;

import com.codaconsultancy.casework.model.user.entity.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class UserDTO {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String emailAddress;
    private boolean isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User toUser() {
        Mapper mapper = new DozerBeanMapper();
        return mapper.map(this, User.class);
    }
}
