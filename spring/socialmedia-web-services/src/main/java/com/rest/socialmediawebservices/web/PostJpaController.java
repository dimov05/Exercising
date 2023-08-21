package com.rest.socialmediawebservices.web;

import com.rest.socialmediawebservices.model.Post;
import com.rest.socialmediawebservices.model.User;
import com.rest.socialmediawebservices.service.PostService;
import com.rest.socialmediawebservices.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostJpaController {
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostJpaController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/jpa/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/jpa/posts/{id}")
    public Post getPostById(@PathVariable("id") int id) throws ChangeSetPersister.NotFoundException {
        return postService.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePostById(@PathVariable("id") int id) {
        postService.deleteById(id);
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
        User user = userService.findById(id);
        post.setAuthor(user);
        Post savedPost = postService.savePost(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
