package com.rest.socialmediawebservices.service;

import com.rest.socialmediawebservices.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Gergana", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Ivan", LocalDate.now().minusYears(23)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElseThrow(() -> new UserNotFoundException("id:" + id));
    }

    public User saveUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
