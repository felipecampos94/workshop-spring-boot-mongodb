package com.java.workshopmongodb.service;

import com.java.workshopmongodb.model.Post;
import com.java.workshopmongodb.repository.PostRepository;
import com.java.workshopmongodb.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object Not Found! ID: " + id + " Type:" + Post.class.getSimpleName()));
    }

    public Post insert(Post post) {
        return postRepository.save(post);
    }

    public void delete(String id) {
        this.findById(id);
        postRepository.deleteById(id);
    }

    public Post update(Post post) {
        Post currentPost = this.findById(post.getId());
        updateData(currentPost, post);
        return postRepository.save(currentPost);
    }

    private void updateData(Post currentPost, Post post) {
        currentPost.setDate(post.getDate());
        currentPost.setBody(post.getBody());
        currentPost.setTitle(post.getTitle());
        currentPost.setAuthor(post.getAuthor());
    }

}
