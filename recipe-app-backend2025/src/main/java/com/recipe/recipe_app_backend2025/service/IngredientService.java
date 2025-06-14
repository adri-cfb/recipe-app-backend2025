package com.recipe.recipe_app_backend2025.service;

import com.recipe.recipe_app_backend2025.exception.IngredientNotFoundException;
import com.recipe.recipe_app_backend2025.model.Ingredient;
import com.recipe.recipe_app_backend2025.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient getById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException("Ingredient with id " + id + " is not found"));
    }

    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    public Optional<Ingredient> updateIngredient(Long id, Ingredient updateIngredient) {
        return ingredientRepository.findById(id).map(existing ->{
            existing.setName(updateIngredient.getName());
            existing.setQuantity(updateIngredient.getQuantity());
            existing.setMeasurementUnit(updateIngredient.getMeasurementUnit());
            return ingredientRepository.save(existing);
        });
    }

//    public void deleteAllIngredients() {ingredientRepository.deleteAll();}

}
