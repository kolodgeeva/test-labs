package com.example.testlabs.service.lab2;

import java.util.Optional;

public interface SimpleUserRepository {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(String id);

    User create(User user);

}
