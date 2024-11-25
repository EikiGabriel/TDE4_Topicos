package com.example.users.api;

import com.example.users.dto.CreatePostDto;
import com.example.users.dto.UpdatePostDto;
import com.example.users.model.Post;
import com.example.users.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/posts")
public class PostController {

    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "Create a new post for a user")
    @PostMapping
    public ResponseEntity<Post> createPost(
            @Parameter(description = "ID of the user", required = true)
            @PathVariable Integer userId,
            @Valid @RequestBody CreatePostDto createPostDto) {
        Post createdPost = postService.createPost(userId, createPostDto);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all posts for a user")
    @GetMapping
    public ResponseEntity<List<Post>> getPosts(
            @Parameter(description = "ID of the user", required = true)
            @PathVariable Integer userId) {
        List<Post> posts = postService.getPostsByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "Get a specific post for a user")
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(
            @Parameter(description = "ID of the user", required = true)
            @PathVariable Integer userId,
            @Parameter(description = "ID of the post", required = true)
            @PathVariable Integer postId) {
        Post post = postService.getPostById(userId, postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @Operation(summary = "Update a post for a user")
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(
            @Parameter(description = "ID of the user", required = true)
            @PathVariable Integer userId,
            @Parameter(description = "ID of the post", required = true)
            @PathVariable Integer postId,
            @Valid @RequestBody UpdatePostDto updatePostDto) {
        Post updatedPost = postService.updatePost(userId, postId, updatePostDto);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @Operation(summary = "Delete a post for a user")
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(
            @Parameter(description = "ID of the user", required = true)
            @PathVariable Integer userId,
            @Parameter(description = "ID of the post", required = true)
            @PathVariable Integer postId) {
        postService.deletePost(userId, postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
