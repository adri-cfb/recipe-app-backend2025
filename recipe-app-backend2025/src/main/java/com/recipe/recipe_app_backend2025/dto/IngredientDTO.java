package com.recipe.recipe_app_backend2025.dto;

import com.recipe.recipe_app_backend2025.enums.MeasurementUnit;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class IngredientDTO {
    private String name;
    private Double quantity;
    private MeasurementUnit measurementUnit;
}
