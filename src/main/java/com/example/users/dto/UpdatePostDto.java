package com.example.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Data Transfer Object for updating an existing post")
public record UpdatePostDto(
        @NotBlank(message = "Title cannot be empty")
        @Schema(description = "Updated title of the post", example = "Updated Post Title", requiredMode = Schema.RequiredMode.REQUIRED)
        String title,

        @NotBlank(message = "Content cannot be empty")
        @Schema(description = "Updated content of the post", example = "This is the updated content of the post.", requiredMode = Schema.RequiredMode.REQUIRED)
        String content
) {
}
