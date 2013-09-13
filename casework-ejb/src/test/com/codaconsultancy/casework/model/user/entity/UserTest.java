package com.codaconsultancy.casework.model.user.entity;

import com.codaconsultancy.casework.dto.user.UserDTO;
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

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidEmailAddress() {
        User user = new User();
        user.setEmailAddress("NotAnEmailAddress");
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

    @Test
    public void testUserToDTO() {
        User user = new User();
        user.setId(99L);
        user.setUsername("jimmychow");
        user.setEmailAddress("jim@maily.co.uk");
        user.setFirstName("Jimmy");
        user.setLastName("Chow");
        user.setActive(true);
        user.setPhoneNumber("01383711999");
        user.setPassword("s9wtkdhafiu7vbliuwvhlbe");
        UserDTO userDTO = user.toDTO();
        Assert.assertTrue(userDTO.isActive());
        Assert.assertEquals(user.getId(), userDTO.getId());
        Assert.assertEquals(user.getUsername(), userDTO.getUsername());
        Assert.assertEquals(user.getEmailAddress(), userDTO.getEmailAddress());
        Assert.assertEquals(user.getFirstName(), userDTO.getFirstName());
        Assert.assertEquals(user.getLastName(), userDTO.getLastName());
        Assert.assertEquals(user.getPassword(), userDTO.getPassword());
        Assert.assertEquals(user.getPhoneNumber(), userDTO.getPhoneNumber());
    }

}
