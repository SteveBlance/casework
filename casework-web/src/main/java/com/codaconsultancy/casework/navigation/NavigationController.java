package com.codaconsultancy.casework.navigation;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController {

    private static final String NAVIGATING_TO = "Navigating to ";
    private static final String CREATE_USER = "createUser";
    private static final Logger LOGGER = Logger.getLogger(NavigationController.class);
    private static final String ADD_USER_POPUP = "addUserPopUp";
    private static final Object SHOWING = "Showing ";
    private static final Object HIDING = "Hiding ";

    public String goToCreateUserPage() {
        LOGGER.info(NAVIGATING_TO + CREATE_USER);
        return CREATE_USER;
    }

    public void showAddUserPopUp() {
        LOGGER.info(SHOWING + ADD_USER_POPUP);
        RequestContext.getCurrentInstance().execute(ADD_USER_POPUP + ".show()");
    }

    public void hideAddUserPopUp() {
        LOGGER.info(HIDING + ADD_USER_POPUP);
        RequestContext.getCurrentInstance().execute(ADD_USER_POPUP + ".hide()");
    }

}
