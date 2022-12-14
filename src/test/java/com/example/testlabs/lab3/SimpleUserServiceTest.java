package com.example.testlabs.lab3;


import com.example.testlabs.service.lab3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleUserServiceTest {
    public static String INVALID_Id = "invalid";
    public static String INVALID_EMAIL = "email";

    SimpleUserService service;
    SimpleUserRepository repository;

    @BeforeEach
    void init() {
        repository = mock(SimpleUserRepository.class);
        service = new SimpleUserService(repository);
    }

    @Test
    void createNewUser_UniqueEmail_createsUser() {
        User user = UserFixture.createUser();
        when(service.createNewUser(user)).thenReturn(user);
        User actualUser = service.createNewUser(user);
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    void createNewUser_NotUniqueEmail_ReturnsException() {
        User user = UserFixture.createUser();
        when(repository.findUserByEmail(anyString())).thenReturn(Optional.of(user));
        assertThrows(UserAlreadyExistException.class,
                () -> service.createNewUser(user));

    }

    @Test
    void findUserById_ValidId_ReturnsUser() {
        User user = UserFixture.createUser();
        when(repository.findUserById(anyString())).thenReturn(Optional.of(user));
        User actualUser = service.findUserById(user.getId());
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    void findUserById_InvalidId_ReturnsException() {
        assertThrows(UserNotFoundException.class, () -> service.findUserById(INVALID_Id));
    }

    @Test
    void findUserByEmail_ValidId_ReturnsUser() {
        User user = UserFixture.createUser();
        when(repository.findUserByEmail(anyString())).thenReturn(Optional.of(user));
        User actualUser = service.findUserByEmail(user.getEmail());
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    void findUserByEmail_InvalidId_ReturnsException() {
        assertThrows(UserNotFoundException.class, () -> service.findUserById(INVALID_EMAIL));
    }
}
