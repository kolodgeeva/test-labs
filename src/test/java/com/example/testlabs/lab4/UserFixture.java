package com.example.testlabs.lab4;

import com.example.testlabs.service.lab4.User;

public class UserFixture {
   public static User createUser(){
       return User.builder()
               .id("id")
               .name("Joker")
               .email("joker@gmail.com")
               .build();
   }
}
