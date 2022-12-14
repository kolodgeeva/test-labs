package com.example.testlabs.lab4;

import com.example.testlabs.service.lab4.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.testlabs.lab4.UserFixture.createUser;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class SimpleUserServiceTest {

    public static String INVALID_Id = "invalid";

    public static String INVALID_EMAIL = "email";

    @Mock
    SimpleUserRepository repository;

    @InjectMocks
    SimpleUserService service;

    @Test
    void createNewUser_UniqueEmail_createsUser(){
        User user = createUser();
        when(service.createNewUser(user)).thenReturn(user);
        User actualUser = service.createNewUser(user);
        assertThat(user.getId()).isEqualTo((actualUser.getId()));
        assertThat(user.getName()).isEqualTo((actualUser.getName()));
        assertThat(user.getEmail()).isEqualTo((actualUser.getEmail()));
    }

    @Test
    void createNewUser_NotUniqueEmail_ReturnsException(){
        User user = createUser();
        service.createNewUser(user);
        when(repository.findUserByEmail(anyString())).thenReturn(Optional.of(user));
       assertThrows(UserAlreadyExistException.class, () -> service.createNewUser(user));
    }

    @Test
    void findUserById_ValidId_ReturnsUser(){
        User user = createUser();
        when(repository.findUserById(anyString())).thenReturn(Optional.of(user));
        User actualUser = service.findUserById(user.getId());
        assertThat(actualUser.getId()).isEqualTo(user.getId());
    }

    @Test
    void findUserById_InvalidId_ReturnsException(){
        when(repository.findUserById(anyString())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> service.findUserById(INVALID_Id));
    }

    @Test
    void findUserByEmail_ValidId_ReturnsUser(){
        User user = createUser();
        when(repository.findUserByEmail(anyString())).thenReturn(Optional.of(user));
        User actualUser = service.findUserByemail(user.getEmail());
        assertThat(actualUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    void findUserByEmail_InvalidId_ReturnsException(){
        when(repository.findUserByEmail(anyString())).thenReturn(Optional.empty());
       assertThrows(UserNotFoundException.class, () -> service.findUserByemail(INVALID_EMAIL));
    }
}
