package com.example.testlabs.lab3;

import com.example.testlabs.service.lab3.User;

public class UserFixture {
    public static User createUser(){
        return User.builder()
                .id("id")
                .name("Joker")
                .email("joker@gmail.com")
                .build();
    }
}
