package com.yws.controller;

import com.yws.entity.User;
import com.yws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        //User user = userRepository.getOne(id);
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }
}
