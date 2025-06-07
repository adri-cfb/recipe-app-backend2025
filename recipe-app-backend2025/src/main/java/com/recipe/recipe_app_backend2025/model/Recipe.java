package com.recipe.recipe_app_backend2025.model;

import com.recipe.recipe_app_backend2025.enums.FoodType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
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
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //TODO: confirmar con Lisa Lombok y borrar Getters Setters contructores, etc

    public Recipe () {
    }

    public Recipe(String title, int servings, int calories, User user, FoodType foodType, List<Ingredient> ingredients) {
        this.title = title;
        this.servings = servings;
        this.calories = calories;
        this.user = user;
        this.foodType = foodType;
        this.category = category;
        this.ingredients = ingredients;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public int getServings() {return servings;}
    public void setServings(int servings) {this.servings = servings;}

    public int getCalories() {return calories;}
    public void setCalories(int calories) {this.calories = calories;}

    public FoodType getFoodType() {return foodType;}
    public void setFoodType(FoodType foodType) {this.foodType = foodType;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public List<Ingredient> getIngredients() {return ingredients;}
    public void setIngredients(List<Ingredient> ingredients) {this.ingredients = ingredients;}

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}


}
