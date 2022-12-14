package com.example.testlabs.lab2;

import com.example.testlabs.service.lab2.SimpleUserService;
import com.example.testlabs.service.lab2.User;
import com.example.testlabs.service.lab2.UserAlreadyExistException;
import com.example.testlabs.service.lab2.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleUserServiceTest {
    SimpleUserService service;

    @BeforeEach
    void init() {
        service = new SimpleUserService(new SimpleUserRepositoryMock());
    }

    @Test
    void createNewUser_UniqueEmail_createsUser() {
        User user = UserFixture.createUser();
        User actualUser = service.createNewUser(user);
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    void createNewUser_NotUniqueEmail_ReturnsException() {
        User user = UserFixture.createUser();
        service.createNewUser(user);
        assertThrows(UserAlreadyExistException.class, () -> service.createNewUser(user));
    }

    @Test
    void findUserById_ValidId_ReturnsUser() {
        User user = UserFixture.createUser();
        service.createNewUser(user);
        User actualUser = service.findUserById(user.getId());
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    void findUserById_InvalidId_ReturnsException() {
        String id = "id";
        assertThrows(UserNotFoundException.class, () -> service.findUserById(id));
    }

    @Test
    void findUserByEmail_ValidId_ReturnsUser() {
        User user = UserFixture.createUser();
        service.createNewUser(user);
        User actualUser = service.findUserByemail(user.getEmail());
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    void findUserByEmail_InvalidId_ReturnsException() {
        String email = "email";
        assertThrows(UserNotFoundException.class, () -> service.findUserByemail(email));
    }
}
