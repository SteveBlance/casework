package com.codaconsultancy.casework.service.Administration;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.model.common.BaseUnitTest;
import com.codaconsultancy.casework.model.user.dao.UserDAO;
import com.codaconsultancy.casework.model.user.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
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
        User user = newUser("gregh", "Greg", "Harris", "unencrypted-pwd");
        service.addNewUser(user.toDTO());
        ArgumentCaptor<User> userArg = ArgumentCaptor.forClass(User.class);
        verify(userDAO, times(1)).create(userArg.capture());
        User createdUser = userArg.getValue();
        Assert.assertEquals(user.getUsername(), createdUser.getUsername());
        Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
        Assert.assertEquals(user.getLastName(), createdUser.getLastName());
        Assert.assertEquals("salty_todo:", createdUser.getSalt());
        Assert.assertNotNull(createdUser.getDateCreated());
        Assert.assertTrue(createdUser.getDateCreated() instanceof Date);
        Assert.assertNotNull(createdUser.getLastModified());
        Assert.assertTrue(createdUser.getLastModified() instanceof Date);
        Assert.assertThat("unencrypted-pwd", not(equalTo(createdUser.getPassword())));
        Assert.assertTrue(createdUser.isActive());
    }

    private User newUser(String username, String firstName, String lastName, String password) {
        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber("0139 990 0011");
        user.setActive(true);
        user.setPassword(password);
        user.setEmailAddress("info@nothing.com");
        return user;
    }

}
