package com.recipe.recipe_app_backend2025.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recipe.recipe_app_backend2025.enums.MeasurementUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = "recipe")
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
    @JsonIgnore
    private Recipe recipe;

}
