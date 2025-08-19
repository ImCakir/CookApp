package com.example.recipe.cooker.repository;

import com.example.recipe.cooker.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepository extends CrudRepository<Recipe, Long> {
}
