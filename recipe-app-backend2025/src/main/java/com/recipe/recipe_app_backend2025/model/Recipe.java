package com.recipe.recipe_app_backend2025.model;

import com.recipe.recipe_app_backend2025.enums.CategoryType;
import com.recipe.recipe_app_backend2025.enums.FoodType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "ingredients",})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Title cannot be blank")
    private String title;

    @Min(value =1, message = "Servings must be at least 1")
    private int servings;

    @Min(value=1, message ="Calories must be 1 calories")
    private int calories;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;



}
