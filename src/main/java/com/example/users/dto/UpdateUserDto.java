package com.example.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Data Transfer Object for updating an existing user")
public record UpdateUserDto(
        @NotBlank(message = "Name must have at least 1 character")
        @Schema(description = "Updated name of the user", example = "João Bione", requiredMode = Schema.RequiredMode.REQUIRED)
        String name,

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Email must be valid")
        @Schema(description = "Updated email address of the user", example = "joao.bione@dev.com", requiredMode = Schema.RequiredMode.REQUIRED)
        String email,

        @NotNull(message = "Age cannot be null")
        @Min(value = 1, message = "Age must be greater than 0")
        @Schema(description = "Updated age of the user", example = "28", requiredMode = Schema.RequiredMode.REQUIRED)
        Integer age
) {
}
