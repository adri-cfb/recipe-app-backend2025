package com.recipe.recipe_app_backend2025.exception;

public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String email) {
        super("Email " + email + " already exists. Try a different email");
    }
}
