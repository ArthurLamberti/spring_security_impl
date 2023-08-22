package com.springsecurity.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BothController {

    @GetMapping("/both")
    public String example(){
        return "Manager and Admin can view this route!";
    }
}
