package com.example.testlabs.lab2;

import com.example.testlabs.service.lab2.SimpleUserRepository;
import com.example.testlabs.service.lab2.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleUserRepositoryMock implements SimpleUserRepository {
    List<User> users = new ArrayList<>();
    @Override
    public Optional<User> findUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findAny();
    }

    @Override
    public Optional<User> findUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findAny();
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }
}
