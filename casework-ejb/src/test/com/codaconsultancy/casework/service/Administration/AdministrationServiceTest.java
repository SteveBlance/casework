package com.codaconsultancy.casework.service.Administration;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.model.common.BaseUnitTest;
import com.codaconsultancy.casework.model.user.dao.UserDAO;
import com.codaconsultancy.casework.model.user.entity.User;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class AdministrationServiceTest extends BaseUnitTest {

    @InjectMocks
    AdministrationService service;

    @Mock
    UserDAO userDAO;


    @Test
    public void testGetUser() {
        User user = new User();
        user.setUsername("stevebl");
        user.setPhoneNumber("01383711999");
        when(userDAO.findByUsername("stevebl")).thenReturn(user);
        UserDTO userDTO = service.getUser("stevebl");
        Assert.assertEquals("stevebl", userDTO.getUsername());
        Assert.assertEquals("01383711999", userDTO.getPhoneNumber());
    }

    @Test
    public void testAddNewUser() {
        User user = newUser("gregh", "Greg", "Harris");
        service.addNewUser(user.toDTO());
        ArgumentCaptor<User> userArg = ArgumentCaptor.forClass(User.class);
        verify(userDAO, times(1)).create(userArg.capture());
        User createdUser = userArg.getValue();
        Assert.assertEquals(user.getUsername(), createdUser.getUsername());
        Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
        Assert.assertEquals(user.getLastName(), createdUser.getLastName());

    }

    private User newUser(String username, String firstName, String lastName) {
        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber("0139 990 0011");
        user.setActive(true);
        user.setPassword("unencrypted-pwd");
        user.setEmailAddress("info@nothing.com");
        return user;
    }

}
