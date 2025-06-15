package com.recipe.recipe_app_backend2025.dto;

import com.recipe.recipe_app_backend2025.enums.CategoryType;
import com.recipe.recipe_app_backend2025.enums.FoodType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeDTO {
    private Long id;
    private String title;
    private int servings;
    private int calories;
    private FoodType foodType;
    private CategoryType categoryType;
    private Long userId;
    private String userName;
    private List<String> ingredientNames;

    private List<IngredientDTO> ingredients;

}
