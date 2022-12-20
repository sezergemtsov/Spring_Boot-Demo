package ru.netology.springbootrestdemo.configs;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.springbootrestdemo.dto.UserDto;
import ru.netology.springbootrestdemo.exceptions.InvalidCredentials;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public UserHandlerMethodArgumentResolver() {}

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameter().getType().equals(UserDto.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String name = webRequest.getParameter("user");
        if (name == null || name.isEmpty()) {
            throw new InvalidCredentials("User name or password is empty");
        }
        String password = webRequest.getParameter("password");
        if (password == null || password.isEmpty()) {
            throw new InvalidCredentials("User name or password is empty");
        }
        return new UserDto(name,password);
    }
}
