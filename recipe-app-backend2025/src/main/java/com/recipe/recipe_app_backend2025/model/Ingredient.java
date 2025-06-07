package com.recipe.recipe_app_backend2025.model;

import com.recipe.recipe_app_backend2025.enums.MeasurementUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "El nombre del ingrediente no puede estar vacío.")
    private String name;

    @NotNull(message="La cantidad es obligatoria")
    @Positive (message= "La cantidad debe ser mayor que cero.")
    private Double quantity;

    @NotNull (message = "La unidad de medida es obligatoria")
    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    //TODO: confirmar con Lisa Lombok y borrar Getters Setters contructores, etc

    public Ingredient (){
    }

    public Ingredient(String name, Double quantity, MeasurementUnit measurementUnit, Recipe recipe) {
        this.name = name;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.recipe = recipe;
    }

    public Long getId() { return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Double getQuantity() {return quantity;}
    public void setQuantity(Double quantity) {this.quantity = quantity;}

    public MeasurementUnit getMeasurementUnit() {return measurementUnit;}
    public void setMeasurementUnit(MeasurementUnit measurementUnit) {this.measurementUnit = measurementUnit;}

    public Recipe getRecipe() {return recipe;}
    public void setRecipe(Recipe recipe) {this.recipe = recipe;}

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredient(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return name + " (" + quantity + " " + measurementUnit + ")";
    }



}
}
