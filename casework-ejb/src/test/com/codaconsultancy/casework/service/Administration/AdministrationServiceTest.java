package com.codaconsultancy.casework.service.Administration;

import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.model.common.BaseUnitTest;
import com.codaconsultancy.casework.model.user.dao.UserDAO;
import com.codaconsultancy.casework.model.user.entity.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class AdministrationServiceTest extends BaseUnitTest {

    @InjectMocks
    AdministrationService service;

    @Mock
    UserDAO userDAO;

    @Before
    public void setup() {
        User user = new User();
        user.setUsername("stevebl");
        user.setPhoneNumber("01383711999");
        when(userDAO.findByUsername("stevebl")).thenReturn(user);
    }

    @Test
    public void testGetUser() {
        UserDTO user = service.getUser("stevebl");
        Assert.assertEquals("stevebl", user.getUsername());
        Assert.assertEquals("01383711999", user.getPhoneNumber());
    }

}
