package com.codaconsultancy.casework.service.Administration;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.model.user.dao.UserDAO;
import com.codaconsultancy.casework.model.user.entity.User;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
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
        User user = userDTO.toUser();
        //TODO: properly implement salting
        user.setSalt("salty_todo:");
        Date date = new Date();
        user.setDateCreated(date);
        user.setLastModified(date);
        String encryptedPassword = encrypt(userDTO.getPassword());
        user.setPassword(encryptedPassword);
        user.setActive(true);
        userDAO.create(user);
    }

    private String encrypt(String password) {
        String encryptedPassword = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            digest.reset();
            digest.update(password.getBytes());
            encryptedPassword = convertToHex(digest.digest());

        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmException SHA1");
        }
        return encryptedPassword;
    }

    private String convertToHex(byte[] data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i % 4 == 0 && i != 0) {
                builder.append("");
            }
            int x = (int) data[i];
            if (x < 0) {
                x += 256;
            }
            if (x < 16) {
                builder.append("0");
            }
            builder.append(Integer.toString(x, 16));
        }
        return builder.toString();
    }

}
