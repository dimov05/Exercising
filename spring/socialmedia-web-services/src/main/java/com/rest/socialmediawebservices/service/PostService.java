package com.rest.socialmediawebservices.service;

import com.rest.socialmediawebservices.model.Post;
import com.rest.socialmediawebservices.model.User;
import com.rest.socialmediawebservices.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post savePost(Post post) {
        postRepository.save(post);
        return post;
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    public Post findById(int id) throws ChangeSetPersister.NotFoundException {
        return postRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
