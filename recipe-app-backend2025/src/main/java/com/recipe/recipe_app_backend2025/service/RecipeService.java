package com.recipe.recipe_app_backend2025.service;

import com.recipe.recipe_app_backend2025.dto.IngredientDTO;
import com.recipe.recipe_app_backend2025.dto.RecipeDTO;
import com.recipe.recipe_app_backend2025.enums.CategoryType;
import com.recipe.recipe_app_backend2025.enums.FoodType;
import com.recipe.recipe_app_backend2025.exception.RecipeNotFoundException;
import com.recipe.recipe_app_backend2025.model.Ingredient;
import com.recipe.recipe_app_backend2025.model.Recipe;
import com.recipe.recipe_app_backend2025.model.User;
import com.recipe.recipe_app_backend2025.repository.RecipeRepository;
import com.recipe.recipe_app_backend2025.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    public Recipe getById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("The recipe with ID " + id + " does not exist"));
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> updateRecipe(Long id, Recipe updatedRecipe) {
        return recipeRepository.findById(id).map(existing -> {
            existing.setTitle(updatedRecipe.getTitle());
            existing.setCalories(updatedRecipe.getCalories());
            existing.setServings(updatedRecipe.getServings());
            existing.setFoodType(updatedRecipe.getFoodType());
            existing.setCategoryType(updatedRecipe.getCategoryType());
            existing.setIngredients(updatedRecipe.getIngredients());
            return recipeRepository.save(existing);
        });
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> getRecipesByUserId(Long userId) {
        return recipeRepository.findAll().stream()
                .filter(r -> r.getUser() != null && r.getUser().getId().equals(userId))
                .toList();
    }

    public List<Recipe> getRecipesByCategory(CategoryType categoryType) {
        return recipeRepository.findAll().stream()
                .filter(r -> r.getCategoryType() == categoryType)
                .toList();
    }

    public List<Recipe> getRecipesByFoodType(FoodType foodType) {
        return recipeRepository.findAll().stream()
                .filter(r -> r.getFoodType() == foodType)
                .toList();
    }

    public List<RecipeDTO> getAllAsDTO() {
        return recipeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RecipeDTO getDTOById(Long id) {
        Recipe recipe = getById(id);
        return convertToDTO(recipe);
    }

    public List<RecipeDTO> getRecipesByFoodTypeAsDTO(FoodType foodType) {
        return getRecipesByFoodType(foodType).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<RecipeDTO> getRecipesByCategoryAsDTO(CategoryType category) {
        return getRecipesByCategory(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RecipeDTO createFromDTO(RecipeDTO dto) {
        Recipe recipe = convertToEntity(dto);
        return convertToDTO(recipeRepository.save(recipe));
    }

    public Optional<RecipeDTO> updateRecipeFromDTO(Long id, RecipeDTO dto) {
        return recipeRepository.findById(id).map(existing -> {
            existing.setTitle(dto.getTitle());
            existing.setCalories(dto.getCalories());
            existing.setServings(dto.getServings());
            existing.setFoodType(dto.getFoodType());
            existing.setCategoryType(dto.getCategoryType());
            existing.setIngredients(dto.getIngredients() != null ?
                    dto.getIngredients().stream()
                            .map(this::convertToEntity)
                            .collect(Collectors.toList()) :
                    new ArrayList<>()
            );
            return convertToDTO(recipeRepository.save(existing));
        });
    }

    private RecipeDTO convertToDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setTitle(recipe.getTitle());
        dto.setCalories(recipe.getCalories());
        dto.setServings(recipe.getServings());
        dto.setFoodType(recipe.getFoodType());
        dto.setCategoryType(recipe.getCategoryType());

        if (recipe.getUser() != null) {
            dto.setUserId(recipe.getUser().getId());
            dto.setUserName(recipe.getUser().getUsername());
        }

        if (recipe.getIngredients() != null) {
            dto.setIngredients(recipe.getIngredients().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setIngredients(new ArrayList<>());
            dto.setIngredientNames(new ArrayList<>());
        }

        return dto;
    }

    private Recipe convertToEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setTitle(dto.getTitle());
        recipe.setCalories(dto.getCalories());
        recipe.setServings(dto.getServings());
        recipe.setFoodType(dto.getFoodType());
        recipe.setCategoryType(dto.getCategoryType());
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with ID " + dto.getUserId()));
            recipe.setUser(user);
        }
        if (dto.getIngredients() != null) {
            recipe.setIngredients(dto.getIngredients().stream()
                    .map(this::convertToEntity)
                    .collect(Collectors.toList()));
        } else {
            recipe.setIngredients(new ArrayList<>());
        }
        return recipe;
    }

    private IngredientDTO convertToDTO(Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO();
        dto.setName(ingredient.getName());
        dto.setQuantity(ingredient.getQuantity());
        dto.setMeasurementUnit(ingredient.getMeasurementUnit());
        return dto;
    }

    private Ingredient convertToEntity(IngredientDTO dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());
        ingredient.setQuantity(dto.getQuantity());
        ingredient.setMeasurementUnit(dto.getMeasurementUnit());
        return ingredient;
    }
}