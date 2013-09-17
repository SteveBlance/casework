package com.codaconsultancy.casework.user;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.service.Administration.AdministrationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserController {

    @Inject
    UserModel userModel;

    @Inject
    AdministrationService administrationService;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = administrationService.getAllUsers();
        userModel.setAllUsers(users);
        return userModel.getAllUsers();
    }


    public void addNewUser() {
        UserDTO newUser = userModel.getUser();
        administrationService.addNewUser(newUser);
    }
}
