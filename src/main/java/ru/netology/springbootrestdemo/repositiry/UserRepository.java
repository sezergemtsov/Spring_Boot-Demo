package ru.netology.springbootrestdemo.repositiry;

import org.springframework.stereotype.Repository;
import ru.netology.springbootrestdemo.model.Authorities;
import ru.netology.springbootrestdemo.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
@Repository
public class UserRepository {
    ConcurrentHashMap<String, User> users;

    public UserRepository() {
        users = new ConcurrentHashMap<>();
    }

    public List<Authorities> getUserAuthorities(String name) {
        if (users.containsKey(name)) {
            return users.get(name).getAuthorities();
        }
        return null;
    }

    public User getUser(String name) {
        if (users.containsKey(name)) {
            return users.get(name);
        }
        return null;
    }
}
