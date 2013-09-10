package com.codaconsultancy.casework.model.user.entity;

import javax.persistence.Entity;

@Entity
public class User {
    public boolean verifyPassword(String password) {
        return false;
    }
}
