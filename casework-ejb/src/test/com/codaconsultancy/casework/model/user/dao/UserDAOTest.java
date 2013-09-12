package com.codaconsultancy.casework.model.user.dao;

import com.codaconsultancy.casework.model.common.BaseUnitTest;
import com.codaconsultancy.casework.model.user.entity.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.mockito.Mockito.*;

public class UserDAOTest extends BaseUnitTest {

    @InjectMocks
    private UserDAO userDAO;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query findByUsernameQuery;
    private User testUser;

    @Before
    public void setup() {
        testUser = new User();
        testUser.setUsername("jimmyb");
        testUser.setEmailAddress("jim@mail.com");
        testUser.setFirstName("Jimmy");
        testUser.setLastName("Brown");
        when(entityManager.createQuery(UserDAO.FIND_USER_BY_USERNAME)).thenReturn(findByUsernameQuery);
        when(findByUsernameQuery.getSingleResult()).thenReturn(testUser);
    }

    @Test
    public void testFindByUsername() {
        User foundUser = userDAO.findByUsername(testUser.getUsername());
        verify(findByUsernameQuery, times(1)).setParameter(":username", testUser.getUsername());
        Assert.assertEquals(testUser.getEmailAddress(), foundUser.getEmailAddress());
        Assert.assertEquals(testUser.getFirstName(), foundUser.getFirstName());
        Assert.assertEquals(testUser.getLastName(), foundUser.getLastName());
    }
}
