package com.recipe.recipe_app_backend2025.repository;

import com.recipe.recipe_app_backend2025.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameyUsername(String username);
    User findByEmail(String email);
}
