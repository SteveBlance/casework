package com.codaconsultancy.casework.user;

import com.codaconsultancy.casework.dto.user.UserDTO;

import java.util.List;

public class UserModel {

    private List<UserDTO> allUsers;
    private UserDTO user;

    public void setAllUsers(List<UserDTO> allUsers) {
        this.allUsers = allUsers;
    }

    public List<UserDTO> getAllUsers() {
        return allUsers;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
