package com.codaconsultancy.casework.useradmin;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.service.administration.AdministrationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserController {

    @Inject
    private
    UserModel userModel;

    @Inject
    AdministrationService administrationService;

    private UserDTO selectedUser;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = administrationService.getAllActiveUsers();
        userModel.setAllUsers(users);
        return userModel.getAllUsers();
    }

    public void addNewUser() {
        UserDTO newUser = userModel.getUser();
        administrationService.addNewUser(newUser);
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public void updateUser() {
        administrationService.updateUser(userModel.getUser());
    }

    public void deleteUser() {
        administrationService.deleteUser(userModel.getUser());
    }


    public UserDTO getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDTO selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void prepUser() {
        userModel.setUser(new UserDTO());
    }
}
