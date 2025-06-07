package com.recipe.recipe_app_backend2025.model;

import com.recipe.recipe_app_backend2025.enums.CategoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Category type is required")
    private CategoryType type;

    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    public Category() {
    }

    public Category(CategoryType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}


