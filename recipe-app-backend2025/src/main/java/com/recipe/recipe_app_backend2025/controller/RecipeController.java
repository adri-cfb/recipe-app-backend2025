package com.recipe.recipe_app_backend2025.controller;

import com.recipe.recipe_app_backend2025.dto.RecipeDTO;
import com.recipe.recipe_app_backend2025.enums.FoodType;
import com.recipe.recipe_app_backend2025.enums.CategoryType;
import com.recipe.recipe_app_backend2025.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // GET all recipes
    @GetMapping
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllAsDTO();
    }

    // GET recipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) {
        RecipeDTO recipeDTO = recipeService.getDTOById(id);
        return ResponseEntity.ok(recipeDTO);
    }

    // POST create recipe
    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        RecipeDTO created = recipeService.createFromDTO(recipeDTO);
        return ResponseEntity.ok(created);
    }

    // PUT update recipe
    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id, @Valid @RequestBody RecipeDTO recipeDTO) {
        return recipeService.updateRecipeFromDTO(id, recipeDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE recipe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    // GET recipes by FoodType
    @GetMapping("/foodType/{foodType}")
    public ResponseEntity<List<RecipeDTO>> getRecipeByFoodType(@PathVariable FoodType foodType) {
        List<RecipeDTO> recipes = recipeService.getRecipesByFoodTypeAsDTO(foodType);
        return ResponseEntity.ok(recipes);
    }

    // GET recipes by CategoryType
    @GetMapping("/category/{category}")
    public ResponseEntity<List<RecipeDTO>> getRecipeByCategory(@PathVariable CategoryType category) {
        List<RecipeDTO> recipes = recipeService.getRecipesByCategoryAsDTO(category);
        return ResponseEntity.ok(recipes);
    }
}