package com.example.users.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Post entity representing a post made by a user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the post", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer id;

    @Schema(description = "Title of the post", example = "My First Post", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "Content of the post", example = "This is the content of my first post.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    @Schema(description = "User who created the post", requiredMode = Schema.RequiredMode.REQUIRED)
    private User user;

}
