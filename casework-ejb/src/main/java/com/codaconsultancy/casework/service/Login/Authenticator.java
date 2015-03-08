package com.codaconsultancy.casework.service.login;

import com.codaconsultancy.casework.model.user.dao.UserDAO;
import com.codaconsultancy.casework.model.user.entity.User;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Named
@RequestScoped
public class Authenticator implements Serializable {

    private static final long serialVersionUID = 1L;
    private final static org.apache.log4j.Logger LOGGER = Logger.getLogger(Authenticator.class);


    @Inject
    private UserDAO userDAO;

    @Inject
    private Identity identity;

    private String username;
    private String password;

    public boolean login() {

        User user = userDAO.findByUsername(username);

        if (user != null && user.verifyPassword(password)) {
            identity.setLoggedIn(true);
            identity.setUser(user);
            return true;
        }

        return false;
    }

    public boolean logout() {
        LOGGER.info("logout current user");
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return true;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
