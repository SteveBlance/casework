package com.codaconsultancy.casework.useradmin;

import com.codaconsultancy.casework.common.BaseUnitTest;
import com.codaconsultancy.casework.dto.user.UserDTO;
import com.codaconsultancy.casework.service.administration.AdministrationService;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserControllerTest extends BaseUnitTest {

    @InjectMocks
    UserController userController;

    @Mock
    AdministrationService administrationService;

    @Mock
    UserModel userModel;

    @Test
    public void testGetAllUsers() {
        List<UserDTO> users = new ArrayList<UserDTO>();
        users.add(newUserDTO("bob"));
        users.add(newUserDTO("jane"));
        users.add(newUserDTO("fred"));
        when(administrationService.getAllActiveUsers()).thenReturn(users);
        when(userModel.getAllUsers()).thenReturn(users);

        List<UserDTO> retrievedUsers = userController.getAllUsers();
        verify(administrationService, times(1)).getAllActiveUsers();
        verify(userModel, times(1)).setAllUsers(users);
        verify(userModel, times(1)).getAllUsers();
        Assert.assertEquals(3, retrievedUsers.size());
    }

    @Test
    public void testAddNewUser() {
        UserDTO userDTO = newUserDTO("jim");
        when(userModel.getUser()).thenReturn(userDTO);
        userController.addNewUser();
        verify(userModel, times(1)).getUser();
        verify(administrationService, times(1)).addNewUser(userDTO);
    }

    @Test
    public void testUpdateUser() {
        UserDTO userDTO = newUserDTO("bob");
        when(userModel.getUser()).thenReturn(userDTO);
        userController.updateUser();
        verify(userModel, times(1)).getUser();
        verify(administrationService, times(1)).updateUser(userDTO);
    }

    private UserDTO newUserDTO(String username) {
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setUsername(username);
        return userDTO1;
    }
}
