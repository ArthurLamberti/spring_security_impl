package com.springsecurity.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ManagerController {

    @GetMapping("/manager")
    public String example(){
        return "Only manager can view this route!";
    }

}
