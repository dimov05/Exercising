package com.rest.socialmediawebservices.web;

import com.rest.socialmediawebservices.model.User;
import com.rest.socialmediawebservices.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class UserJpaController {
    private final UserService userService;

    @Autowired
    public UserJpaController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userService.deleteById(id);

    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        user = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
