package com.example.recipe.cooker.dal;

import com.example.recipe.cooker.entity.Favorite;
import com.example.recipe.cooker.entity.Recipe;
import com.example.recipe.cooker.entity.User;
import com.example.recipe.cooker.repository.IFavoriteRepository;
import com.example.recipe.cooker.repository.IRecipeRepository;
import com.example.recipe.cooker.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

public class CookerRepositoryHelper {
    private final IFavoriteRepository favoriteRepository;
    private final IRecipeRepository recipeRepository;
    private final IUserRepository userRepository;

    public CookerRepositoryHelper(IUserRepository userRepository,
                                  IRecipeRepository recipeRepository,
                                  IFavoriteRepository favoriteRepository) {
            this.favoriteRepository = favoriteRepository;
            this.recipeRepository = recipeRepository;
            this.userRepository = userRepository;
    }
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean existsByRecipe(Long id) {
        return recipeRepository.existsById(id);
    }

    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public boolean existsByFavorite(Long id) {
        return favoriteRepository.existsById(id);
    }

    public List<Favorite> findFavoriteByUser(User user) {
        return favoriteRepository.findByUser(user);
    }

    public Favorite saveFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

     }













