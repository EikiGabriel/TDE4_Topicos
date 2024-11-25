package com.example.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Data Transfer Object for creating a new post")
public record CreatePostDto(
        @NotBlank(message = "Title cannot be empty")
        @Schema(description = "Title of the post", example = "My First Post", requiredMode = Schema.RequiredMode.REQUIRED)
        String title,

        @NotBlank(message = "Content cannot be empty")
        @Schema(description = "Content of the post", example = "This is the content of my first post.", requiredMode = Schema.RequiredMode.REQUIRED)
        String content
) {
}
