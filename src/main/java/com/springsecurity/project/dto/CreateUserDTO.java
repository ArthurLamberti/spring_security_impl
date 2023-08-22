package com.springsecurity.project.dto;

import com.springsecurity.project.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserDTO {
    private String name;
    private String username;
    private String password;
    private Set<Roles> roles;
}
