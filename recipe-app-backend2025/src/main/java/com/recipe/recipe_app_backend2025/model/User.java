package com.recipe.recipe_app_backend2025.model;
import com.recipe.recipe_app_backend2025.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
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

    //TODO: Check
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    //TODO: confirmar con Lisa Lombok y borrar Getters Setters contructores, etc

    public User () {}

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public Long getId() {return id;}

    public String getUsername () {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public List<Recipe> getRecipes() {return recipes;}
    public void setRecipes(List<Recipe> recipes) {this.recipes = recipes;}
}
