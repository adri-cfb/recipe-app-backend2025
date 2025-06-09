package com.recipe.recipe_app_backend2025.controller;

import com.recipe.recipe_app_backend2025.enums.FoodType;
import com.recipe.recipe_app_backend2025.model.Recipe;
import com.recipe.recipe_app_backend2025.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    //GET all recipes
    @GetMapping
    public List<Recipe> getAllRecipes(){
        return recipeService.getAll();
    }

    //GET recipes by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id){
        return recipeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //POST create new recipe
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        Recipe created = recipeService.createRecipe(recipe);
        return ResponseEntity.ok(created);
    }


    //PUT update existing recipe
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe){
        return ResponseEntity.ok(recipeService.updateRecipe(id, recipe));
    }

    //DELETE recipe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/foodType/{foodType}")
    public ResponseEntity<List<Recipe>> getRecipeByFoodType(@PathVariable FoodType foodType){
        List<Recipe> recipes = recipeService.getRecipesByFoodType();
        return ResponseEntity.ok(recipes);
    }


}
