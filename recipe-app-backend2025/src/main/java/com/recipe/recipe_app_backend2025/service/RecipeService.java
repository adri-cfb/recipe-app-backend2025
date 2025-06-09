package com.recipe.recipe_app_backend2025.service;

import com.recipe.recipe_app_backend2025.enums.FoodType;
import com.recipe.recipe_app_backend2025.model.Recipe;
import com.recipe.recipe_app_backend2025.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    //TODO to review
    public List<Recipe> getRecipesByUserId(Long userId) {
        return recipeRepository.findAll()
                .stream()
                .filter(recipe -> recipe.getUser() !=null && recipe.getUser().getId().equals(userId))
                .toList();
    }

    //TODO review
    public List<Recipe> getRecipesByCategory(Category category) {
        return recipeRepository.findAll()
                .stream()
                .filter(recipe -> recipe.getCategory() != null && recipe.getCategory().equals(category))
                .toList();
    }

    public List<Recipe> getRecipesByFoodType(FoodType foodtype) {
        return recipeRepository.findAll()
                .stream()
                .filter(recipe -> recipe.getFoodType() != null && recipe.getFoodType().equals(foodtype))
                .toList();
    }

    public Optional<Recipe> getById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe updateRecipe(Long id, Recipe recipe) {
        return recipeRepository.findById(id)
            .map (existingRecipe -> {
                existingRecipe.setTitle(recipe.getTitle());
                existingRecipe.setCalories(recipe.getCalories());
                existingRecipe.setServings(recipe.getServings());
                existingRecipe.setFoodType(recipe.getFoodType());
                existingRecipe.setCategory(recipe.getCategory());
                existingRecipe.setIngredients(recipe.getIngredients());
                return recipeRepository.save(recipe);
            })
                .orElseThrow(()-> new RuntimeException("Recipe not found with id: " + id));
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

}
