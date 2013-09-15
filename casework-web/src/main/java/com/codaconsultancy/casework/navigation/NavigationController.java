package com.codaconsultancy.casework.navigation;

import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController {

    private static final String NAVIGATING_TO = "Navigating to ";
    private static final String CREATE_USER = "createUser";
    private static final Logger LOGGER = Logger.getLogger(NavigationController.class);

    public String goToCreateUserPage() {
        LOGGER.info(NAVIGATING_TO + CREATE_USER);
        return CREATE_USER;
    }


}
