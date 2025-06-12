package com.recipe.recipe_app_backend2025.controller;

import com.recipe.recipe_app_backend2025.model.Ingredient;
import com.recipe.recipe_app_backend2025.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody @Valid Ingredient ingredient) {
        Ingredient saved = ingredientService.save(ingredient);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteIngredien(@PathVariable Long id) {
        if (ingredientService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ingredientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}



