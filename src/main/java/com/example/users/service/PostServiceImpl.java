package com.example.users.service;

import com.example.users.dto.CreatePostDto;
import com.example.users.dto.UpdatePostDto;
import com.example.users.exception.PostNotFoundException;
import com.example.users.exception.UserNotFoundException;
import com.example.users.model.Post;
import com.example.users.model.User;
import com.example.users.repository.PostRepository;
import com.example.users.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Integer userId, CreatePostDto createPostDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Post post = new Post();
        post.setTitle(createPostDto.title());
        post.setContent(createPostDto.content());
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        return postRepository.findByUserId(userId);
    }

    @Override
    public Post getPostById(Integer userId, Integer postId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        return postRepository.findById(postId)
                .filter(post -> post.getUser().getId().equals(userId))
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    @Override
    public Post updatePost(Integer userId, Integer postId, UpdatePostDto updatePostDto) {
        Post post = getPostById(userId, postId);
        post.setTitle(updatePostDto.title());
        post.setContent(updatePostDto.content());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer userId, Integer postId) {
        Post post = getPostById(userId, postId);
        postRepository.delete(post);
    }
}
