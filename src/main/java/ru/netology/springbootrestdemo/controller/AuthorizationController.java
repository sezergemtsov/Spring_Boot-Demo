package ru.netology.springbootrestdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootrestdemo.dto.UserDto;
import ru.netology.springbootrestdemo.model.Authorities;
import ru.netology.springbootrestdemo.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(final UserDto user) {
        return service.getAuthorities(user);
    }
}
