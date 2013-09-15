package com.codaconsultancy.casework.model.user.entity;

import com.codaconsultancy.casework.dto.user.UserDTO;
import org.apache.commons.validator.routines.EmailValidator;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "USERS")
public class User implements java.io.Serializable {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String emailAddress;
    private boolean isActive;

    //TODO: get rid
    public boolean verifyPassword(String password) {

        return false;
    }

    @Id
    @GeneratedValue
    @Column(unique = true)
    @NotNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true)
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "FIRST_NAME")
    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Number '" + phoneNumber + "' is not valid");
        }
    }

    @Column
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "EMAIL_ADDRESS")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        if (EmailValidator.getInstance().isValid(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            throw new IllegalArgumentException("Email address '" + emailAddress + "' is not valid");
        }

    }

    @Column
    @NotNull
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        boolean isValidNumber = true;
        if (null != phoneNumber) {
            String numericOnlyPhoneNumber = phoneNumber.replaceAll("[+-.() ]", "");
            if (numericOnlyPhoneNumber.isEmpty()) {
                isValidNumber = false;
            } else {
                try {
                    Long.parseLong(numericOnlyPhoneNumber);
                } catch (NumberFormatException e) {
                    isValidNumber = false;
                }
            }
        }
        return isValidNumber;
    }

    public UserDTO toDTO() {
        Mapper mapper = new DozerBeanMapper();
        return mapper.map(this, UserDTO.class);
    }
}
