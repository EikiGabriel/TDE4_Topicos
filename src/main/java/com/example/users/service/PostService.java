package com.example.users.service;

import com.example.users.dto.CreatePostDto;
import com.example.users.dto.UpdatePostDto;
import com.example.users.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Integer userId, CreatePostDto createPostDto);
    List<Post> getPostsByUserId(Integer userId);
    Post getPostById(Integer userId, Integer postId);
    Post updatePost(Integer userId, Integer postId, UpdatePostDto updatePostDto);
    void deletePost(Integer userId, Integer postId);
}
