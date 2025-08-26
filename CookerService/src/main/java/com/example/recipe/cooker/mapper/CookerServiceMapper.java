package com.example.recipe.cooker.mapper;

import com.example.recipe.cooker.dto.MealDto;
import com.example.recipe.cooker.entity.Recipe;
import com.example.recipe.cooker.dto.Meal;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CookerMapperImpl", componentModel = "spring")
public interface CookerServiceMapper {

    MealDto mealDtoToMeal(Meal meal);           //DısServis -> IcServis
    Recipe mealDtoToRecipe(MealDto mealDto);    //IcServis -> Entity
    MealDto recipeToMealDto(Recipe recipe);     //Entity -> IcServis



}
