package com.recipe.recipe_app_backend2025.service;

import com.recipe.recipe_app_backend2025.enums.CategoryType;
import com.recipe.recipe_app_backend2025.enums.FoodType;
import com.recipe.recipe_app_backend2025.exception.RecipeNotFoundException;
import com.recipe.recipe_app_backend2025.model.Recipe;
import com.recipe.recipe_app_backend2025.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;



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

    public List<Recipe> getRecipesByUserId(Long userId) {
        return recipeRepository.findAll()
                .stream()
                .filter(recipe -> recipe.getUser() !=null && recipe.getUser().getId().equals(userId))
                .toList();
    }

    public List<Recipe> getRecipesByCategory(CategoryType categoryType) {
        return recipeRepository.findAll()
                .stream()
                .filter(recipe -> recipe.getCategoryType() != null && recipe.getCategoryType().equals(categoryType))
                .toList();
    }

    public List<Recipe> getRecipesByFoodType(FoodType foodtype) {
        return recipeRepository.findAll()
                .stream()
                .filter(recipe -> recipe.getFoodType() != null && recipe.getFoodType().equals(foodtype))
                .toList();
    }

    public Recipe getById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("The recipe with ID " + id + " does not exist"));
    }

    public Optional<Recipe> updateRecipe(Long id, Recipe updatedRecipe) {
        return recipeRepository.findById(id).map (existingRecipe -> {
            existingRecipe.setTitle(updatedRecipe.getTitle());
            existingRecipe.setCalories(updatedRecipe.getCalories());
            existingRecipe.setServings(updatedRecipe.getServings());
            existingRecipe.setFoodType(updatedRecipe.getFoodType());
            existingRecipe.setCategoryType(updatedRecipe.getCategoryType());
            existingRecipe.setIngredients(updatedRecipe.getIngredients());
            return recipeRepository.save(existingRecipe);
        });
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

//    public void deleteAllRecipes() {recipeRepository.deleteAll();}
}
