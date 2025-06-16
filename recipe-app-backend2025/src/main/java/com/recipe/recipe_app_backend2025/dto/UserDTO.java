package com.recipe.recipe_app_backend2025.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipe.recipe_app_backend2025.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotBlank (message = "Username is requiered")
    private String username;

    @Email (message ="Email must be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Passwarod is required")
    private String password;


    private Role role;

}
