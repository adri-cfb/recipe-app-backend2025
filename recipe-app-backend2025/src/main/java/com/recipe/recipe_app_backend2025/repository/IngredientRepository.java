package com.recipe.recipe_app_backend2025.repository;

import com.recipe.recipe_app_backend2025.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
