package com.springsecurity.project.controllers;

import com.springsecurity.project.dto.CreateUserDTO;
import com.springsecurity.project.model.Roles;
import com.springsecurity.project.model.User;
import com.springsecurity.project.repository.RolesRepository;
import com.springsecurity.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsersController {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;

    UsersController(
            final UsersRepository usersRepository,
            final PasswordEncoder passwordEncoder,
            final RolesRepository rolesRepository
    ) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
    }

    @GetMapping("/users")
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

    @PostMapping("/users")
    private void create(@RequestBody CreateUserDTO createUserDTO) {
        User user = User.builder()
                .id((int) usersRepository.count() + 1)
                .name(createUserDTO.getName())
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .build();

        User userSaved = usersRepository.save(user);
        List<Roles> roles = createUserDTO
                .getRoles()
                .stream()
                .map(role -> Roles.builder()
                        .user(userSaved)
                        .id(rolesRepository.count() + 1)
                        .name(role.getName())
                        .build()
                )
                .toList();
        rolesRepository.saveAll(roles);
    }
}
