package com.recipe.recipe_app_backend2025.repository;

import com.recipe.recipe_app_backend2025.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
