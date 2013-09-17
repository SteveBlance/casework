package com.codaconsultancy.casework.service.Administration;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.model.user.dao.UserDAO;
import com.codaconsultancy.casework.model.user.entity.User;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Stateless
public class AdministrationService implements Serializable {

    @Inject
    UserDAO userDAO;

    private final static Logger LOGGER = Logger.getLogger(AdministrationService.class);

    public UserDTO getUser(String username) {
        LOGGER.info("Finding user: " + username);
        User user = userDAO.findByUsername(username);
        return user.toDTO();
    }

    public List<UserDTO> getAllUsers() {
        LOGGER.info("Finding all users");
        List<User> users = userDAO.findAll();
        List<UserDTO> allUsers = new ArrayList<UserDTO>();
        for (User user : users) {
            allUsers.add(user.toDTO());
        }
        return allUsers;
    }

    public void addNewUser(UserDTO userDTO) {
        LOGGER.info("Adding user: " + userDTO.getUsername());
        userDAO.create(userDTO.toUser());
    }

}
