package com.example.testlabs.service.lab4;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimpleUserService {
    public final SimpleUserRepository repository;

    public SimpleUserService(SimpleUserRepository repository) {
        this.repository = repository;
    }

    public User createNewUser(User user) {
        final Optional<User> userByEmail = repository.findUserByEmail(user.getEmail());

        if (userByEmail.isPresent()) {
            throw new UserAlreadyExistException();
        }

        return repository.create(user);
    }

    public User findUserById(String id) {
        return repository.findUserById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User findUserByemail(String email) {
        return repository.findUserByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }
}
