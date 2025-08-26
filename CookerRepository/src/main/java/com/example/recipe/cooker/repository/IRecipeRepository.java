package com.example.recipe.cooker.repository;

import com.example.recipe.cooker.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByStrMeal(String strMeal);
    boolean existsByStrMeal(String strMeal);
}
