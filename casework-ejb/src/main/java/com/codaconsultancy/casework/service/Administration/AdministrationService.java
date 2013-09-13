package com.codaconsultancy.casework.service.Administration;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.model.user.dao.UserDAO;
import com.codaconsultancy.casework.model.user.entity.User;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

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
}
