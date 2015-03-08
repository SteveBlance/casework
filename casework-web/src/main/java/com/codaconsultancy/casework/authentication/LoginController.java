package com.codaconsultancy.casework.authentication;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {

    public boolean isUserLoggedIn() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return (username != null);
    }
}
