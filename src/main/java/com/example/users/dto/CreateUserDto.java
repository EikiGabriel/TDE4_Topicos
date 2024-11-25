package com.example.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Data Transfer Object for creating a new user")
public record CreateUserDto(
        @NotBlank(message = "Name must have at least 1 character")
        @Schema(description = "Name of the user", example = "João Bione", requiredMode = Schema.RequiredMode.REQUIRED)
        String name,

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Email must be valid")
        @Schema(description = "Email address of the user", example = "joao.bione@dev.com", requiredMode = Schema.RequiredMode.REQUIRED)
        String email,

        @NotNull(message = "Age cannot be null")
        @Min(value = 1, message = "Age must be greater than 0")
        @Schema(description = "Age of the user", example = "30", requiredMode = Schema.RequiredMode.REQUIRED)
        Integer age
) {
}
