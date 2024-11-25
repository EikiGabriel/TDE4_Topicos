package com.example.users.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User entity representing a registered user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the user", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer id;

    @Schema(description = "Age of the user", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer age;

    @Schema(description = "Name of the user", example = "João Bione", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Email address of the user", example = "joao.bione@dev.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Schema(description = "List of posts created by the user")
    private List<Post> posts;
}
