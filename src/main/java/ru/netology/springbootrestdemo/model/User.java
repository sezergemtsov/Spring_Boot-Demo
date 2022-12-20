package ru.netology.springbootrestdemo.model;


import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class User {
    private String name;
    private String password;

    List<Authorities> authorities;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        authorities = new ArrayList<>();
        authorities.add(Authorities.READ);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }
}
