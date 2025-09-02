package com.example.recipe.cooker;

import com.example.recipe.cooker.CookerTheMeal;
import com.example.recipe.cooker.dal.CookerRepositoryHelper;
import com.example.recipe.cooker.dto.MealDto;
import com.example.recipe.cooker.entity.Recipe;
import com.example.recipe.cooker.entity.User;
import com.example.recipe.cooker.mapper.CookerServiceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CookerAppService {
    private final CookerServiceMapper cookerServiceMapper;
    private final CookerRepositoryHelper cookerRepositoryHelper;
    private final CookerTheMeal cookerTheMeal;

    public CookerAppService(CookerServiceMapper cookerServiceMapper,
                            CookerRepositoryHelper cookerRepositoryHelper
                            , CookerTheMeal cookerTheMeal) {

        this.cookerServiceMapper = cookerServiceMapper;
        this.cookerRepositoryHelper = cookerRepositoryHelper;
        this.cookerTheMeal = cookerTheMeal;

    }

    public MealDto searchMealWithProvider(String mealNameStr)
    {
        var providerMeal = cookerTheMeal.searchMeals(mealNameStr).get(0);

        return cookerServiceMapper.mealDtoToMeal(providerMeal);

    }



    @Transactional
    public MealDto saveFavoriteMeal(String mealNameStr, String customerName, Boolean isFavorite) {
        MealDto mealDto = searchMealWithProvider(mealNameStr);

        Recipe recipe = cookerServiceMapper.mealDtoToRecipe(mealDto);

        if (!cookerRepositoryHelper.existsByRecipeMealName(mealNameStr)) {
            recipe = cookerRepositoryHelper.saveRecipe(recipe);
        } else {
            Recipe finalRecipe = recipe;
            recipe = cookerRepositoryHelper.findRecipeByMealName(mealNameStr)
                    .orElseGet(() -> cookerRepositoryHelper.saveRecipe(finalRecipe));
        }

        User user = cookerRepositoryHelper.findOrCreateUserByUsername(customerName, "test@test.com");

        if (isFavorite) {
            cookerRepositoryHelper.saveFavorite(user, recipe);
        }

        return cookerServiceMapper.recipeToMealDto(recipe);
    }
}

