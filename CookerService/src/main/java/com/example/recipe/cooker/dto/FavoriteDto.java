package com.example.recipe.cooker.dto;

import lombok.Data;

@Data
public class FavoriteDto {
    private Long userId;
    private Long recipeId;
}
