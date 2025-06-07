package com.recipe.recipe_app_backend2025.repository;

import com.recipe.recipe_app_backend2025.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
