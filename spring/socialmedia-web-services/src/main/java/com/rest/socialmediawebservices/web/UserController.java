package com.rest.socialmediawebservices.web;

import com.rest.socialmediawebservices.service.UserDaoService;
import com.rest.socialmediawebservices.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userDaoService.findById(id);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") int id) {
        userDaoService.deleteById(id);

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User user) {
        user = userDaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
