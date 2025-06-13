package com.recipe.recipe_app_backend2025.model;

import com.recipe.recipe_app_backend2025.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude ={"recipes"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Username is mandatory")
    private String username;

    @Email (message= "Email should be valid")
    @NotBlank(message="Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @Enumerated (EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recipe> recipes;

}
