package com.springsecurity.project.controllers;

import com.springsecurity.project.model.User;
import com.springsecurity.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private UsersRepository usersRepository;

    UsersController(
            final UsersRepository usersRepository
    ) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/public")
    private List<User> getUsers() {
        List<User> users = usersRepository.findAll();
        return users;
    }

    @RequestMapping("/auth")
    public User getUserDetailsAfterLogin(Authentication authentication) {
        return usersRepository
                .findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
