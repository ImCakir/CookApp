package com.example.recipe.cooker.dal;

import com.example.recipe.cooker.entity.Favorite;
import com.example.recipe.cooker.entity.Recipe;
import com.example.recipe.cooker.entity.User;
import com.example.recipe.cooker.repository.IFavoriteRepository;
import com.example.recipe.cooker.repository.IRecipeRepository;
import com.example.recipe.cooker.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
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

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean existsByRecipe(Long id) {
        return recipeRepository.existsById(id);
    }

    public boolean existsByRecipeMealName(String meal)
    {
        return recipeRepository.existsByStrMeal(meal);
    }

    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Optional<Recipe> findByRecipeMeal(String meal_name_str) {
        return recipeRepository.findByStrMeal(meal_name_str);
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

    public boolean existsFavoriteByUser(User user) {
        return favoriteRepository.existsByUser(user);
    }

    public Favorite saveFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public User findOrCreateUserByUsername(String username, String email)
    {
        return userRepository.findByUsername(username)
                .orElseGet(() -> userRepository.save(new User(username, email)));
    }


    public Favorite saveFavorite(User user, Recipe recipe)
    {
        if (!favoriteRepository.existsByUserIdAndRecipeId(user.getId(), recipe.getId())) {
            Favorite fav = new Favorite(user, recipe);
            return favoriteRepository.save(fav);
        }
        return favoriteRepository.findByUserIdAndRecipeId(user.getId(), recipe.getId())
                .orElseGet(() -> new Favorite(user, recipe));
    }

    public Optional<Recipe> findRecipeByMealName(String mealName)
    {
        return recipeRepository.findByStrMeal(mealName);
    }
}













