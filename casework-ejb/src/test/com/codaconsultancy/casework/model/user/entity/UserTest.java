package com.codaconsultancy.casework.model.user.entity;

import junit.framework.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testGetUsername() {
        User user = new User();
        user.setUsername("BobM");
        Assert.assertEquals("BobM", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        User user = new User();
        user.setPassword("jhgsohg");
        Assert.assertEquals("jhgsohg", user.getPassword());

    }

    @Test
    public void testGetFirstName() {
        User user = new User();
        user.setFirstName("Bill");
        Assert.assertEquals("Bill", user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        User user = new User();
        user.setLastName("Smith");
        Assert.assertEquals("Smith", user.getLastName());
    }

    @Test
    public void testGetEmailAddress() {
        User user = new User();
        user.setEmailAddress("bill@mail.com");
        Assert.assertEquals("bill@mail.com", user.getEmailAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        User user = new User();
        user.setPhoneNumber("0121 888 999");
        Assert.assertEquals("0121 888 999", user.getPhoneNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantCreateAlphaPhoneNumber() {
        User user = new User();
        user.setPhoneNumber("BBB xx 999");
    }

    @Test
    public void testValidPhoneNumbers() {
        User user = new User();
        user.setPhoneNumber("0121 888 999");
        Assert.assertEquals("0121 888 999", user.getPhoneNumber());
        user.setPhoneNumber("0121-888-999");
        Assert.assertEquals("0121-888-999", user.getPhoneNumber());
        user.setPhoneNumber("(+44) 121 888-999");
        Assert.assertEquals("(+44) 121 888-999", user.getPhoneNumber());
        user.setPhoneNumber("0121.888.999");
        Assert.assertEquals("0121.888.999", user.getPhoneNumber());
    }

    @Test
    public void testIsActive() {
        User user = new User();
        Assert.assertFalse(user.isActive());
        user.setActive(true);
        Assert.assertTrue(user.isActive());
    }

}
