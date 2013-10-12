package com.codaconsultancy.casework.user;

import com.codaconsultancy.casework.dto.user.UserDTO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserModel implements Serializable {

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
