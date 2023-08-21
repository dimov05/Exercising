package com.rest.socialmediawebservices.repository;

import com.rest.socialmediawebservices.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
