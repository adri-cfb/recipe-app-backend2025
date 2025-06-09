package com.recipe.recipe_app_backend2025.model;

import com.recipe.recipe_app_backend2025.enums.CategoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Category type is required")
    private CategoryType type;

    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
    private List<Recipe> recipes;

}


