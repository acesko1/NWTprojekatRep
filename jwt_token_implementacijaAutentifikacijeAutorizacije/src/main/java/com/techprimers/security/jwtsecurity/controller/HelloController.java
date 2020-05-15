package com.techprimers.security.jwtsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/resursi")
public class HelloController {

    @GetMapping
    public String resursi() {
        return "Moji resursi";
    }
}
