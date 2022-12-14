package com.example.testlabs.lab2;

import com.example.testlabs.service.lab2.User;

public class UserFixture {
   public static User createUser(){
       return User.builder()
               .id("id")
               .name("Joker")
               .email("joker@gmail.com")
               .build();
   }
}
