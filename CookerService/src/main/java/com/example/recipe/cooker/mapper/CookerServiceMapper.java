package com.example.recipe.cooker.mapper;


import com.example.recipe.cooker.dto.FavoriteDto;
import com.example.recipe.cooker.dto.RecipeDto;
import com.example.recipe.cooker.dto.UserDto;
import com.example.recipe.cooker.entity.Favorite;
import com.example.recipe.cooker.entity.Recipe;
import com.example.recipe.cooker.entity.User;
import com.example.recipe.dto.Meal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "CookerMapperImpl", componentModel = "spring")
public interface CookerServiceMapper {

    UserDto userToDto(User user);

    User dtoToUser(UserDto dto);

    RecipeDto recipeToDto(Recipe recipe);

    Recipe dtoToRecipe(RecipeDto dto);

    FavoriteDto favoriteToDto(Favorite favorite);

    Favorite dtoToFavorite(FavoriteDto dto);

    List<RecipeDto> dtosToRecipeDtos(List<Recipe> recipes);

    List<FavoriteDto> dtosToFavoriteDtos(List<Favorite> favorites);

    RecipeDto mealToDto(Meal meal);

}
