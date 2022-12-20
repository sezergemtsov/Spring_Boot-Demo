package ru.netology.springbootrestdemo.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootrestdemo.dto.UserDto;
import ru.netology.springbootrestdemo.exceptions.UnauthorizedUser;
import ru.netology.springbootrestdemo.model.Authorities;
import ru.netology.springbootrestdemo.repositiry.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(UserDto user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getName());
        if (userAuthorities==null||userAuthorities.isEmpty()) {
            throw new UnauthorizedUser("Unknown user ");
        }
        return userAuthorities;
    }
}
