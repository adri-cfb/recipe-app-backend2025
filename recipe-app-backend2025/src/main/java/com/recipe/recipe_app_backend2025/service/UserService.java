package com.recipe.recipe_app_backend2025.service;

import java.util.Optional;
import java.util.List;


import com.recipe.recipe_app_backend2025.dto.UserDTO;
import com.recipe.recipe_app_backend2025.exception.EmailExistsException;
import com.recipe.recipe_app_backend2025.exception.UserNotFoundException;
import com.recipe.recipe_app_backend2025.model.User;
import com.recipe.recipe_app_backend2025.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " is not found"));
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    public User createUser(User user){
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new EmailExistsException(user.getEmail());
        }
        return userRepository.save(user);
    }

    public Optional <User> updateUser(Long id, User updateUser){
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUsername(updateUser.getUsername());
            existingUser.setEmail(updateUser.getEmail());
            existingUser.setPassword(updateUser.getPassword());
            existingUser.setRole(updateUser.getRole());
            return userRepository.save(existingUser);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    public void deleteAllUsers() {userRepository.deleteAll();}

    public UserDTO convertToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        return user;
    }

}
